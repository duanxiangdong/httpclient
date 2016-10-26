package com.duan.wxpay.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WxPayOrderQueryResult {
	private String return_code;
	private String return_msg;
	private String appid;
	private String mch_id;
	private String device_info;
	private String nonce_str;
	private String sign;
	private String result_code;
	private String openid;
	private String is_subscribe;
	private String trade_type;
	private String bank_type;
	private String total_fee;
	private String fee_type;
	private String transaction_id;
	private String out_trade_no;
	private String attach;
	private String time_end;
	private String trade_state;
	private String cash_fee;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("return_code:").append(this.return_code);
		sb.append("&return_msg:").append(this.return_msg);
		sb.append("&appid:").append(this.appid);
		sb.append("&mch_id:").append(this.mch_id);
		sb.append("&device_info:").append(this.device_info);
		sb.append("&nonce_str:").append(this.nonce_str);
		sb.append("&result_code:").append(this.result_code);
		sb.append("&openid:").append(this.openid);
		sb.append("&is_subscribe:").append(this.is_subscribe);
		sb.append("&trade_type:").append(this.trade_type);
		sb.append("&bank_type:").append(this.bank_type);
		sb.append("&total_fee:").append(this.total_fee);
		sb.append("&fee_type:").append(this.fee_type);
		sb.append("&transaction_id:").append(this.transaction_id);
		sb.append("&out_trade_no:").append(this.out_trade_no);
		sb.append("&attach:").append(this.attach);
		sb.append("&time_end:").append(this.time_end);
		sb.append("&trade_state:").append(this.trade_state);
		sb.append("&cash_fee:").append(this.cash_fee);
		return sb.toString();
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

}