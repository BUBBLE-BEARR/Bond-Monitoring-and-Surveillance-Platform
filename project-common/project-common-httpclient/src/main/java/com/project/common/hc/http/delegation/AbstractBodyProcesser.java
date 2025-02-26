package com.project.common.hc.http.delegation;

import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.http.ContentType;

abstract class AbstractBodyProcesser {
    AbstractBodyProcesser() {
    }

    public static AbstractBodyProcesser getInstance(ContentType contentType) {
        switch(contentType) {
            case APPLICATION_JSON:
                return new JsonBodyProcesser();
            case APPLICATION_X_WWW_FORM_URLENCODED:
                return new FormUrlencodedBodyProcesser();
            default:
                return null;
        }
    }

    abstract String processRequestBody(Object var1) throws RequestBodyParseException;
}
