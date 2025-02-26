package com.project.common.hc.http;

import com.google.common.base.Optional;
import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.filter.Filter;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IFRequest {

    IFResponse get() throws IOException, InterruptedException, ExecutionException;

    IFResponse filestream() throws IOException, InterruptedException, ExecutionException;

    IFResponse get(String var1) throws IOException, ExecutionException, InterruptedException;

    <R> Optional<R> getResult(Class<R> var1);

    Optional<String> getResult();

    IFResponse post() throws IOException, InterruptedException, ExecutionException;

    <R> Optional<R> postResult(Class<R> var1);

    Optional<String> postResult();

    IFResponse post(String var1) throws IOException, InterruptedException, ExecutionException;


    IFResponse put() throws InterruptedException, ExecutionException, IOException;


    IFResponse patch() throws InterruptedException, ExecutionException, IOException;


    IFResponse delete() throws InterruptedException, ExecutionException, IOException;


    IFRequest requestBody(RequestBody var1);

    IFRequest requestBody(Object var1) throws RequestBodyParseException, RequestBodyParseException;

    IFRequest requestBody(Object var1, ContentType var2) throws RequestBodyParseException;

    IFRequest cookies(String... var1);

    IFRequest key(String var1);

    IFRequest param(String var1, Object var2);

    IFRequest param(String var1, Object var2, boolean var3);

    IFRequest formParam(String var1, Object var2);

    IFRequest contentType(ContentType var1);

    IFRequest header(String var1, String var2);

    IFRequest filter(Filter var1);

    IFRequest noFilters();

    IFRequest url(String var1);

    IFRequest logContentLevel(LogContentLevel var1);

    String getRequestInfo();

    /**
     * @deprecated
     */
    @Deprecated
    IFRequest disableBodyResponse();
}
