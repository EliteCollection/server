package com.team.manage.common.util.secert;


import com.team.manage.common.util.secert.SecretException;

/**
 * 加密算法基类
 *
 * @author bjyuan
 */
public abstract class Secret {

    /**
     * 无密钥解密
     *
     * @param str
     * @param coded
     * @return
     * @throws SecretException
     */
    public abstract String encode(String str, String coded) throws SecretException;


    /**
     * 无密钥加密
     *
     * @param str
     * @param coded
     * @return
     * @throws SecretException
     */
    public abstract String decode(String str, String coded) throws SecretException;

    /**
     * @param str
     * @param coded
     * @param key
     * @return
     * @throws SecretException
     * @throws Exception
     */
    public abstract String decodeWithKey(String str, String coded, String key) throws Exception;

    /**
     * @param str
     * @param coded
     * @param key
     * @return
     * @throws SecretException
     * @throws Exception
     */
    public abstract String encodeWithKey(String str, String coded, String key) throws Exception;

    /**
     * @param str
     * @return
     */
    public String encode(String str) throws SecretException {
        return encode(str, null);
    }

    /**
     * 默认utf-8编码
     *
     * @param str
     * @return
     */
    public String decode(String str) throws SecretException {
        return decode(str, "utf-8");
    }

    /**
     * 默认utf-8编码
     *
     * @param str
     * @param key
     * @return
     */
    public String decodeWithKey(String str, String key) throws Exception {
        return decodeWithKey(str, "utf-8", key);
    }

    /**
     * 默认utf-8解码
     *
     * @param str
     * @param key
     * @return
     */
    public String encodeWithKey(String str, String key) throws Exception {
        return encodeWithKey(str, "utf-8", key);
    }
}
