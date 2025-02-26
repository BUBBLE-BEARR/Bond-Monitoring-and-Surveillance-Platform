package com.project.common.core.jackson.filter;

import java.math.BigDecimal;

public class CustomFilter {
    @Override
    public boolean equals(Object obj) {
        // null，就返回true，意味着不被序列化
        if(null == obj) {
            return true;
        }
        // 是BigDecimal并且值为0 就返回true，意味着不被序列化
        if(obj instanceof BigDecimal && ((BigDecimal) obj).compareTo(new BigDecimal("0")) == 0) {
            return true;
        }

        return false;
    }
}
