package com.duan.cardinfo.service;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserCardInfo")
public class UserCardInfo {
	private String userId;
	private String bankName;
	private String mobile;
	private String identityCode;
	private String cardNo;
	private String cardHolder;
	private String signmsg;
	private String cardSignChannel;
	
	public UserCardInfo(String userId,String bankName,String mobile,String identityCode,String cardNo,String cardHolder,String signmsg,String cardSignChannel) {
		this.userId = userId;
		this.bankName = bankName;
		this.mobile = mobile;
		this.identityCode = identityCode;
		this.cardNo = cardNo;
		this.cardHolder = cardHolder;
		this.signmsg = signmsg;
		this.cardSignChannel = cardSignChannel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getSignmsg() {
		return signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}

	public String getCardSignChannel() {
		return cardSignChannel;
	}

	public void setCardSignChannel(String cardSignChannel) {
		this.cardSignChannel = cardSignChannel;
	}
}