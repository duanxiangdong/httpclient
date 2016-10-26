package com.duan.wxpay.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("xml")
public class WxPayOrderQuery {
	@XStreamAlias("appid")
	private String appid;
	@XStreamAlias("mch_id")
	private String mch_id;
	@XStreamAlias("transaction_id")
	private String transaction_id;
	@XStreamAlias("out_trade_no")
	private String out_trade_no;
	@XStreamAlias("nonce_str")
	private String nonce_str;
	@XStreamAlias("sign")
	private String sign;
	
	public WxPayOrderQuery() {
		
	}
	
	public WxPayOrderQuery(String appid,String mchId,String transactionId,String outTradeNo,String nonceStr,String sign){
		this.appid = appid;
		this.mch_id = mchId;
		this.transaction_id = transactionId;
		this.out_trade_no = outTradeNo;
		this.nonce_str = nonceStr;
		this.sign = sign;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("appid:").append(this.appid);
		sb.append("&mchId:").append(this.mch_id);
		sb.append("&transactionId:").append(this.transaction_id);
		sb.append("&outTradeNo:").append(this.out_trade_no);
		sb.append("&nonceStr:").append(this.nonce_str);
		sb.append("&sign:").append(this.sign);
		return sb.toString();
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}