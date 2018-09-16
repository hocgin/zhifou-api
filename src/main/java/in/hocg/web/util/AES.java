package in.hocg.web.util;

import in.hocg.base.constant.Charset;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Created by hocgin on 2018/9/13.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public final class AES {
    
    /**
     * 加密
     *
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     * @throws Exception
     */
    public static String encrypt(String encryptedData, String sessionKey, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sessionKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(encryptedData.getBytes(Charset.UTF_8));
        //此处使用BASE64做转码。
        return new BASE64Encoder().encode(encrypted);
    }
    
    /**
     * 解密
     *
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     */
    public static String decrypt(String encryptedData, String sessionKey, String iv) {
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] sessionKeyByte = decoder.decode(sessionKey);
            byte[] encryptedDataByte = decoder.decode(encryptedData);
            byte[] ivByte = decoder.decode(iv);
            
            SecretKeySpec spec = new SecretKeySpec(sessionKeyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivByte);
            cipher.init(Cipher.DECRYPT_MODE, spec, ivParameterSpec);
            //先用base64解密
            byte[] original = cipher.doFinal(encryptedDataByte);
            return new String(original, Charset.UTF_8);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
}


