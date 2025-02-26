package com.project.common.hc.http;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.project.common.hc.exception.RequestBodyParseException;
import com.project.common.hc.filter.Filter;
import com.project.common.hc.http.delegation.RequestBodyProcessor;
import com.project.common.hc.http.delegation.RequestExecutor;
import okhttp3.Call;
import okhttp3.RequestBody;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class FRequest implements IFRequest {
    private static final Logger log = LoggerFactory.getLogger(FRequest.class);
    private static final char PARAM_VALUE_SEPARATOR = ',';
    private final Call.Factory client;
    private final RequestExecutor requestExecutor = new RequestExecutor(this);
    private final RequestBodyProcessor requestBodyProcessor = new RequestBodyProcessor(this);
    private final List<Param> params = Lists.newArrayList();
    private final List<Param> formParams = Lists.newArrayList();
    private final List<Header> headers = Lists.newArrayList();
    private final List<Cookie> cookies = Lists.newArrayList();
    private String baseUrl;
    private String assembleUrl;
    private RequestType requestType;
    private String key;
    private ContentType contentType;
    private String rawRequestBody;
    private RequestBody requestBody;
    private String hystrixGroup;
    private String hystrixPool;
    private String hystrixCommand;
    private Integer hystrixTimeout;
    private Integer hystrixThreadPoolCoreSize;
    private final List<Filter> filters;
    private boolean hystrixEnabled;
    private boolean bodyResponseEnabled;
    private long processTime;
    private LogContentLevel logContentLevel;

    public FRequest(Call.Factory client) {
        this.requestType = RequestType.GET;
        this.contentType = ContentType.APPLICATION_JSON;
        this.filters = Lists.newArrayList();
        this.hystrixEnabled = false;
        this.bodyResponseEnabled = true;
        this.logContentLevel = LogContentLevel.DETAIL;
        this.client = client;
    }

    public IFResponse get(String path) throws IOException, ExecutionException, InterruptedException {
        this.baseUrl = path;
        return this.get();
    }

    public IFResponse get() throws IOException, InterruptedException, ExecutionException {
        this.setRequestType(RequestType.GET);
        return this.executeHttpRequest();
    }

    @Override
    public IFResponse filestream() throws IOException, InterruptedException, ExecutionException {
        this.setRequestType(RequestType.GET);
        return this.executeHttpRequestAndFilestream();
    }

    private IFResponse executeHttpRequestAndFilestream() throws IOException, InterruptedException, ExecutionException {
        try {
            return this.requestExecutor.executeAndFilestream();
        } catch (Exception var2) {
            log.info("##{},{},{},{}", new Object[]{org.apache.commons.lang.StringUtils.defaultIfEmpty(this.getKey(), this.getBaseUrl()), "ERROR", "PROXY", this.processTime});
            throw var2;
        }
    }

    public <R> Optional<R> getResult(Class<R> clazz) {
        IFResponse ifResponse;
        try {
            ifResponse = this.get();
        } catch (InterruptedException | ExecutionException | IOException var4) {
            return Optional.absent();
        }

        return ifResponse.getResult(clazz);
    }

    public Optional<String> getResult() {
        try {
            IFResponse ifResponse = this.get();
            String rtn = ifResponse.body();
            return StringUtils.isBlank(rtn) ? Optional.of("") : Optional.of(rtn);
        } catch (InterruptedException | ExecutionException | IOException var3) {
            return Optional.absent();
        }
    }

    public <R> Optional<R> postResult(Class<R> clazz) {
        IFResponse ifResponse;
        try {
            ifResponse = this.post();
        } catch (InterruptedException | ExecutionException | IOException var4) {
            return Optional.absent();
        }

        return ifResponse.getResult(clazz);
    }

    public Optional<String> postResult() {
        try {
            IFResponse ifResponse = this.post();
            String rtn = ifResponse.body();
            return StringUtils.isBlank(rtn) ? Optional.of("") : Optional.of(rtn);
        } catch (InterruptedException | ExecutionException | IOException var3) {
            return Optional.absent();
        }
    }

    public IFResponse post(String path) throws IOException, InterruptedException, ExecutionException {
        this.baseUrl = path;
        return this.post();
    }

    public IFResponse post() throws IOException, InterruptedException, ExecutionException {
        this.setRequestType(RequestType.POST);
        return this.executeHttpRequest();
    }

    public IFResponse put() throws InterruptedException, ExecutionException, IOException {
        this.setRequestType(RequestType.PUT);
        return this.executeHttpRequest();
    }

    public IFResponse patch() throws InterruptedException, ExecutionException, IOException {
        this.setRequestType(RequestType.PATCH);
        return this.executeHttpRequest();
    }


    public IFResponse delete() throws InterruptedException, ExecutionException, IOException {
        this.setRequestType(RequestType.DELETE);
        return this.executeHttpRequest();
    }


    private IFResponse executeHttpRequest() throws IOException, InterruptedException, ExecutionException {
        try {
            return this.requestExecutor.execute();
        } catch (Exception var2) {
            log.info("##{},{},{},{}", new Object[]{org.apache.commons.lang.StringUtils.defaultIfEmpty(this.getKey(), this.getBaseUrl()), "ERROR", "PROXY", this.processTime});
            throw var2;
        }
    }

    public IFRequest contentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public IFRequest requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public IFRequest requestBody(Object requestObject) throws RequestBodyParseException {
        this.requestBody = this.requestBodyProcessor.requestBody(requestObject);
        return this;
    }

    public IFRequest requestBody(Object requestObject, ContentType contentType) throws RequestBodyParseException {
        this.contentType = contentType;
        this.requestBody = this.requestBodyProcessor.requestBody(requestObject);
        return this;
    }

    public IFRequest cookies(String... cookies) {
        if (cookies == null) {
            return this;
        } else {
            Iterator var2 = Arrays.asList(cookies).iterator();

            while(var2.hasNext()) {
                String cookie = (String)var2.next();
                this.cookies.add(Cookie.builder().cookie(cookie).build());
            }

            return this;
        }
    }

    public IFRequest key(String key) {
        if (StringUtils.isNotBlank(key)) {
            this.key = key;
        }

        return this;
    }

    public IFRequest param(String name, Object value) {
        this.param(name, value, true);
        return this;
    }

    public IFRequest param(String name, Object value, boolean needEncode) {
        if ((!StringUtils.isBlank(name) && value != null) || "tabType".equals(name)) {
            this.params.add(Param.builder().name(name).value(value).encode(needEncode).build());
            return this;
        } else {
            return this;
        }
    }


    public IFRequest formParam(String name, Object value) {
        if (StringUtils.isBlank(name)) {
            return this;
        } else {
            this.formParams.add(Param.builder().name(name).value(value).build());
            return this;
        }
    }

    public IFRequest header(String headerName, String headerValue) {
        this.headers.add(Header.builder().name(headerName).value(headerValue).build());
        return this;
    }


    public IFRequest filter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public IFRequest noFilters() {
        this.filters.clear();
        return this;
    }

    public IFRequest url(String basePath) {
        this.baseUrl = basePath;
        return this;
    }

    public IFRequest logContentLevel(LogContentLevel level) {
        this.logContentLevel = level;
        return this;
    }

    public IFRequest disableBodyResponse() {
        this.bodyResponseEnabled = false;
        return this;
    }

    public String getRequestInfo() {
        StringBuilder log = new StringBuilder();
        log.append("Method: [").append(this.getRequestType()).append("]. ");
        log.append("Url: [").append(this.assembleUrl == null ? this.getBaseUrl() : this.assembleUrl).append("]. ");
        if (CollectionUtils.isNotEmpty(this.getParams())) {
            log.append("Params: ").append(this.getParams()).append(". ");
        }

        if (this.getLogContentLevel() == LogContentLevel.SHORT) {
            return log.toString();
        } else {
            if (CollectionUtils.isNotEmpty(this.getHeaders())) {
                log.append("Headers: ").append(this.getHeaders()).append(". ");
            }

            if (CollectionUtils.isNotEmpty(this.getFormParams())) {
                log.append("FormParams: ").append(this.getFormParams()).append(". ");
            }

            if (this.getLogContentLevel() == LogContentLevel.NORMAL) {
                return log.toString();
            } else {
                if (this.getRawRequestBody() != null) {
                    log.append("ContentType: [").append(this.getContentType() == null ? "null" : this.getContentType().getContentType()).append("]. ");
                    log.append("RequestBody: [").append(this.getRawRequestBody()).append("]. ");
                }

                return log.toString();
            }
        }
    }

    public Call.Factory getClient() {
        return this.client;
    }

    public RequestExecutor getRequestExecutor() {
        return this.requestExecutor;
    }

    public RequestBodyProcessor getRequestBodyProcessor() {
        return this.requestBodyProcessor;
    }

    public List<Param> getParams() {
        return this.params;
    }

    public List<Param> getFormParams() {
        return this.formParams;
    }

    public List<Header> getHeaders() {
        return this.headers;
    }

    public List<Cookie> getCookies() {
        return this.cookies;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getAssembleUrl() {
        return this.assembleUrl;
    }

    public RequestType getRequestType() {
        return this.requestType;
    }

    public String getKey() {
        return this.key;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getRawRequestBody() {
        return this.rawRequestBody;
    }

    public RequestBody getRequestBody() {
        return this.requestBody;
    }


    public List<Filter> getFilters() {
        return this.filters;
    }


    public boolean isBodyResponseEnabled() {
        return this.bodyResponseEnabled;
    }

    public long getProcessTime() {
        return this.processTime;
    }

    public LogContentLevel getLogContentLevel() {
        return this.logContentLevel;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setAssembleUrl(String assembleUrl) {
        this.assembleUrl = assembleUrl;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public void setRawRequestBody(String rawRequestBody) {
        this.rawRequestBody = rawRequestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public void setBodyResponseEnabled(boolean bodyResponseEnabled) {
        this.bodyResponseEnabled = bodyResponseEnabled;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }

    public void setLogContentLevel(LogContentLevel logContentLevel) {
        this.logContentLevel = logContentLevel;
    }


    protected boolean canEqual(Object other) {
        return other instanceof FRequest;
    }

    public String toString() {
        return "FRequest(client=" + this.getClient() + ", requestExecutor=" + this.getRequestExecutor() + ", requestBodyProcessor=" + this.getRequestBodyProcessor() + ", params=" + this.getParams() + ", formParams=" + this.getFormParams() + ", headers=" + this.getHeaders() + ", cookies=" + this.getCookies() + ", baseUrl=" + this.getBaseUrl() + ", assembleUrl=" + this.getAssembleUrl() + ", requestType=" + this.getRequestType() + ", key=" + this.getKey() + ", contentType=" + this.getContentType() + ", rawRequestBody=" + this.getRawRequestBody() + ", requestBody=" + this.getRequestBody() +", filters=" + this.getFilters() + ", bodyResponseEnabled=" + this.isBodyResponseEnabled() + ", processTime=" + this.getProcessTime() + ", logContentLevel=" + this.getLogContentLevel() + ")";
    }

    public static class Cookie {
        private String cookie;

        public String toString() {
            return this.cookie;
        }

        Cookie(String cookie) {
            this.cookie = cookie;
        }

        public static CookieBuilder builder() {
            return new CookieBuilder();
        }

        public String getCookie() {
            return this.cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof Cookie)) {
                return false;
            } else {
                Cookie other = (Cookie)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$cookie = this.getCookie();
                    Object other$cookie = other.getCookie();
                    if (this$cookie == null) {
                        if (other$cookie != null) {
                            return false;
                        }
                    } else if (!this$cookie.equals(other$cookie)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof Cookie;
        }


        public static class CookieBuilder {
            private String cookie;

            CookieBuilder() {
            }

            public CookieBuilder cookie(String cookie) {
                this.cookie = cookie;
                return this;
            }

            public Cookie build() {
                return new Cookie(this.cookie);
            }

            public String toString() {
                return "FRequest.Cookie.CookieBuilder(cookie=" + this.cookie + ")";
            }
        }
    }

    public static class Header {
        private String name;
        private String value;

        Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public static HeaderBuilder builder() {
            return new HeaderBuilder();
        }

        public String toString() {
            return "FRequest.Header(name=" + this.getName() + ", value=" + this.getValue() + ")";
        }

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }


        protected boolean canEqual(Object other) {
            return other instanceof Header;
        }


        public static class HeaderBuilder {
            private String name;
            private String value;

            HeaderBuilder() {
            }

            public HeaderBuilder name(String name) {
                this.name = name;
                return this;
            }

            public HeaderBuilder value(String value) {
                this.value = value;
                return this;
            }

            public Header build() {
                return new Header(this.name, this.value);
            }

            public String toString() {
                return "FRequest.Header.HeaderBuilder(name=" + this.name + ", value=" + this.value + ")";
            }
        }
    }

    public static class Param {
        private String name;
        private Object value;
        private boolean encode = true;

        @ConstructorProperties({"name", "value", "encode"})
        Param(String name, Object value, boolean encode) {
            this.name = name;
            this.value = value;
            this.encode = encode;
        }

        public static ParamBuilder builder() {
            return new ParamBuilder();
        }

        public String toString() {
            int MAX_PRINT_LENGTH = 1024;
            String value = this.getValue() == null ? "null" : this.getValue().toString();
            if (value.length() > MAX_PRINT_LENGTH) {
                value = value.substring(0, MAX_PRINT_LENGTH) + "...";
            }

            return "FRequest.Param(name=" + this.getName() + ", value=" + value + ", encode=" + this.isEncode() + ")";
        }

        public String getName() {
            return this.name;
        }

        public Object getValue() {
            return this.value;
        }

        public boolean isEncode() {
            return this.encode;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setEncode(boolean encode) {
            this.encode = encode;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (!(o instanceof Param)) {
                return false;
            } else {
                Param param = (Param)o;
                return this.encode == param.encode && Objects.equals(this.name, param.name) && Objects.equals(this.value, param.value);
            }
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.name, this.value, this.encode});
        }

        protected boolean canEqual(Object other) {
            return other instanceof Param;
        }

        public static class ParamBuilder {
            private String name;
            private Object value;
            private boolean encode;

            ParamBuilder() {
            }

            public ParamBuilder name(String name) {
                this.name = name;
                return this;
            }

            public ParamBuilder value(Object value) {
                this.value = value;
                return this;
            }

            public ParamBuilder encode(boolean encode) {
                this.encode = encode;
                return this;
            }

            public Param build() {
                return new Param(this.name, this.value, this.encode);
            }

            public String toString() {
                int MAX_PRINT_LENGTH = 1024;
                String printValue = this.value == null ? "null" : this.value.toString();
                if (printValue.length() > MAX_PRINT_LENGTH) {
                    printValue = printValue.substring(0, MAX_PRINT_LENGTH) + "...";
                }

                return "FRequest.Param.ParamBuilder(name=" + this.name + ", value=" + printValue + ", encode=" + this.encode + ")";
            }
        }
    }
}
