package com.team.manage.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Result 简单实现
 * 
 * @author tcyu
 * @date 2019-01-26 17:14
 * @email remotejavasky@gmail.com
 * 
 * @see Result
 */
public class SimpleResult<T> implements Result<T> {

	private static final long serialVersionUID = -8023773772100868939L;

	/**
	 * 默认成功
	 */
	private boolean success = true;

	/**
	 * 处理结果code
	 */
	private Integer resultCode;

	/**
	 * 默认只有3个model
	 */
	private Map<String, Object> models = new HashMap<String, Object>(4);

	/**
	 * 默认目标model的key
	 */
	private String defaultModelKey;

	private String messageModelKey;

	@Override
	public boolean isSuccess() {
		return success;
	}

	@Override
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public Integer getResultCode() {
		return resultCode;
	}

	@Override
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	private String getDefaultModelKey() {
		return defaultModelKey == null ? DEFAULT_MODEL_KEY : defaultModelKey;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getDefaultModel() {
		return (T) models.get(getDefaultModelKey());
	}

	@Override
	public void setDefaultModel(T model) {
		models.put(getDefaultModelKey(), model);
	}

	@Override
	public void setDefaultModel(String key, T model) {
		this.defaultModelKey = (key == null ? DEFAULT_MODEL_KEY : key);
		models.put(defaultModelKey, model);

	}

	private String getMessageKey() {
		return messageModelKey == null ? MESSAGE_MODEL_KEY : messageModelKey;
	}

	@Override
	public void setMessage(String message) {
		models.put(getMessageKey(), message);
	}

	@Override
	public void setMessage(String key, String message) {
		this.messageModelKey = (key == null ? MESSAGE_MODEL_KEY : key);
		models.put(messageModelKey, message);
	}

	@Override
	public String getMessage() {
		return (String) models.get(getMessageKey());
	}

	@Override
	public <M extends Serializable> void addModel(String key, M model) {
		if (key == null)
			throw new IllegalArgumentException("Model key can't be null");
		models.put(key, model);

	}

	@Override
	public <T1> void addModel(String key, T1 model) {
		if (key == null)
			throw new IllegalArgumentException("Model key can't be null");
		models.put(key, model);
	}

	@Override
	public Map<String, Object> getModels() {
		return models;
	}

	@Override
	public String toString() {
		return "SimpleResult [success=" + success + ", resultCode=" + resultCode + ", models=" + models
				+ ", defaultModelKey=" + defaultModelKey + ", messageModelKey=" + messageModelKey + "]";
	}

	public SimpleResult() {
		super();
	}

	public SimpleResult(boolean success) {
		super();
		this.success = success;
	}

	@Override
	public void setModels(Map<String, Object> models) {
	}

}
