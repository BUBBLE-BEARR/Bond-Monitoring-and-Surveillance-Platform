package com.project.common.hc.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Optional;
import com.project.common.hc.exception.ObjectParseException;
import com.project.common.hc.specific.AbstractWrapper;
import okhttp3.Headers;
import okhttp3.Response;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

public class FResponse implements IFResponse {
    private static final Logger log = LoggerFactory.getLogger(FResponse.class);
    private Integer code;
    private String message;
    private Headers headers;
    private String body;
    private Response rawResponse;
    private FRequest request;
    private LogContentLevel logContentLevel;
    protected static final ObjectMapper mapper = new ObjectMapper();

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public IFRequest request() {
        return this.request;
    }

    public String body() {
        String var1;
        try {
            var1 = this.body;
        } finally {
            this.printTracingOKLog();
        }

        return var1;
    }

    public <R> R body(Class<R> clazz) throws ObjectParseException {
        log.trace(MessageFormat.format("Converting response body: {0} to class {1}", this.body, clazz.getSimpleName()));
        if (this.body == null) {
            this.printTracingErrorLog("BODY_NULL");
            throw new ObjectParseException(MessageFormat.format(">>>>RESPONSE PARSING FAILED<<<<: The body is null, and The json mapper can not unserialize it to {0}.", clazz.getName()));
        } else {
            boolean hasError = false;
            String returnCode = "";

            Object var5;
            try {
                if (!this.httpSuccess()) {
                    hasError = true;
                    returnCode = "HTTP_" + String.valueOf(this.getCode());
                }

                R result = mapper.readValue(this.body, clazz);
                if (result == null) {
                    var5 = null;
                    return (R) var5;
                }

                if (result instanceof AbstractWrapper && !((AbstractWrapper) result).isSuccess()) {
                    hasError = true;
                    returnCode = ((AbstractWrapper) result).getReturnCode();
                    log.warn(">>>>RESPONSE RETURN FAILED<<<<: Return code failed");
                }

                var5 = result;
            } catch (IOException var9) {
                log.warn(MessageFormat.format(">>>>RESPONSE PARSING FAILED<<<<: Json mapper can not unserialize {0} to {1}.", this.body, clazz.getName()), var9);
                hasError = true;
                returnCode = "PARSE_ERROR";
                throw new ObjectParseException(MessageFormat.format("Json mapper can not unserialize {0} to {1}.", this.body, clazz.getName()), var9);
            } finally {
                if (hasError) {
                    this.printTracingErrorLog(returnCode);
                } else {
                    this.printTracingOKLog();
                }

            }

            return (R) var5;
        }
    }

    private void printTracingErrorLog(String returnCode) {
        log.info("##{},{},{},{}", new Object[]{StringUtils.defaultIfEmpty(this.request.getKey(), this.request.getBaseUrl()), returnCode, "PROXY", this.request.getProcessTime()});
    }

    private void printTracingOKLog() {
        log.info("##{},{},{},{}", new Object[]{StringUtils.defaultIfEmpty(this.request.getKey(), this.request.getBaseUrl()), "OK", "PROXY", this.request.getProcessTime()});
    }

    public <R> Optional<R> getResult(Class<R> clazz) {
        try {
            return Optional.fromNullable(this.body(clazz));
        } catch (ObjectParseException var3) {
            return Optional.absent();
        }
    }

    public Boolean httpSuccess() {
        return this.code != null && this.code >= 200 && this.code < 300;
    }

    public Headers headers() {
        return this.headers;
    }

    public String header(String name) {
        return this.headers.get(name);
    }

    public String toString() {
        String bodyLog = this.body;
        if (StringUtils.length(bodyLog) > 20000) {
            bodyLog = StringUtils.left(bodyLog, 20000) + "...";
        }

        return "FResponse{code=" + this.code + ", message='" + this.message + '\'' + ", body='" + bodyLog + '\'' + ", request=" + this.request + '}';
    }

    public String getResponseInfo() {
        StringBuilder log = new StringBuilder();
        log.append("Code: ").append(this.code).append(". ");
        log.append("Message: ").append(this.message).append(". ");
        if (this.logContentLevel == LogContentLevel.SHORT) {
            return log.toString();
        } else {
            String bodyLog = this.body;
            if (StringUtils.length(bodyLog) > 20000) {
                bodyLog = StringUtils.left(bodyLog, 20000) + "...";
            }

            log.append("Body: ").append(bodyLog).append(". ");
            return log.toString();
        }
    }

