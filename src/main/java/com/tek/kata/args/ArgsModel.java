package com.tek.kata.args;

public class ArgsModel<T> {

	private String flag;
	private Class<T> type;
	private Object defaultValue;
	private Object value;

	public ArgsModel() {
		// TODO Auto-generated constructor stub
	}

	public ArgsModel(String flag, Class<T> type, Object defaultValue, Object value) {
		super();
		this.flag = flag;
		this.type = type;
		this.defaultValue = defaultValue;
		this.value = value;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
