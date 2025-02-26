package com.project.common.hc.thirdparty.filecabinet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FileCabinetRequest {

    private String username;
    private String usernameType;
    private String category;
    private String app;
    private File file;

}
