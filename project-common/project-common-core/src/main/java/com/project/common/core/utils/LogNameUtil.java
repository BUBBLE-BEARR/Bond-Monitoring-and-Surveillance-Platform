package com.project.common.core.utils;

import ch.qos.logback.core.PropertyDefinerBase;
import com.project.common.core.utils.ip.IpUtils;

public class LogNameUtil extends PropertyDefinerBase {
	@Override
    public String getPropertyValue() {
        return IpUtils.getHostIp();
    }
}
