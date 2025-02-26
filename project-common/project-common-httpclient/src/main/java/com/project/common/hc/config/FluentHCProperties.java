package com.project.common.hc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
        prefix = "fluent-hc"
)
public class FluentHCProperties
{
    private Integer okHttpConnectTimeout;
    private Integer okHttpWriteTimeout;
    private Integer okHttpReadTimeout;

    private String systemId;
    private String htSecret;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getHtSecret() {
        return htSecret;
    }

    public void setHtSecret(String htSecret) {
        this.htSecret = htSecret;
    }

    public Integer getOkHttpConnectTimeout() {
        return okHttpConnectTimeout;
    }

    public void setOkHttpConnectTimeout(Integer okHttpConnectTimeout) {
        this.okHttpConnectTimeout = okHttpConnectTimeout;
    }

    public Integer getOkHttpWriteTimeout() {
        return okHttpWriteTimeout;
    }

    public void setOkHttpWriteTimeout(Integer okHttpWriteTimeout) {
        this.okHttpWriteTimeout = okHttpWriteTimeout;
    }

    public Integer getOkHttpReadTimeout() {
        return okHttpReadTimeout;
    }

    public void setOkHttpReadTimeout(Integer okHttpReadTimeout) {
        this.okHttpReadTimeout = okHttpReadTimeout;
    }
}