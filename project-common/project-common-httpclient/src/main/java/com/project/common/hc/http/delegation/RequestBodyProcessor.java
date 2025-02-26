package com.project.common.hc.http.delegation;

import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.http.FRequest;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestBodyProcessor {
    private static final Logger log = LoggerFactory.getLogger(RequestBodyProcessor.class);
    private final FRequest fRequest;

    public RequestBodyProcessor(FRequest fRequest) {
        this.fRequest = fRequest;
    }

    public RequestBody requestBody(Object requestObject) throws RequestBodyParseException {
        AbstractBodyProcesser processer = AbstractBodyProcesser.getInstance(this.fRequest.getContentType());
        if (processer == null) {
            return null;
        } else {
            String requestBody = processer.processRequestBody(requestObject);
            log.debug("Assemble the request body. ContentType:[{}] Request body:[{}]", this.fRequest.getContentType(), requestBody);
            this.fRequest.setRawRequestBody(requestBody);
            return RequestBody.create(MediaType.parse(this.fRequest.getContentType().getContentType()), requestBody);
        }
    }
}