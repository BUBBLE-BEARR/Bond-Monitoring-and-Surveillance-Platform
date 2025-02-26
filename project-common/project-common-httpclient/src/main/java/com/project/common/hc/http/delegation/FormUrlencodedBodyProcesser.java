package com.project.common.hc.http.delegation;

import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.http.ContentType;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

class FormUrlencodedBodyProcesser extends AbstractBodyProcesser {
    private static final Logger log = LoggerFactory.getLogger(FormUrlencodedBodyProcesser.class);
    private static final String CHARENC_UTF_8 = "utf-8";

    FormUrlencodedBodyProcesser() {
    }

    public String processRequestBody(Object requestObject) throws RequestBodyParseException {
        Map requestMap;
        if (requestObject instanceof Map) {
            requestMap = (Map)requestObject;
        } else {
            try {
                requestMap = BeanUtils.describe(requestObject);
                requestMap.remove("class");
            } catch (Exception var8) {
                String msg = MessageFormat.format("Failed to convert the request body. ContentType:[{0}] Request body:[{1}]", ContentType.APPLICATION_X_WWW_FORM_URLENCODED.getContentType(), requestObject);
                log.debug(msg);
                throw new RequestBodyParseException(msg, var8);
            }
        }

        if (requestMap == null) {
            String msg = MessageFormat.format("Failed to convert the request body, the request object is null. ContentType:[{0}] RequestBody:[{1}]", ContentType.APPLICATION_X_WWW_FORM_URLENCODED.getContentType(), requestObject);
            log.debug(msg);
            throw new RequestBodyParseException(msg);
        } else {
            Iterator<Map.Entry<Object, Object>> requestItr = requestMap.entrySet().iterator();
            StringBuilder params = new StringBuilder();

            while(true) {
                while(requestItr.hasNext()) {
                    Map.Entry<Object, Object> entry = (Map.Entry)requestItr.next();
                    if (entry.getValue() == null) {
                        params.append(entry.getKey()).append("=").append("&");
                    } else {
                        String value;
                        try {
                            value = URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8");
                        } catch (UnsupportedEncodingException var9) {
                            continue;
                        }

                        params.append(entry.getKey()).append("=").append(value).append("&");
                    }
                }

                if (params.length() > 0) {
                    params.deleteCharAt(params.length() - 1);
                }

                return params.toString();
            }
        }
    }
}