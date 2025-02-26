package com.project.common.hc.util;
import com.project.common.hc.http.IFRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class HttpSecretUtil {
    public static void main(String args[]) {
        Map<String, Object> parameters = new HashMap();
        parameters.put("comcode",90000428);
       // long l = System.currentTimeMillis();
        parameters.put("timestamp","1694508019393");

        String secret = createSecret("000100", "2CFAC2BF-CEA1-35CA-5DA9-C7283181DA36", parameters);
        System.out.println("secret===>"+secret);
    }


    public static String createSecret(String systemId, String key, Map<String, Object> parameters) {
        if (isEmpty(systemId)) {
            throw new IllegalArgumentException("系统ID不可为空");
        } else if (isEmpty(key)) {
            throw new IllegalArgumentException("系统密钥不可为空");
        } else if (parameters != null && !parameters.isEmpty()) {
            String data = join(parameters);
            try {
//                return hmacSHA256(key, data);
                return getSHA256StrJava(key + data);
            } catch (Exception e) {
                throw new RuntimeException("计算认证信息失败", e);
            }
        } else {
            throw new IllegalArgumentException("请求数据不可为空");
        }
    }

    /**
     * 参数排序后，拼接vlaue
     * @param parameters
     * @return
     */
    public static String join(Map<String, Object> parameters) {
        List<String> keys = new ArrayList();
        keys.addAll(parameters.keySet());
        Collections.sort(keys, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuffer pairs = new StringBuffer();
        Iterator iterator = keys.iterator();

        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            pairs.append(parameters.get(key));
        }

        return pairs.toString();
    }

    /**
     * 数排序后，拼接vlaue+secret
     * @param parameters
     * @param secret
     * @return
     */
    public static String join(Map<String, Object> parameters,String secret) {
        List<String> keys = new ArrayList();
        keys.addAll(parameters.keySet());
        Collections.sort(keys, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuffer pairs = new StringBuffer();
        pairs.append(secret);
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            pairs.append(parameters.get(key));
        }

        return pairs.toString();
    }



    /**
     * sha256_HMAC加密
     * @param data 消息
     * @param key  秘钥
     * @return 加密后字符串
     */
    public static String hmacSHA256(String key, String data) throws Exception {
        System.out.println("key=="+key+", data===>"+data);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder(); //将加密后的字节数组转换成字符串
        for (byte item : signData) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 利用java原生的摘要实现SHA256加密
     *
     * @param str 加密后的报文
     * @return* import java.io.UnsupportedEncodingException;* import java.security.MessageDigest;*
     * import java.security.NoSuchAlgorithmException; 
     */

    public static String getSHA256StrJava(String str) {

        MessageDigest messageDigest;

        String encodeStr = "";

        try {

            messageDigest = MessageDigest.getInstance("SHA-256");

            messageDigest.update(str.getBytes("UTF-8"));

            encodeStr = byte2Hex(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return encodeStr;

    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */

    private static String byte2Hex(byte[] bytes) {

        StringBuffer stringBuffer = new StringBuffer();

        String temp = null;

        for (int i = 0; i < bytes.length; i++) {

            temp = Integer.toHexString(bytes[i] & 0xFF);

            if (temp.length() == 1) {

                // 1得到一位的进行补0操作

                stringBuffer.append("0");

            }

            stringBuffer.append(temp);

        }

        return stringBuffer.toString();

    }

    private static boolean isEmpty(String target) {
        return target == null || target.length() == 0;
    }

    /**
     * 判断对象是否为null
     * @param o
     * @return
     */
    public static boolean ObjectNotIsNUll(Object o){
        if("".equals(o) || o==null){
            return false;
        }
        return true;
    }

    /**
     * get请求参数拼接&接收返回参数
     * @param params
     * @param requestParam
     * @return
     */
    public static String  StitchRequestParameters(HashMap<String, Object> params, IFRequest requestParam,String responseBody){
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            //增加对tabType必传字段的处理，当tabType为null时也放入请求参数中
            if (HttpSecretUtil.ObjectNotIsNUll(next.getValue()) || next.getKey().equals("tabType")) {
                if(next.getKey().equals("page") || next.getKey().equals("size")){
                    requestParam.param(next.getKey(),Integer.valueOf(String.valueOf(next.getValue())));
                    continue;
                }
                requestParam.param(next.getKey(),next.getValue());
            }
        }
        try {
            responseBody  = requestParam.get().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("requestParam.toString() = " + requestParam);
        return responseBody;
    }

    /**
     * post请求参数拼接&接收返回参数
     * @param params
     * @param requestParam
     * @param responseBody
     * @return
     */
    public static String  PostStitchRequestParameters(HashMap<String, Object> params, IFRequest requestParam,String responseBody){
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (HttpSecretUtil.ObjectNotIsNUll(next.getValue())) {
                if(next.getKey().equals("page") || next.getKey().equals("size")){
                    requestParam.param(next.getKey(),Integer.valueOf(String.valueOf(next.getValue())));
                    continue;
                }
                requestParam.param(next.getKey(),next.getValue());
            }
        }
        try {
            responseBody  = requestParam.post().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("requestParam.toString() = " + requestParam);
        return responseBody;
    }
}
