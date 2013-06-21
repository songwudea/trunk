package com.babailiren.thirdpart.qq.vo;

import java.util.List;


public class QqInfoVo {
	private QqInfoDataVo data;
	private String errcode;
	private String msg;
	private String ret;
	private String seqid;
	
	
	public QqInfoDataVo getData() {
		return data;
	}
	public void setData(QqInfoDataVo data) {
		this.data = data;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRet() {
		return ret;
	}
	public void setRet(String ret) {
		this.ret = ret;
	}
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	
}
