package com.babailiren.ec.model;

import java.io.Serializable;

public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	/** * 流水号 ** */
	private Long id;

	/** *用户名 ** */
	private String sta_username;

	/** * 密码 ** */
	private String sta_password;

	/** * 邮箱 ** */
	private String sta_email;

	/** * 真实姓名 ** */
	private String sta_name;

	/** * 性别 ** */
	private String sta_sex;

	/** * 省份 ** */
	private String sta_province;

	/** * 电话 ** */
	private String sta_tel;

	/** * 手机 ** */
	private String sta_mobile;

	/** * 状态 ** */
	private String sta_loginstatus;

	/** * 注册日期 ** */
	private String sta_createdate;

	/** * 职责 ** */
	private String sta_station;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSta_username() {
		return sta_username;
	}

	public void setSta_username(String staUsername) {
		sta_username = staUsername;
	}

	public String getSta_password() {
		return sta_password;
	}

	public void setSta_password(String staPassword) {
		sta_password = staPassword;
	}

	public String getSta_email() {
		return sta_email;
	}

	public void setSta_email(String staEmail) {
		sta_email = staEmail;
	}

	public String getSta_name() {
		return sta_name;
	}

	public void setSta_name(String staName) {
		sta_name = staName;
	}

	public String getSta_sex() {
		return sta_sex;
	}

	public void setSta_sex(String staSex) {
		sta_sex = staSex;
	}

	public String getSta_province() {
		return sta_province;
	}

	public void setSta_province(String staProvince) {
		sta_province = staProvince;
	}

	public String getSta_tel() {
		return sta_tel;
	}

	public void setSta_tel(String staTel) {
		sta_tel = staTel;
	}

	public String getSta_mobile() {
		return sta_mobile;
	}

	public void setSta_mobile(String staMobile) {
		sta_mobile = staMobile;
	}

	public String getSta_loginstatus() {
		return sta_loginstatus;
	}

	public void setSta_loginstatus(String staLoginstatus) {
		sta_loginstatus = staLoginstatus;
	}

	public String getSta_createdate() {
		return sta_createdate;
	}

	public void setSta_createdate(String staCreatedate) {
		sta_createdate = staCreatedate;
	}

	public String getSta_station() {
		return sta_station;
	}

	public void setSta_station(String staStation) {
		sta_station = staStation;
	}
}
