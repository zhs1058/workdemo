package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.alibaba.xxpt.gateway.shared.client.http.ExecutableClient;
import com.alibaba.xxpt.gateway.shared.client.http.GetClient;


public class test {
	
	public static void main(String[] args) {
		
		/*
		 * String token = ""; try { //��ʽ URL url = new URL(
		 * "https://oapi.dingtalk.com/gettoken?appkey=ding66oq8xdsgs5tigd2&appsecret=HxfgiOLkOJzewUzlWJSQ-8A30RLbhzses10C9bds4YcLJDHda_3YS7ECzntzVh2i"
		 * ); //���� //URL url = new URL(
		 * "https://oapi.dingtalk.com/gettoken?appkey=dingn5souf16u3q84jd4&appsecret=zh53mTN-J-Ypi0GBZpLyHj-S99Eu0VFrpKjOwcoKSorxgtIYA1G_HVtcnVbtXPpb"
		 * ); //����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ�� TrustManager[] tm = {new
		 * MyX509TrustManager()}; SSLContext sslContext = SSLContext.getInstance("SSL",
		 * "SunJSSE"); sslContext.init(null, tm, new java.security.SecureRandom());
		 * //������SSLContext�����еõ�SSLSocketFactory���� SSLSocketFactory ssf =
		 * sslContext.getSocketFactory();
		 * 
		 * //����HttpsURLConnection���󣬲�������SSLSocketFactory���� HttpsURLConnection httpsConn
		 * = (HttpsURLConnection) url.openConnection();
		 * httpsConn.setSSLSocketFactory(ssf); //�����˷������� httpsConn.setDoOutput(true);
		 * httpsConn.setRequestMethod("GET"); BufferedReader rd = new BufferedReader(new
		 * InputStreamReader( httpsConn.getInputStream(), "utf-8")); StringBuffer sb =
		 * new StringBuffer(); String s = ""; while ((s = rd.readLine()) != null) {
		 * sb.append(s); } if (sb.length() == 0) { sb.append("[]"); } String result =
		 * sb.toString(); JSONObject json = new JSONObject(result); token =
		 * json.getString("access_token"); rd.close(); } catch (Exception e) {
		 * e.printStackTrace(); } System.out.println("tokenֵ"+token);
		 */
		
		
		
		
		  String key = "h5ceshi-46328N8SEwpxg2Y5BVjm6v"; String secret =
		  "K8M89a75UMN1748WJaftpEsHmzot8Gyr9g5DfzF9"; ExecutableClient executableClient
		  = ExecutableClient.getInstance(); executableClient.setAccessKey(key);
		  executableClient.setSecretKey(secret);
		  executableClient.setDomainName("openplatform.dg-work.cn");
		  executableClient.setProtocal("https"); executableClient.init();
		  
		  String api = "/gettoken.json"; GetClient getClient =
		  executableClient.newGetClient(api); getClient.addParameter("appkey", key);
		  //����2��ȡ getClient.addParameter("appsecret", secret); //����2��ȡ
		  
		  String apiResult = getClient.get(); System.out.println(apiResult);
		 
		
		/*
		 * double begin = System.currentTimeMillis(); System.out.println(begin); for
		 * (int i = 0; i < 10000; i++) { //ѭ��baidu int j = 0; j ++; j +=100; } double
		 * end = System.currentTimeMillis(); System.out.println(end);
		 * System.out.println("1���ѭ������zhi��ʱ�䣨s��dao"+((end-begin)/1000) + (end-begin));
		 */
		
		
		/*
		 * Point<? extends Integer> point; point = new Point<>(1,2);
		 * 
		 * Number s1 = (Number) point.getX(); Integer s = (Integer) point.getX();
		 * System.out.println(s1); System.out.println(s);
		 */
		/*
		 * Point<Integer> point1 = new Point<Integer>(1,2); Map map1 = new Map(point1);
		 * 
		 * try { Field pointField = map1.getClass().getDeclaredField("point");
		 * pointField.setAccessible(true); Map map2 = new Map(); Point pointCopy =
		 * (Point) pointField.get(map2);
		 * 
		 * System.out.println(pointCopy.getX()); } catch (NoSuchFieldException
		 * |IllegalArgumentException | IllegalAccessException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (SecurityException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
	}
	
	
}

class MyX509TrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return new X509Certificate[0];
	}
   
}



