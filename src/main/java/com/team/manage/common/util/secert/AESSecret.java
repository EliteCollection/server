package com.team.manage.common.util.secert;


import com.team.manage.enums.SecretType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;


/**
 * AES对称加密算法,比DES加密算法高
 *
 * @author tcyu
 */
public class AESSecret extends Secret {
    // 算法名称
    public static final String KEY_ALGORITHM = "AES";
    // 算法名称/加密模式/填充方式
    // DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    public static final String CIPHER_ALGORITHM = "AES";


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
        throw new SecretException("AES接密需要密钥");
    }

    @Override
    public String decode(String str, String coded) throws SecretException {
        throw new SecretException("AES加密，需要密钥");
    }

    @Override
    public String decodeWithKey(String str, String coded, String key)
            throws Exception {
        //1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        //2.根据ecnodeRules规则初始化密钥生成器
        //生成一个128位的随机源,根据传入的字节数组
        keygen.init(128, new SecureRandom(key.getBytes()));
        //3.产生原始对称密钥
        SecretKey originalKey = keygen.generateKey();
        //4.获得原始对称密钥的字节数组
        byte[] raw = originalKey.getEncoded();
        //5.根据字节数组生成AES密钥
        SecretKey secretKey = new SecretKeySpec(raw, "AES");
        //6.根据指定算法AES自成密码器
        Cipher cipher = Cipher.getInstance("AES");
        //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //8.将加密并编码后的内容解码成字节数组
        byte[] byteContent = new BASE64Decoder().decodeBuffer(str);
            /*
             * 解密
             */
        byte[] byteDecode = cipher.doFinal(byteContent);
        return new String(byteDecode, coded);
    }

    @Override
    public String encodeWithKey(String str, String coded, String key)
            throws Exception {
        //1.构造密钥生成器，指定为AES算法,不区分大小写
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        //2.根据ecnodeRules规则初始化密钥生成器
        //生成一个128位的随机源,根据传入的字节数组
        keygen.init(128, new SecureRandom(key.getBytes()));
        //3.产生原始对称密钥
        SecretKey originalKey = keygen.generateKey();
        //4.获得原始对称密钥的字节数组
        byte[] raw = originalKey.getEncoded();
        //5.根据字节数组生成AES密钥
        SecretKey secretKey = new SecretKeySpec(raw, "AES");
        //6.根据指定算法AES自成密码器
        Cipher cipher = Cipher.getInstance("AES");
        //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
        byte[] byteEncode = str.getBytes(coded);
        //9.根据密码器的初始化方式--加密：将数据加密
        byte[] byteAes = cipher.doFinal(byteEncode);
        //10.将加密后的数据转换为字符串
        //这里用Base64Encoder中会找不到包
        //解决办法：
        //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
        //11.将字符串返回
        return new String(new BASE64Encoder().encode(byteAes));
    }

    public static void main(String[] args) throws Exception {
        String s2 = SecretFactory.getInstance().getSecret(SecretType.AES).encodeWithKey("test1234567", "123456");
        String s3 = SecretFactory.getInstance().getSecret(SecretType.AES).decodeWithKey(s2, "123456");
        System.out.println(s2);
        System.out.println(s3);
    }


}