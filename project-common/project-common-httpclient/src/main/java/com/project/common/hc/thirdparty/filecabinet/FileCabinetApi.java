package com.project.common.hc.thirdparty.filecabinet;

import com.google.common.base.Optional;
import com.project.common.hc.FluentHC;
import com.project.common.hc.config.ApiUrlProperties;
import com.project.common.hc.thirdparty.filecabinet.dto.FileCabinetRequest;
import com.project.common.hc.thirdparty.filecabinet.dto.FileCabinetResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;

@Slf4j
@Service
public class FileCabinetApi {

    @Autowired
    FluentHC fluentHC;

    @Autowired
    ApiUrlProperties apiUrlProperties;

    public Optional<FileCabinetResponse> upload(FileCabinetRequest request) {

        File file = request.getFile();
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", String.valueOf(request.getUsername()))
                .addFormDataPart("usernameType", String.valueOf(request.getUsernameType()))
                .addFormDataPart("category", String.valueOf(request.getCategory()))
                .addFormDataPart("app", String.valueOf(request.getApp()))
                .addFormDataPart("fileStream", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file))
                .build();
        Optional<FileCabinetResponse> result;
        try {
            result = fluentHC.call()
                    .url(apiUrlProperties.getFilingCabinetUrl())
                    .requestBody(multipartBody)
                    .post()
                    .getResult(FileCabinetResponse.class);
            if (!result.isPresent() || !result.get().success()) {
                log.info("file cabinet uplaod fail, fileName: " + file.getName());
                return Optional.absent();
            }

            return result;

        }catch (Exception e) {
            log.error("file cabinet uplaod fail: " + e.getMessage(), e);
            return Optional.absent();
        }
    }

}
