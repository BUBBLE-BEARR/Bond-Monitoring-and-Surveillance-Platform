package com.project.common.hc.config;

import com.project.common.hc.FluentHC;
import com.project.common.hc.specific.HtFRequest;
import com.project.common.hc.thirdparty.filecabinet.FileCabinetApi;
import okhttp3.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties({FluentHCProperties.class, ApiUrlProperties.class})
public class FluentHCAutoConfiguration {
    @Autowired
    private FluentHCProperties properties;

    @Autowired
    ApiUrlProperties apiUrlProperties;

    public FluentHCAutoConfiguration() {
    }

    /**
     * 文件柜第三方接口
     * @return
     */
    @Bean
    @ConditionalOnProperty({"thirdparty-api.filing-cabinet-url"})
    public FileCabinetApi filingCabinetApi() {
        return new FileCabinetApi();
    }

    @Bean
    public Call.Factory okHttpClient() {
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        if (this.properties.getOkHttpConnectTimeout() != null) {
            builder.connectTimeout((long)this.properties.getOkHttpConnectTimeout(), TimeUnit.MILLISECONDS);
        }

        if (this.properties.getOkHttpWriteTimeout() != null) {
            builder.writeTimeout((long)this.properties.getOkHttpWriteTimeout(), TimeUnit.MILLISECONDS);
        }

        if (this.properties.getOkHttpReadTimeout() != null) {
            builder.readTimeout((long)this.properties.getOkHttpReadTimeout(), TimeUnit.MILLISECONDS);
        }
        builder.sslSocketFactory(createSSLSocketFactory(),getX509TrustManager());
        builder.hostnameVerifier(new TrustAllHostnameVerifier());
        return builder.build();
    }

    @Bean
    public FluentHC fluentHC() {
        HtFRequest.setHtClientIdAndKey(properties.getSystemId(), properties.getHtSecret());
        return new FluentHC(this.okHttpClient());
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init((KeyManager[])null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (RuntimeException var2) {
        } catch (Exception var3) {
        }

        return ssfFactory;
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        private TrustAllHostnameVerifier() {
        }

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static class TrustAllCerts implements X509TrustManager {
        private TrustAllCerts() {
        }

        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static X509TrustManager getX509TrustManager() {
        X509TrustManager trustManager = null;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            trustManager = (X509TrustManager) trustManagers[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trustManager;
    }
}
