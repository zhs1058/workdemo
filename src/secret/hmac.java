package secret;

import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

public class hmac {
	
	final static Base64.Encoder encoder = Base64.getEncoder();
	
	public static void main(String[] args) {
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
       
        parameters.put("version", "1.0");
        parameters.put("appId", "APP_0157E810F6894BEEB4DEC70331720557");
        parameters.put("signAlgo", "HMAC");
        //parameters.put("userName", "张三");
        //parameters.put("idType", "SF");
        //parameters.put("idNumber", "410711197006031015");
        //parameters.put("mobile", "18745292611");
        //parameters.put("idType","SF");
        //parameters.put("idNumber","410711197006031015");
        parameters.put("title", "签名测试");
        parameters.put("dataType", "DATA");
        parameters.put("algo", "SM3withSM2");
        parameters.put("data", "562+5ZCN5rWL6K+V5pWw5o2u");
        //parameters.put("userId", "d3eb8ac99dd8f18489ea1f065585b409a70b19f63de05e6d799c681e40638a24");
        createSign(parameters);
    }

    /**
     * 生成签名
     */
    public static void createSign(SortedMap<Object,Object> parameters){
        StringBuffer sbkey = new StringBuffer();
        //1.将所有参与传参的参数按照accsii排序（升序)
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            //2.空值不传递，不参与签名组串
            if(null != v && !"".equals(v)) {
                sbkey.append(k + "=" + v);
                if(it.hasNext()) {
                	sbkey.append("&");
                }
            }
        }

        System.out.println(sbkey.toString());
        try {
			HMACSHA256(sbkey.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void HMACSHA256(String data) throws Exception {

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        String key = "XTka8lO2NMH9PCffiFWLE1HV4UPYCWMu";
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

        sha256_HMAC.init(secret_key);

        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();

        for (byte item : array) {

            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

        }

        //return sb.toString().toUpperCase();
        //System.out.println();
        System.out.println(encoder.encodeToString(array));

    }



}
