package utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/**
 * 加密工具类
 * @author cwj
 *
 */
public class EncryptionUtil {
	private EncryptionUtil(){}
	private static final String ALGORITHM = "DES";

	/**
	 * Get Des Key
	 */
	public static byte[] getKey() throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey deskey = keygen.generateKey();
		return deskey.getEncoded();
	}

	/**
	 * Encrypt Messages
	 */
	public static byte[] encode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, ALGORITHM);
		Cipher c1 = Cipher.getInstance(ALGORITHM);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		return c1.doFinal(input);
	}

	/**
	 * Decrypt Messages
	 */
	public static byte[] decode(byte[] input, byte[] key) throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, ALGORITHM);
		Cipher c1 = Cipher.getInstance(ALGORITHM);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		return c1.doFinal(input);
	}

	/**
	 * MD5
	 */
	public static byte[] md5(byte[] input) throws Exception {
		java.security.MessageDigest alg = java.security.MessageDigest
				.getInstance("MD5"); // or "SHA-1"
		alg.update(input);
		return alg.digest();
	}

	/**
	 * Convert byte[] to String
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
	
	/**
	 * Convert String to byte[]
	 */
	public static byte[] hex2byte(String hex) {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}
	//生成密码方法，123456为明文密码，asiainfo不要动，直接替换新的明文密码就可以生成加密的密码了
		public static void main(String[] args) throws Exception {
		System.out.println(byte2hex(encode("root".getBytes(),
				"asiainfo".getBytes())));
	}
}
