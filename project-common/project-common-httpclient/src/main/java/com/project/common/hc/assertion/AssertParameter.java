package com.project.common.hc.assertion;

import java.text.MessageFormat;

public class AssertParameter {
    public AssertParameter() {
    }

    public static <T> T notNull(T o, Class paramClass) {
        return notNull(o, paramClass.getSimpleName());
    }

    public static <T> T notNull(T o, String paramName) {
        if (o == null) {
            throw new IllegalArgumentException(MessageFormat.format("{0} cannot be null.", paramName));
        } else {
            return o;
        }
    }

    public static Long parseLong(String o, String paramName) {
        try {
            return Long.parseLong(o);
        } catch (NumberFormatException var3) {
            throw new IllegalArgumentException(MessageFormat.format("{0} is not long type.", paramName));
        }
    }
}
