package com.team.manage.common;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author tcyu
 * @date 2019-01-26 17:13
 * 
 * @param <T>
 *            default model Class
 */
public interface Result<T> extends Serializable {

	/**
	 * 
	 */
	String DEFAULT_MODEL_KEY = "defaultModelKey";

	String MESSAGE_MODEL_KEY = "messageModelKey";

	/**
	 * 请求是否成功。
	 * 
	 * @return 如果成功，则返回<code>true</code>
	 */
	boolean isSuccess();

	/**
	 * 设置请求成功标志。
	 * 
	 * @param success
	 *            成功标志
	 */
	void setSuccess(boolean success);

	/**
	 * 取得结果代码。
	 * 
	 * @return 结果代码
	 */
	Integer getResultCode();

	/**
	 * 设置结果代码。
	 * 
	 * @param resultCode
	 *            结果代码
	 */
	void setResultCode(Integer resultCode);

	/**
	 * 取得model对象。
	 * 
	 * <p>
	 * 此调用相当于<code>getModels().get(getDefaultModelKey())</code>。
	 * 
	 * @return model对象
	 */
	T getDefaultModel();

	/**
	 * 设置model对象。
	 * 
	 * <p>
	 * 此调用相当于<code>getModels().put(DEFAULT_MODEL_KEY, model)</code>。
	 * 
	 * @param model
	 *            model对象
	 */
	void setDefaultModel(T model);

	/**
	 * 设置model对象。
	 * 
	 * <p>
	 * 此调用相当于<code>getModels().put(key, model)</code>。
	 * 
	 * @param key
	 *            字符串key
	 * @param model
	 *            model对象
	 */
	void setDefaultModel(String key, T model);

	/**
	 * 
	 * @param message
	 */
	void setMessage(String message);

	/**
	 * 
	 * @param key
	 * @param message
	 */
	void setMessage(String key, String message);

	/**
	 * 
	 * @return
	 */
	String getMessage();

	/**
	 * 
	 * @param key
	 * @param model
	 */
	<M extends Serializable> void addModel(String key, M model);

	/**
	 * list对象使用
	 * @param key
	 * @param model
	 * @param <T1>
	 */
	<T1> void addModel(String key, T1 model);

	/**
	 * 取得所有model对象。
	 * 
	 * @return model对象表
	 */
	Map<String, Object> getModels();
	
	/**
	 * do nothing for flex serialization
	 */
	void setModels(Map<String, Object> models);

}
