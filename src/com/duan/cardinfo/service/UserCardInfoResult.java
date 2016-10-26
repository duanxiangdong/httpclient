package com.duan.cardinfo.service;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserCardInfoResult")
public class UserCardInfoResult {
	private String status;
	private String resMsg;
	private String userId;
	private String signmsg;

	public UserCardInfoResult(String status,String resMsg,String userId,String signmsg) {
		this.status = status;
		this.resMsg = resMsg;
		this.userId = userId;
		this.signmsg = signmsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSignmsg() {
		return signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}
	
}
