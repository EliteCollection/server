package com.team.manage.enums;
/**
 * 枚举，加密算法类型
 * @author tcyu
 *
 */
public enum SecretType {
	MD5("MD5","MD5算法:单向算法，只有加密，没有解密"),
	DES("DES","DES算法:已经被破解，对称加密"),
	AES("AES","AES算法:已破解，但破解有很大的技术难度，对称加密算法,较安全");
	
	private String desc;
	private String key;
	
	SecretType(String key, String desc){
		this.key = key;
		this.desc = desc;
	}
	
	/**
	 * 根据key返回枚举
	 * @param key
	 * @return
	 */
	public static SecretType getType(String key){
		for(SecretType type:values()){
			if(type.key.equals(key)){
				return type;
			}
		}
		return null;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}