    /**
     * 对文件流信息进行处理   --pdf
     *
     * @return
     * @throws IOException
     * @Param showFlag   value = attachment:请求后下载pdf     value=inline 请求后直接在浏览器打开
     */
    public void getResponse(HttpServletResponse response, String showFlag) {
        String fileName = null;
        if (getRawResponse().isSuccessful() && getRawResponse().header("Content-Disposition")!= null) {
            try (InputStream inputStream = getRawResponse().body().byteStream();
                 OutputStream outputStream = response.getOutputStream()) {
                response.setContentType(MediaType.APPLICATION_PDF_VALUE);
                //获取文件名字
                fileName = getRawResponse().header("Content-Disposition").split("=")[1];
                response.setHeader("Content-Disposition", showFlag + "; filename=" + fileName);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            //失败情况下返回信息
            response.setStatus(getRawResponse().code());
        }


    }

    FResponse(Integer code, String message, Headers headers, String body, Response rawResponse, FRequest request, LogContentLevel logContentLevel) {
        this.code = code;
        this.message = message;
        this.headers = headers;
        this.body = body;
        this.rawResponse = rawResponse;
        this.request = request;
        this.logContentLevel = logContentLevel;
    }

    public static FResponseBuilder builder() {
        return new FResponseBuilder();
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public String getBody() {
        return this.body;
    }

    public Response getRawResponse() {
        return this.rawResponse;
    }

    public FRequest getRequest() {
        return this.request;
    }

    public LogContentLevel getLogContentLevel() {
        return this.logContentLevel;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setRawResponse(Response rawResponse) {
        this.rawResponse = rawResponse;
    }

    public void setRequest(FRequest request) {
        this.request = request;
    }

    public void setLogContentLevel(LogContentLevel logContentLevel) {
        this.logContentLevel = logContentLevel;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FResponse)) {
            return false;
        } else {
            FResponse other = (FResponse) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95:
                {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label95;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label95;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$headers = this.getHeaders();
                Object other$headers = other.getHeaders();
                if (this$headers == null) {
                    if (other$headers != null) {
                        return false;
                    }
                } else if (!this$headers.equals(other$headers)) {
                    return false;
                }

                label74:
                {
                    Object this$body = this.getBody();
                    Object other$body = other.getBody();
                    if (this$body == null) {
                        if (other$body == null) {
                            break label74;
                        }
                    } else if (this$body.equals(other$body)) {
                        break label74;
                    }

                    return false;
                }

                label67:
                {
                    Object this$rawResponse = this.getRawResponse();
                    Object other$rawResponse = other.getRawResponse();
                    if (this$rawResponse == null) {
                        if (other$rawResponse == null) {
                            break label67;
                        }
                    } else if (this$rawResponse.equals(other$rawResponse)) {
                        break label67;
                    }

                    return false;
                }

                Object this$request = this.getRequest();
                Object other$request = other.getRequest();
                if (this$request == null) {
                    if (other$request != null) {
                        return false;
                    }
                } else if (!this$request.equals(other$request)) {
                    return false;
                }

                Object this$logContentLevel = this.getLogContentLevel();
                Object other$logContentLevel = other.getLogContentLevel();
                if (this$logContentLevel == null) {
                    if (other$logContentLevel != null) {
                        return false;
                    }
                } else if (!this$logContentLevel.equals(other$logContentLevel)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof FResponse;
    }


    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static class FResponseBuilder {
        private Integer code;
        private String message;
        private Headers headers;
        private String body;
        private Response rawResponse;
        private FRequest request;
        private LogContentLevel logContentLevel;

        FResponseBuilder() {
        }

        public FResponseBuilder code(Integer code) {
            this.code = code;
            return this;
        }

        public FResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public FResponseBuilder headers(Headers headers) {
            this.headers = headers;
            return this;
        }

        public FResponseBuilder body(String body) {
            this.body = body;
            return this;
        }

        public FResponseBuilder rawResponse(Response rawResponse) {
            this.rawResponse = rawResponse;
            return this;
        }

        public FResponseBuilder request(FRequest request) {
            this.request = request;
            return this;
        }

        public FResponseBuilder logContentLevel(LogContentLevel logContentLevel) {
            this.logContentLevel = logContentLevel;
            return this;
        }

        public FResponse build() {
            return new FResponse(this.code, this.message, this.headers, this.body, this.rawResponse, this.request, this.logContentLevel);
        }

        public String toString() {
            return "FResponse.FResponseBuilder(code=" + this.code + ", message=" + this.message + ", headers=" + this.headers + ", body=" + this.body + ", rawResponse=" + this.rawResponse + ", request=" + this.request + ", logContentLevel=" + this.logContentLevel + ")";
        }
    }
}
