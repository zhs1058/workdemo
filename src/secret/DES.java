package secret;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;



/**
 * DES是一种对称加密算法，是一种非常简便的加密算法， 但是密钥长度比较短。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些 年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中， 我们还是可以使用DES加密算法.简单的DES加密算法实现：
 * 
 */
public class DES {

	private static final String KEY_ALGORITHM = "DES";
	private static final String DEFAULT_CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";// 默认的加密算法
	private static final Base64.Decoder decoder = Base64.getDecoder();
	private static final Base64.Encoder encoder = Base64.getEncoder();

	/**
	 * DES 加密操作
	 * 
	 * @param content
	 *            待加密内容
	 * @param key
	 *            加密密钥
	 * @return 返回Base64转码后的加密数据
	 */
	public static String encrypt(String content, String key) {
		try {
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// 初始化为加密模式的密码器
			byte[] result = cipher.doFinal(byteContent);// 加密
			 return encoder.encodeToString(result);
			//return Base64.byteArrayToBase64(result);// 通过Base64转码返回
			
		} catch (Exception ex) {
			Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	/**
	 * DES 解密操作
	 * 
	 * @param content
	 * @param key
	 * @return
	 */
	public static String decrypt(String content, String key) {

		try {
			// 实例化
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			// 使用密钥初始化，设置为解密模式
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
			// 执行操作
			byte[] result = cipher.doFinal(decoder.decode(content));
			return new String(result, "utf-8");
		} catch (Exception ex) {
			Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	/**
	 * 生成加密秘钥
	 * 
	 * @return
	 */
	private static SecretKey getSecretKey(final String key) {
		// 返回生成指定算法密钥生成器的 KeyGenerator 对象
		/*
		 * KeyGenerator kg = null; try { kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		 * // DES 要求密钥长度为 56 kg.init(56, new SecureRandom(key.getBytes())); // 生成一个密钥
		 * SecretKey secretKey = kg.generateKey();
		 * 
		 * return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为DES专用密钥
		 * } catch (NoSuchAlgorithmException ex) {
		 * Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex); }
		 */

		try {
			   SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			   DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			   keyFactory.generateSecret(keySpec);
			   return keyFactory.generateSecret(keySpec);
			  } catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		
		return null;
	}

	public static void main(String[] args) {
		String content = "22";
		String key = "caiwubaoxiao";
		System.out.println("content:" + content);
		String s1 = DES.encrypt(content, key);
		System.out.println("s1:" + s1);
		System.out.println("s2:" + DES.decrypt(s1, key));
	}

}