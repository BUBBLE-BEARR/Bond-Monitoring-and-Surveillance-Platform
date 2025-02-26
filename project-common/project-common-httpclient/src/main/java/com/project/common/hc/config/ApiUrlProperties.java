package com.project.common.hc.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "thirdparty-api")
@Data
@ToString
public class ApiUrlProperties {
    /**
     * 文件柜url
     */
    private String filingCabinetUrl;
}
