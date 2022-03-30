package secret;

import java.util.Base64;
import javax.crypto.Cipher;


import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {
	private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥
	
	private static final Base64.Decoder decoder = Base64.getDecoder();
	private static final Base64.Encoder encoder = Base64.getEncoder();
	
	public static void main(String[] args) throws Exception {
		//生成公钥和私钥
		genKeyPair();
		//加密字符串
		String message = "df723820";
		System.out.println("随机生成的公钥为:" + keyMap.get(0));
		System.out.println("随机生成的私钥为:" + keyMap.get(1));
		String messageEn = encrypt(message,keyMap.get(0));
		System.out.println(message + "\t加密后的字符串为:" + messageEn);
		String s = "IDFGJrA270zxl5ZJO7d6yfRVgxYQtgueWj1/mioiJkFKaOEPmllHCRF0WZ6wZmxvwmmgE5FiUg6VwdtaVKEh0Sieke8/Simh3iqOS0KhwTrNnuYuz+djdOHCAUIjetjhRlLuY/XxeLy3iSzfEDU3yVBMVpPrsyzxSJYw/Amg2u4=";
		String messageDe = decrypt(s,keyMap.get(1));
		System.out.println("还原后的字符串为:" + messageDe);
	}

	/** 
	 * 随机生成密钥对 
	 * @throws NoSuchAlgorithmException 
	 */  
	public static void genKeyPair() throws NoSuchAlgorithmException {  
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
		// 初始化密钥对生成器，密钥大小为96-1024位  
		keyPairGen.initialize(1024,new SecureRandom());  
		// 生成一个密钥对，保存在keyPair中  
		KeyPair keyPair = keyPairGen.generateKeyPair();  
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥  
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥  
		String publicKeyString = new String(encoder.encode(publicKey.getEncoded()));  
		// 得到私钥字符串  
		String privateKeyString = new String(encoder.encode((privateKey.getEncoded())));  
		// 将公钥和私钥保存到Map
		System.out.println(privateKeyString);
		String pk = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKJyHrv2ZaBvl8N3bIr3t+XkN8tunZ44rYtg3n0aZDmKd3f4PO6rnrl6ZnewmgBJdqA2fHP0iCJdzSBonJ390/D6ERXIXXldM94VBmGnKEGUX7I/zpMXXfntNBDgE0LCg1ZLG5w///DnD8G4RXviRmVjaDrADQoJ3ZlPcUnY1uIjAgMBAAECgYArVl60rot2Pc8zKo0ele/NuRDZiO0r5NsHsBQrM/tBDpvIucUnt0llGi50B/1NzkuDeoXBOZ+H65Zp6v69d5Yu6qLOh+8lSnSTUHQ7IRDXYSuyU/HKYIkzyNUs78U2piK5/Ue5pXcFempvmqrt4z3qXuLANI1gyrXWK3IU1vHRIQJBANyWK1TnnSnb6jYa/RgBmY8Tn0HWdP02lY6JFQAhkzDFxV5UDUDFEtHXajkLietGXe8Yze7DNoF9sLv0IXl90MUCQQC8hm/FFFOnzsLGntnLAfyBLoE41AF8q88q8D5k3JDjqCDickyuR4icg1ZtNXxjLYNBSAAROKVwQ8h2UYU++sXHAkEAwlfb3XYiVZrXgsvMaLYgIJpdGZhkgiLxKR9FTVRHZhUYir7q3kHDDvYHNDMiVBMu91SXOuDqyLOAXlf8lhlvMQJAYTTwbK4OdHgn9kHyCrr7d6CDAMpP+fic2YcGpPsVukz2p8xHvZUk247dAXKSsJDHHOIDJt4Ob9SDiH6ANfkYAQJAJ3JEvw6S2oFzH9CZzg5fruNqpaYSHlCuNkbZMfr7/EE1rZ48n4zHY9yEs0yAsW8u5iv7tA9fESPPk4T9vyJkGg==";
		String uk = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCich679mWgb5fDd2yK97fl5DfLbp2eOK2LYN59GmQ5ind3+Dzuq565emZ3sJoASXagNnxz9IgiXc0gaJyd/dPw+hEVyF15XTPeFQZhpyhBlF+yP86TF1357TQQ4BNCwoNWSxucP//w5w/BuEV74kZlY2g6wA0KCd2ZT3FJ2NbiIwIDAQAB";
		keyMap.put(0,uk);  //0表示公钥
		keyMap.put(1,pk);  //1表示私钥
	}  
	/** 
	 * RSA公钥加密 
	 *  
	 * @param str 
	 *            加密字符串
	 * @param publicKey 
	 *            公钥 
	 * @return 密文 
	 * @throws Exception 
	 *             加密过程中的异常信息 
	 */  
	public static String encrypt( String str, String publicKey ) throws Exception{
		//base64编码的公钥
		byte[] decoded = decoder.decode(publicKey); //Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = encoder.encodeToString(cipher.doFinal(str.getBytes("UTF-8")));//Base64.encodeBase64String();
		return outStr;
	}

	/** 
	 * RSA私钥解密
	 *  
	 * @param str 
	 *            加密字符串
	 * @param privateKey 
	 *            私钥 
	 * @return 铭文
	 * @throws Exception 
	 *             解密过程中的异常信息 
	 */  
	public static String decrypt(String str, String privateKey) throws Exception{
		//64位解码加密后的字符串
		byte[] inputByte = decoder.decode(str.getBytes("UTF-8"));
		//base64编码的私钥
		byte[] decoded = decoder.decode(privateKey); //Base64.decodeBase64(privateKey);  
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));  
		//RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		
		StringBuilder sb = new StringBuilder();
		System.out.println(inputByte.length);
		for (int i = 0; i < inputByte.length; i += 128) {
			byte[] ns = new byte[128];
			int k = 0;
			for(int j = i; j < i +128; j ++) {
				ns[k++] = inputByte[j];
			}
			System.out.println(i);
			byte[] doFinal = cipher.doFinal(ns);
			sb.append(new String(doFinal));
		}
		
		//String outStr = new String(cipher.doFinal(inputByte));
		return sb.toString();
	}

}

