package com.duan.wallet.bean;

import java.io.Serializable;

import com.nxin.sysmodule.util.StringUtils;

/**
 * 
 * @author duan 保证金冻结实体
 */
public class WalletFreeze implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId;
	private String orgId;
	private String amount;
	private String freezeType;
	private String busType;
	private String busNo;
	private String description;
	private String remarks;
	private String orderno;
	private String serialSumber;
	private String signmsg;

	public WalletFreeze() {

	}

	@Override
	public String toString() {
		return "userId: " + this.userId + "&amount: " + this.amount + "&freezeType: " + this.freezeType + "&busType: "
				+ this.busType + "&busNo: " + this.busNo + "description: " + this.description + "&remarks: "
				+ this.remarks + "&orderno: " + this.orderno + "&serialSumber: " + this.serialSumber + "&signmsg: "
				+ this.signmsg;
	}

	public String checkParam() {
		String msg = null;
		if (StringUtils.isNull(this.userId)) {
			msg = "userId不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.amount)) {
			msg = "amount不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.busType)) {
			msg = "busType不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.busNo)) {
			msg = "busNo不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.orderno)) {
			msg = "orderno不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.serialSumber)) {
			msg = "serialSumber不能为空";
			return msg;
		}
		if (StringUtils.isNull(this.signmsg)) {
			msg = "signmsg不能为空";
			return msg;
		}
		return msg;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFreezeType() {
		return freezeType;
	}

	public void setFreezeType(String freezeType) {
		this.freezeType = freezeType;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getSerialSumber() {
		return serialSumber;
	}

	public void setSerialSumber(String serialSumber) {
		this.serialSumber = serialSumber;
	}

	public String getSignmsg() {
		return signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
