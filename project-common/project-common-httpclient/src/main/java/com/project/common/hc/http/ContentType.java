package com.project.common.hc.http;

public enum ContentType {
    APPLICATION_JSON("application/json;charset=UTF-8"),
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded");

    private String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return this.contentType;
    }
}