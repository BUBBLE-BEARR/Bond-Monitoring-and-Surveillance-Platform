package com.project.common.hc.specific;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.project.common.hc.filter.Filter;
import com.project.common.hc.http.FRequest;
import com.project.common.hc.http.FResponse;
import com.project.common.hc.util.HttpSecretUtil;
import okhttp3.Call;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HtFRequest extends FRequest {
    private static final Logger log = LoggerFactory.getLogger(HtFRequest.class);
    private static String SYSTEM_ID;
    private static String SYSTEM_KEY;

    public HtFRequest(Call.Factory client) {
        super(client);
        this.filter(new HtFilter());
    }

    public static void setHtClientIdAndKey(String clientId, String clientKey) {
        SYSTEM_ID = clientId;
        SYSTEM_KEY = clientKey;
    }

    private static class HtFilter implements Filter {
        private HtFilter() {
        }

        public void beforeExecute(FRequest request) {
            Preconditions.checkState(StringUtils.isNotBlank(HtFRequest.SYSTEM_ID), "The [puyu-client-id] is absent, please set the value in properties");
            Preconditions.checkState(StringUtils.isNotBlank(HtFRequest.SYSTEM_KEY), "The [puyu-client-key] is absent, please set the value in properties");
            request.param("secret", this.getSecret(request.getParams()));
        }

        public void afterExecute(FRequest commonFluentRequest, FResponse response) {
        }

        private String getSecret(List<Param> params) {
            Map<String, Object> httpParams = Maps.newHashMap();
            Iterator var3 = params.iterator();

            while (var3.hasNext()) {
                Param param = (Param) var3.next();
                if ("tabType".equals(param.getName()) && param.getValue()==null){
                    continue;
                }
                httpParams.put(param.getName(), param.getValue());
            }

            return HttpSecretUtil.createSecret(HtFRequest.SYSTEM_ID, HtFRequest.SYSTEM_KEY, httpParams);
        }
    }
}