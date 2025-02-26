package com.project.common.hc.http;

import com.google.common.base.Optional;
import com.project.common.hc.exception.ObjectParseException;
import okhttp3.Headers;
import javax.servlet.http.HttpServletResponse;

public interface IFResponse {
    String body();

    <R> R body(Class<R> var1) throws ObjectParseException;

    <R> Optional<R> getResult(Class<R> var1);

    Boolean httpSuccess();

    Headers headers();

    String header(String var1);

    Integer code();

    String message();

    IFRequest request();

    String getResponseInfo();
    void getResponse(HttpServletResponse response, String showFlag);
}
