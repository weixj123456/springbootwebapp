package com.root.xmlutils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import org.apache.log4j.Logger;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class JiaMi {
	static Logger	log	= Logger.getLogger(JiaMi.class);
	
	/**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
   
    private static final int MAX_DECRYPT_BLOCK = 128;
	
    // 公钥
    private String pubKey;
    // 待加密数据 字符串xml
	private String reqData;
	
	public void init(HashMap<String,Object> map) {
		this.pubKey= (String)map.get("pubKey");
		this.reqData= (String) map.get("reqData");
	}
	
	public Map<String,Object> jiamiString(HashMap<String,Object> map) throws UnsupportedEncodingException, Exception{
		init(map);
		log.info("删除空格后的报文"+reqData);
		reqData = replaceBlank(reqData);
		log.info("删除空格后的报文"+reqData);
		log.info("湖北消金加密开始");
		byte[] valuebytes = encryptByPublicKey(reqData.getBytes("UTF-8"), pubKey);
		String returnvalue= encode(valuebytes);
		log.info("湖北消金加密结束");
		Map<String,Object> rspMap = new HashMap<String,Object>();
		rspMap.put("reqData",returnvalue);
		
		return rspMap;
	}
	
	public static String replaceBlank(String str) {

        StringBuffer sb=new StringBuffer();
        for(String s:str.split("\n")) {
         sb.append(s.trim());
        }
        return sb.toString();
    }
	 // 生成随机数
	public static int tails(final int min, final int max) {
		Random r1 = new Random();
		int tmp = Math.abs(r1.nextInt());
		return tmp % (max - min + 1) + min;
	}
	
	
    

//public static String jiamiString(String publicKey,String value) throws Exception {
//	byte[] valuebytes = encryptByPublicKey(value.getBytes("UTF-8"), publicKey);
//	String returnvalue= encode(valuebytes);
//	System.out.println("加密方法已执行，已完成加密，待返回加密后字符串");
//	return returnvalue;
//}    
    

public static String rsaString(String publicKey,String value) throws Exception {
	byte[] valuebytes = encryptByPublicKey(value.getBytes("UTF-8"), publicKey);
	String rsareqdata= encode(valuebytes);
	System.out.println("加密方法已执行，已完成加密，待返回加密后字符串");
	return rsareqdata;
}    


public static String deRsaString(String privateKey,String value) {
	String str = null;
	try {
		str = new String(decryptByPrivateKey(decode(value), privateKey), "utf-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(str);
	return str;
}
 /** */
/**
 * <p>
 * BASE64字符串解码为二进制数据
 * </p>
 * 
 * @param base64
 * @return
 * @throws Exception
 */
public static byte[] decode(String base64) throws Exception {
    return Base64.getDecoder().decode(base64.getBytes());
}

/** */
/**
 * <p>
 * 二进制数据编码为BASE64字符串
 * </p>
 * 
 * @param bytes
 * @return
 * @throws Exception
 */
public static String encode(byte[] bytes) throws Exception {
    return new String(Base64.getEncoder().encode(bytes));
}

    
    /**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     * 
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /** */
    /**
     * <p>
     * 用私钥对信息生成数字签名
     * </p>
     * 
     * @param data
     *            已加密数据
     * @param privateKey
     *            私钥(BASE64编码)
     * 
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[] keyBytes = decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return encode(signature.sign());
    }

    /** */
    /**
     * <p>
     * 校验数字签名
     * </p>
     * 
     * @param data
     *            已加密数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @param sign
     *            数字签名
     * 
     * @return
     * @throws Exception
     * 
     */
    public static boolean verify(byte[] data, String publicKey, String sign)throws Exception {
        byte[] keyBytes = decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(decode(sign));
    }

    /** */
    /**
     * <P>
     * 私钥解密
     * </p>
     * 
     * @param encryptedData
     *            已加密数据
     * @param privateKey
     *            私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData,String privateKey) throws Exception {
        byte[] keyBytes =decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher
                        .doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher
                        .doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥解密
     * </p>
     * 
     * @param encryptedData
     *            已加密数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData,String publicKey) throws Exception {
        byte[] keyBytes = decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher
                        .doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher
                        .doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /** */
    /**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data
     *            源数据
     * @param publicKey
     *            公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)throws Exception {
        byte[] keyBytes = decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 私钥加密
     * </p>
     * 
     * @param data
     *            源数据
     * @param privateKey
     *            私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)throws Exception {
        byte[] keyBytes = decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /** */
    /**
     * <p>
     * 获取私钥
     * </p>
     * 
     * @param keyMap
     *            密钥对
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap)throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encode(key.getEncoded());
    }

    /** */
    /**
     * <p>
     * 获取公钥
     * </p>
     * 
     * @param keyMap
     *            密钥对
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encode(key.getEncoded());
    }
    
    /** */
    /**
     * <p>
     * 获取公钥
     * </p>
     * 
     * @param keyMap
     *            密钥对
     * @param privateKey 
     * @param publicKey 
     * @return
     * @throws Exception
     */
    public static String setKey(Map<String, Object> keyMap, PrivateKey publicKey, PrivateKey privateKey) throws Exception {
    	
    	keyMap.put(PUBLIC_KEY, publicKey);
    	keyMap.put(PRIVATE_KEY, privateKey);
    	return "1";
    }
  //===============================
   //==============================
   
    
//===============================
//===============================
  
    
     /**
 	 * <ol>HTTPS请求发送</ol>
 	 */
 	public static String post(String httpsUrl, String xmlStr) {
        String response=null;
 		HttpURLConnection urlCon = null;
 		try {
 			urlCon = (HttpURLConnection) (new URL(httpsUrl)).openConnection();

 			urlCon.setDoInput(true);
 			urlCon.setDoOutput(true);
 			urlCon.setRequestMethod("POST");
 			urlCon.setRequestProperty("Content-Length",String.valueOf(xmlStr.getBytes("UTF-8").length));
// 			urlCon.setRequestProperty("content-type","application/x-www-form-urlencoded;charset=UTF-8");
 			urlCon.setRequestProperty("content-type","text/xml;charset=UTF-8");
 			urlCon.setUseCaches(false);
 			// 设置为gbk可以解决服务器接收时读取的数据中文乱码问题
 			urlCon.getOutputStream().write(xmlStr.getBytes("UTF-8"));
 			urlCon.getOutputStream().flush();
 			urlCon.getOutputStream().close();
 			InputStream in = urlCon.getInputStream();
 			byte[] ret = new byte[in.available()];
 			in.read(ret);
 			System.out.println("服务器端返回的报文为：" + new String(ret, "UTF-8"));
 			response=new String(ret, "UTF-8");
 		} catch (MalformedURLException e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		} catch (IOException e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		} catch (Exception e) {
 			e.printStackTrace();
 			return "调用异常，请排查";
 		}
		return response;
 	}
}
