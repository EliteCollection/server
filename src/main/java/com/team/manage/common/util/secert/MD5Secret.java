package com.team.manage.common.util.secert;


import java.security.MessageDigest;


/**
 * MD5算法
 *
 * @author tcyu
 */
public class MD5Secret extends Secret {

    private final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    private String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];

    }


    @Override
    public String decode(String str, String coded) {
        //System.out.println("MD5没有解密算法");
        return null;
    }

    @Override
    public String encode(String str, String coded) {
        String resultString = null;
        try {
            resultString = new String(str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(
                    coded == null ? resultString.getBytes() : resultString.getBytes(coded)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    @Override
    public String decodeWithKey(String str, String coded, String key) { //抛出异常
        //System.out.println("带密钥解密 不支持");
        return null;
    }

    @Override
    public String encodeWithKey(String str, String coded, String key) { //抛出异常
        //System.out.println("带密钥加密 不支持");
        return null;
    }
}
