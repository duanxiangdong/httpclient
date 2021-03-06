package com.duan.wxpay.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class WxPayOrder {
	@XStreamAlias("appid")
	private String appid;
	@XStreamAlias("mch_id")
	private String mch_id;
	@XStreamAlias("device_info")
	private String device_info;
	@XStreamAlias("nonce_str")
	private String nonce_str;
	@XStreamAlias("sign")
	private String sign;
	@XStreamAlias("body")
	private String body;
	@XStreamAlias("detail")
	private String detail;
	@XStreamAlias("attach")
	private String attach;
	@XStreamAlias("out_trade_no")
	private String out_trade_no;
	@XStreamAlias("fee_type")
	private String fee_type;
	@XStreamAlias("total_fee")
	private String total_fee;
	@XStreamAlias("spbill_create_ip")
	private String spbill_create_ip;
	@XStreamAlias("time_start")
	private String time_start;
	@XStreamAlias("time_expire")
	private String time_expire;
	@XStreamAlias("goods_tag")
	private String goods_tag;
	@XStreamAlias("notify_url")
	private String notify_url;
	@XStreamAlias("trade_type")
	private String trade_type;
	@XStreamAlias("limit_pay")
	private String limit_pay;
	@XStreamAlias("product_id")
	private String product_id;  //trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
	
	public WxPayOrder() {
		
	}
	
	public WxPayOrder(String appId,String merchantId,String deviceInfo,String nonceStr,String sign,String body,String detail,String attach,String outTradeNo,String feeType,String totalFee,String spbillCreateIp,String timeStart,String timeExpire,String goodsTag,String notifyUrl,String tradeType,String limitPay){
		this.appid = appId;
		this.mch_id = merchantId;
		this.device_info = deviceInfo;
		this.nonce_str = nonceStr;
		this.sign = sign;
		this.body = body;
		this.detail = detail;
		this.attach = attach;
		this.out_trade_no = outTradeNo;
		this.fee_type = feeType;
		this.total_fee = totalFee;
		this.spbill_create_ip = spbillCreateIp;
		this.time_start = timeStart;
		this.time_expire = timeExpire;
		this.goods_tag = goodsTag;
		this.notify_url = notifyUrl;
		this.trade_type = tradeType;
		this.limit_pay = limitPay;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("appId:").append(this.appid);
		sb.append("&merchantId:").append(this.mch_id);
		sb.append("&deviceInfo:").append(this.device_info);
		sb.append("&nonceStr:").append(this.nonce_str);
		sb.append("&sign:").append(this.sign);
		sb.append("&body:").append(this.body);
		sb.append("&detail:").append(this.detail);
		sb.append("&attach:").append(this.attach);
		sb.append("&outTradeNo:").append(this.out_trade_no);
		sb.append("&feeType:").append(this.fee_type);
		sb.append("&totalFee:").append(this.total_fee);
		sb.append("&spbillCreateIp:").append(this.spbill_create_ip);
		sb.append("&timeStart:").append(this.time_start);
		sb.append("&timeExpire:").append(this.time_expire);
		sb.append("&goodsTag:").append(this.goods_tag);
		sb.append("&notifyUrl:").append(this.notify_url);
		sb.append("&tradeType:").append(this.trade_type);
		sb.append("&limitPay:").append(this.limit_pay);
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
}