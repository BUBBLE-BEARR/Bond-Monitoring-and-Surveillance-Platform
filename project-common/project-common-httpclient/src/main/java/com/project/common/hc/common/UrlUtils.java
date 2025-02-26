package com.project.common.hc.common;

import okhttp3.HttpUrl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UrlUtils {
    private static final Pattern PATTERN_PATH_VAR = Pattern.compile("(.*)/([0-9,;]+)/?$");

    public UrlUtils() {
    }

    public static String getEncodedPath(String baseUrl) {
        HttpUrl url = HttpUrl.parse(baseUrl);
        if (url == null) {
            return "";
        } else {
            String path = url.host() + url.encodedPath();
            return replaceNumberSuffix(path);
        }
    }

    public static String replaceNumberSuffix(String path) {
        Matcher matcher = PATTERN_PATH_VAR.matcher(path);
        if (matcher.find()) {
            path = matcher.replaceFirst("$1");
        }

        return path;
    }

    public static void main(String[] args) {
        String z = "/queryCorpus/api/v1/entity/status/vb40/2529730271922100,2670911461115000,5738393662728900,3221197232643700,5063772184807500,7278552090298400,3818810789172700,6218088839652200,1421137070410000,4637822119678000";
        String x = replaceNumberSuffix(z);
        System.out.println(z + "==>" + x);
        z = "http://www.baidu.com/12341234/";
        x = replaceNumberSuffix(z);
        System.out.println(z + "==>" + x);
        z = "http://www.baidu.com";
        x = replaceNumberSuffix(z);
        System.out.println(z + "==>" + x);
    }
}
