package com.project.common.hc.http.delegation;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.project.common.hc.assertion.AssertParameter;
import com.project.common.hc.common.UrlUtils;
import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.filter.Filter;
import com.project.common.hc.http.FRequest;
import com.project.common.hc.http.FResponse;
import com.project.common.hc.http.IFResponse;
import com.project.common.hc.http.RequestType;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

public class RequestExecutor {
    private static final Logger log = LoggerFactory.getLogger(RequestExecutor.class);
    private static final char PARAM_START_SEPARATOR = '?';
    private static final char PARAM_BETWEEN_SEPARATOR = '&';
    private static final int DEFAULT_HYSTRIX_TIMEOUT = 10000;
    private static final int DEFAULT_HYSTRIX_THREAD_POOL_CORE_SIZE = 10;
    private static final String CHARENC_UTF_8 = "utf-8";
    private final FRequest fRequest;
    private Map<String, String> mdcContext;
    ThreadLocal<Long> processTime = new ThreadLocal();

    public RequestExecutor(FRequest fRequest) {
        this.fRequest = fRequest;
    }

    public IFResponse execute() throws IOException {
        Map<String, String> childMDCContext = MDC.getCopyOfContextMap();
        this.processTime.set(System.currentTimeMillis());

        try {
            if (MapUtils.isNotEmpty(this.mdcContext)) {
                MDC.setContextMap(this.mdcContext);
            }

            log.trace("The MDC context is: " + JSON.toJSONString(this.mdcContext));
            log.trace("The request is: " + this.fRequest.toString());
            AssertParameter.notNull(this.fRequest.getBaseUrl(), "base url");
            Iterator var2 = this.fRequest.getFilters().iterator();

            while(var2.hasNext()) {
                Filter filter = (Filter)var2.next();
                log.trace(MessageFormat.format("Invoke filter [{0}] on event beforeExecute().", filter.getClass().getSimpleName()));
                filter.beforeExecute(this.fRequest);
            }

            Request request = this.buildRequest();
            FResponse fResponse = this.doRequest(request);
            fResponse.setRequest(this.fRequest);
            Iterator var4 = this.fRequest.getFilters().iterator();

            while(var4.hasNext()) {
                Filter filter = (Filter)var4.next();
                log.trace(MessageFormat.format("Invoke filter [{0}] on event afterExecute().", filter.getClass().getSimpleName()));
                filter.afterExecute(this.fRequest, fResponse);
            }

            FResponse var11 = fResponse;
            return var11;
        } finally {
            this.fRequest.setProcessTime(System.currentTimeMillis() - (Long)this.processTime.get());
            log.info("FluentHC process time : [{}ms]", this.fRequest.getProcessTime());
            this.processTime.remove();
            MDC.clear();
            if (MapUtils.isNotEmpty(childMDCContext)) {
                MDC.setContextMap(childMDCContext);
            }

        }
    }
    public IFResponse executeAndFilestream() throws IOException {
        Map<String, String> childMDCContext = MDC.getCopyOfContextMap();
        this.processTime.set(System.currentTimeMillis());

        try {
            if (MapUtils.isNotEmpty(this.mdcContext)) {
                MDC.setContextMap(this.mdcContext);
            }

            log.trace("The MDC context is: " + JSON.toJSONString(this.mdcContext));
            log.trace("The request is: " + this.fRequest.toString());
            AssertParameter.notNull(this.fRequest.getBaseUrl(), "base url");
            Iterator var2 = this.fRequest.getFilters().iterator();

            while(var2.hasNext()) {
                Filter filter = (Filter)var2.next();
                log.trace(MessageFormat.format("Invoke filter [{0}] on event beforeExecute().", filter.getClass().getSimpleName()));
                filter.beforeExecute(this.fRequest);
            }

            Request request = this.buildRequest();
            IFResponse fResponse = this.doRequestAndFilestream(request);


            return fResponse;
        } finally {
            this.fRequest.setProcessTime(System.currentTimeMillis() - (Long)this.processTime.get());
            log.info("FluentHC process time : [{}ms]", this.fRequest.getProcessTime());
            this.processTime.remove();
            MDC.clear();
            if (MapUtils.isNotEmpty(childMDCContext)) {
                MDC.setContextMap(childMDCContext);
            }

        }
    }
    private Request buildRequest() {
        this.fRequest.setAssembleUrl(this.assembleUrl());
        Request.Builder requestBuilder = (new Request.Builder()).url(this.fRequest.getAssembleUrl());
        String path = UrlUtils.getEncodedPath(this.fRequest.getBaseUrl());
        requestBuilder.tag(StringUtils.defaultIfEmpty(this.fRequest.getKey(), path));
        Iterator var3 = this.fRequest.getHeaders().iterator();

        while(var3.hasNext()) {
            FRequest.Header header = (FRequest.Header) var3.next();
            requestBuilder.addHeader(header.getName(), header.getValue());
        }

        if (CollectionUtils.isNotEmpty(this.fRequest.getCookies())) {
            requestBuilder.addHeader("Cookie", StringUtils.join(this.fRequest.getCookies(), "; "));
        }

        boolean needProcessRequestBody = RequestType.POST == this.fRequest.getRequestType() || RequestType.PUT == this.fRequest.getRequestType() || RequestType.PATCH == this.fRequest.getRequestType();
        if (needProcessRequestBody) {
            if (this.fRequest.getRequestBody() == null) {
                this.assemblePostRequestBodyByFormParams();
            }

            if (this.fRequest.getRequestBody() == null) {
                String msg = MessageFormat.format(">>>>REQUEST BODY IS NULL<<<< {0}", this.getRequestLogInfo());
                log.warn(msg);
                throw new IllegalArgumentException(msg);
            }
        }

        switch(this.fRequest.getRequestType()) {
            case PUT:
                requestBuilder.put(this.fRequest.getRequestBody());
                break;
            case PATCH:
                requestBuilder.patch(this.fRequest.getRequestBody());
                break;
            case POST:
                requestBuilder.post(this.fRequest.getRequestBody());
                break;
            case DELETE:
                requestBuilder.delete(this.fRequest.getRequestBody());
                break;
            default:
                requestBuilder.get();
        }

        return requestBuilder.build();
    }

