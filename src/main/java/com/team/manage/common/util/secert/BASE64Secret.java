package com.team.manage.common.util.secert;



/**
 * BASE64位算法
 * @author tcyu
 *
 */
public class BASE64Secret extends Secret {

	@Override
	public String encode(String str, String coded) throws SecretException {
		throw new SecretException("需要带密钥加密");
	}

	@Override
	public String decode(String str, String coded) throws SecretException {
		throw new SecretException("需要带解密");
	}

	@Override
	public String decodeWithKey(String str, String coded, String key) throws SecretException {
		throw new SecretException("需要带密钥解密");
	}

	@Override
	public String encodeWithKey(String str, String coded, String key) throws SecretException {
		throw new SecretException("需要带密钥解密");
	}

}
