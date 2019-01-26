package com.team.manage.common.util.secert;

import com.team.manage.enums.SecretType;

import java.util.HashMap;
import java.util.Map;


/**
 * 加密算法工厂类
 * @author tcyu
 *
 */
public class SecretFactory {
	//所有加密算法
	private Map<SecretType,Secret> secrets = new HashMap<SecretType,Secret>();
	
	private static SecretFactory secretFactory = new SecretFactory();
	
	public static SecretFactory getInstance(){
		return secretFactory;
	}
	
	private SecretFactory(){
		registerSecrets();
	}
	
	/**
	 * 获取加密解密算法
	 * @param type
	 * @return
	 */
	public Secret getSecret(SecretType type){
		return secrets.get(type);
	}
	
	private void registerSecrets(){
		//向里面注册加密算法
		secrets.put(SecretType.MD5, new MD5Secret());
		secrets.put(SecretType.DES, new DESSecret());
		secrets.put(SecretType.AES, new AESSecret());
	}
}
