package com.duan.wxpay.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WxPayOrderResult {
	@XStreamAlias("return_code")
	private String returnCode;
	@XStreamAlias("return_msg")
	private String returnMsg;
	@XStreamAlias("appid")
	private String appid;
	@XStreamAlias("mch_id")
	private String merchantId;
	@XStreamAlias("device_info")
	private String deviceInfo;	
	@XStreamAlias("nonce_str")
	private String nonceStr;
	@XStreamAlias("sign")
	private String sign;
	@XStreamAlias("result_code")
	private String resultCode;
	@XStreamAlias("err_code")
	private String errCode;
	@XStreamAlias("err_code_des")
	private String errCodeDes;
	@XStreamAlias("trade_type")
	private String tradeType;
	@XStreamAlias("prepay_id")
	private String prepayId;
	@XStreamAlias("err_msg")
	private String errMsg;	
	@XStreamAlias("code_url")
	private String codeUrl;
			
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("returnCode:").append(this.returnCode);
		sb.append("&returnMsg:").append(this.returnMsg);
		sb.append("&appid:").append(this.appid);
		sb.append("&merchantId:").append(this.merchantId);
		sb.append("&deviceInfo:").append(this.deviceInfo);
		sb.append("&nonceStr:").append(this.nonceStr);
		sb.append("&sign:").append(this.sign);
		sb.append("&resultCode:").append(this.resultCode);
		sb.append("&errCode:").append(this.errCode);
		sb.append("&errCodeDes:").append(this.errCodeDes);
		sb.append("&tradeType:").append(this.tradeType);
		sb.append("&prepayId:").append(this.prepayId);
		sb.append("&errMsg:").append(this.errMsg);
		sb.append("&codeUrl:").append(this.codeUrl);
		return sb.toString();
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getNonce_str() {
		return nonceStr;
	}
	public void setNonce_str(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrCodeDes() {
		return errCodeDes;
	}
	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getPrepayId() {
		return prepayId;
	}
	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}	
}