package com.project.common.hc.thirdparty.filecabinet.dto;

import lombok.Data;


@Data
public class FileCabinetResponse {
    private String code;
    private String msg;
    private String data;


    public boolean success() {
        return "200".equals(code);
    }
}
