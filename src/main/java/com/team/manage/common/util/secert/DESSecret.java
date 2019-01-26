package com.team.manage.common.util.secert;

import com.team.manage.enums.SecretType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * DES对称加密算法
 *
 * @author tcyu
 */
public class DESSecret extends Secret {
    // 算法名称
    public static final String KEY_ALGORITHM = "DES";

    public static final String KEY_DES_NOPADDING = "DES/ECB/NoPadding";
    // 算法名称/加密模式/填充方式
    // DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 生成密钥
     *
     * @param keyStr
     * @return
     * @throws Exception
     */
    private SecretKey keyGenerator(String keyStr) throws Exception {
        MD5Secret md5Secret = (MD5Secret) SecretFactory.getInstance().getSecret(SecretType.MD5);
        byte input[] = HexString2Bytes(md5Secret.encode(keyStr));
        DESKeySpec desKey = new DESKeySpec(input);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

    private int parse(char c) {
        if (c >= 'a')
            return (c - 'a' + 10) & 0x0f;
        if (c >= 'A')
            return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    // 从十六进制字符串到字节数组转换
    public byte[] HexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    @Override
    public String encode(String str, String coded) throws SecretException {
        throw new SecretException("DES接密需要密钥");
    }

    @Override
    public String decode(String str, String coded) throws SecretException {
        throw new SecretException("DES加密，需要密钥");
    }

    @Override
    public String decodeWithKey(String str, String coded, String key)
            throws Exception {
        Key deskey = keyGenerator(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化Cipher对象，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        // 执行解密操作
        BASE64Decoder deceode = new BASE64Decoder();
        return new String(cipher.doFinal(deceode.decodeBuffer(str)));
    }

    @Override
    public String encodeWithKey(String str, String coded, String key)
            throws Exception {
        Key deskey = keyGenerator(key);
        // 实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        SecureRandom random = new SecureRandom();
        // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        byte[] results = cipher.doFinal(str.getBytes());
        // 该部分是为了与加解密在线测试网站（http://tripledes.online-domain-tools.com/）的十六进制结果进行核对
        for (int i = 0; i < results.length; i++) {
            //System.out.print(results[i] + " ");
        }
        // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
        BASE64Encoder encode = new BASE64Encoder();
        return encode.encode(results);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        DESSecret desSecret = new DESSecret();
        String permission = "2,3,4,5,6,7,8,9,10,11,12,13,14,15,84,96,98,104,105,117";
        String permission1 = "2,3,4,5,6,7,8,9,10,11,12,13,14,15,96,98";
//		  String macAddress = "40-B0-34-52-FB-79"; //jjwu专属有线
//        String macAddress = "C8-21-58-7E-BC-D3"; //jjwu专属无线
        String macAddress = "AC-DE-48-00-11-22";
        String secretKey = desSecret.encodeWithKey(permission1, "utf-8", "47174063-8" + macAddress + "jh520");
        System.out.println(secretKey);
        System.out.println(desSecret.decodeWithKey(secretKey, "utf-8", "47174063-8" + macAddress + "jh520"));
//      eM0hSe6np5E=
    }
}