    private FResponse doRequest(Request request) throws IOException {
        log.info("REQUEST >>>>>>>> {}.", this.getRequestLogInfo());

        Response response;
        try {
            response = this.fRequest.getClient().newCall(request).execute();
        } catch (IOException var4) {
            log.warn(">>>>REQUEST IO EXCEPTION<<<< {}", this.getRequestLogInfo(), var4);
            throw var4;
        } catch (Exception var5) {
            log.warn(">>>>REQUEST UNKNOWN EXCEPTION<<<< {}", this.getRequestLogInfo(), var5);
            throw var5;
        }
        FResponse fResponse = FResponse.builder().code(response.code()).message(response.message()).headers(response.headers()).logContentLevel(this.fRequest.getLogContentLevel()).body(response.body().string()).rawResponse(response).build();
        log.info("RESPONSE <<<<<<<< " + this.getResponseLogInfo(fResponse));
        if (!fResponse.httpSuccess()) {
            log.warn(">>>>RESPONSE [{}] FAILED<<<< Response: [{}]. Request: [{}].", new Object[]{fResponse.getCode(), this.getResponseLogInfo(fResponse), this.getRequestLogInfo()});
        }

        return fResponse;
    }
    private IFResponse doRequestAndFilestream(Request request) throws IOException {
        log.info("REQUEST >>>>>>>> {}.", this.getRequestLogInfo());

        Response response;
        try {
            long start = System.currentTimeMillis();
            response = this.fRequest.getClient().newCall(request).execute();
            System.out.println("请求华泰接口耗时：----------------------------------------：" + String.valueOf(System.currentTimeMillis()-start));
        } catch (IOException var4) {
            log.warn(">>>>REQUEST IO EXCEPTION<<<< {}", this.getRequestLogInfo(), var4);
            throw var4;
        } catch (Exception var5) {
            log.warn(">>>>REQUEST UNKNOWN EXCEPTION<<<< {}", this.getRequestLogInfo(), var5);
            throw var5;
        }

        FResponse fResponse = FResponse.builder().code(response.code()).message(response.message()).headers(response.headers()).logContentLevel(this.fRequest.getLogContentLevel()).rawResponse(response).build();
        return fResponse;
    }

    protected String getRequestLogInfo() {
        return this.fRequest.getRequestInfo();
    }

    private String getResponseLogInfo(FResponse fResponse) {
        return fResponse.getResponseInfo();
    }



    private String assembleUrl() {
        if (CollectionUtils.isEmpty(this.fRequest.getParams())) {
            return this.fRequest.getBaseUrl();
        } else {
            StringBuilder urlBuilder = (new StringBuilder()).append(this.fRequest.getBaseUrl());
            if (urlBuilder.indexOf(String.valueOf('?')) > -1) {
                urlBuilder.append('&');
            } else {
                urlBuilder.append('?');
            }

            Iterator var2 = this.fRequest.getParams().iterator();

            while(var2.hasNext()) {
                FRequest.Param param = (FRequest.Param)var2.next();
                if (param.getValue() != null) {
                    String value = param.getValue().toString();
                    if (param.isEncode()) {
                        try {
                            value = URLEncoder.encode(String.valueOf(param.getValue()), "utf-8");
                        } catch (UnsupportedEncodingException var6) {
                        }
                    }

                    urlBuilder.append(param.getName()).append("=").append(value).append('&');
                }
                //对tabType为null时增加url参数拼接tabType=
                if(param.getName().equals("tabType")){
                    urlBuilder.append(param.getName()).append("=").append('&');
                }
            }

            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            return urlBuilder.toString();
        }
    }

    private void assemblePostRequestBodyByFormParams() {
        if (CollectionUtils.isEmpty(this.fRequest.getFormParams())) {
            try {
                this.fRequest.requestBody("");
            } catch (RequestBodyParseException var4) {
            }

        } else {
            Map<String, Object> params = Maps.newHashMap();
            Iterator var2 = this.fRequest.getFormParams().iterator();

            while(var2.hasNext()) {
                FRequest.Param formParam = (FRequest.Param)var2.next();
                params.put(formParam.getName(), formParam.getValue());
            }

            try {
                this.fRequest.requestBody(params);
            } catch (RequestBodyParseException var5) {
            }

        }
    }
}
