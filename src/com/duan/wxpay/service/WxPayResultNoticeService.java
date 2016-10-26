package com.duan.wxpay.service;

import java.util.Map;

import com.duan.wxpay.bean.WxpayResultNotice;
import com.nxin.sysmodule.util.CollectionUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WxPayResultNoticeService {
	public static void main(String[] args) {
		String payResult = "<xml>"+
			  "<appid><![CDATA[wx2421b1c4370ec43b]]></appid>"
			  +"<attach><![CDATA[支付测试]]></attach>"+
			  "<bank_type><![CDATA[CFT]]></bank_type>"+
			  "<fee_type><![CDATA[CNY]]></fee_type>"+
			  "<is_subscribe><![CDATA[Y]]></is_subscribe>"+
			  "<mch_id><![CDATA[10000100]]></mch_id>"+
			  "<nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>"+
			  "<openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>"+
			  "<out_trade_no><![CDATA[1409811653]]></out_trade_no>"
			  +"<result_code><![CDATA[SUCCESS]]></result_code>"+
			  "<return_code><![CDATA[SUCCESS]]></return_code>"
			  +"<sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>"
			  +"<sub_mch_id><![CDATA[10000100]]></sub_mch_id>"+
			  "<time_end><![CDATA[20140903131540]]></time_end>"
			  +"<total_fee>1</total_fee>"+
			  "<trade_type><![CDATA[JSAPI]]></trade_type>"
			  +"<transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>"+"</xml>";
		
		XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		
		xstream.processAnnotations(WxpayResultNotice.class);
		
		WxpayResultNotice response = (WxpayResultNotice) xstream.fromXML(payResult);
		
		System.out.println("报文解析"+response);
		
		Map<String,String> beanMap = CollectionUtils.beanToMap(response);
		
		String sign = beanMap.remove("sign");
		
		String signStr = WxpaySignatureService.sortParameterMap(beanMap);
		
		System.out.println("参与签名字符串"+signStr);
		
		String signMsg = WxpaySignatureService.wxpaySignature(signStr);
		
		System.out.println("本地生成签名信息"+signMsg);
		
		if(!sign.equals(signMsg)){
			System.out.println("签名信息不匹配");
		}
	}
}
