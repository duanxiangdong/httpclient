package com.duan.wallet.bean;

import java.util.Map;

public class WalletFreezeRes {
	private String retCode;
	private String retMsg;
	private String times;
	private String signmsg;
	private Map<String,String> data;

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getSignmsg() {
		return signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}

	public Map<String,String> getData() {
		return data;
	}

	public void setData(Map<String,String> data) {
		this.data = data;
	}

}
