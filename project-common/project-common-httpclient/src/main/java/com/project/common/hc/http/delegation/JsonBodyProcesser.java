package com.project.common.hc.http.delegation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class JsonBodyProcesser extends AbstractBodyProcesser {
    private static final Logger log = LoggerFactory.getLogger(JsonBodyProcesser.class);
    protected static final ObjectMapper mapper = new ObjectMapper();

    JsonBodyProcesser() {
    }

    public String processRequestBody(Object requestObject) {
        try {
            return mapper.writeValueAsString(requestObject);
        } catch (JsonProcessingException var3) {
            log.warn("Failed to covert request object [{}] to json. ", requestObject, var3);
            return null;
        }
    }
}