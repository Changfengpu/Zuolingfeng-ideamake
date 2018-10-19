package com.ideamake.dome.model;

public class Client {
	/**
	 * 这是客户的模型类
	 * 
	 * */
	private int c_id;
	private String c_name;
	private String c_sex;
	private int c_phone;
	private String recorder_id;
	private String record_time;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_sex() {
		return c_sex;
	}
	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}
	public int getC_phone() {
		return c_phone;
	}
	public void setC_phone(int c_phone) {
		this.c_phone = c_phone;
	}
	public String getRecorder_id() {
		return recorder_id;
	}
	public void setRecorder_id(String recorder_id) {
		this.recorder_id = recorder_id;
	}
	public String getRecord_time() {
		return record_time;
	}
	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}
	
}
