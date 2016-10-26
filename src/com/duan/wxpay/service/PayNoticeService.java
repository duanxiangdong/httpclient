package com.duan.wxpay.service;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.util.Constants;

public class PayNoticeService {
	
	private static final String noticeDevUrl = "https://jrp.nxin.com/web/callback/wxPayCallback.shtml";
	private static final String url = "http://jrweb.nxin.com/web/callback/wxPayCallback.shtml";
	public static void main(String[] args) {
		String str = "<xml>"+
					"<appid><![CDATA[wx28afed703d3c092a]]></appid>"+
					"<bank_type><![CDATA[CFT]]></bank_type>"+
					"<cash_fee><![CDATA[1]]></cash_fee>"+
					"<device_info><![CDATA[WEB]]></device_info>"+
					"<fee_type><![CDATA[CNY]]></fee_type>"+
					"<is_subscribe><![CDATA[N]]></is_subscribe>"+
					"<mch_id><![CDATA[1392711702]]></mch_id>"+
					"<nonce_str><![CDATA[e1bff02a03b449538fa86008312d0ef8]]></nonce_str>"+
					"<openid><![CDATA[ovPiat-l1_E_46JVfSG13aqUT7I4]]></openid>"+
					"<out_trade_no><![CDATA[20160927110354]]></out_trade_no>"+
					"<result_code><![CDATA[SUCCESS]]></result_code>"+
					"<return_code><![CDATA[SUCCESS]]></return_code>"+
					"<sign><![CDATA[46677D12B7185EEDE039DF087C59C9B1]]></sign>"+
					"<time_end><![CDATA[20160927110404]]></time_end>"+
					"<total_fee>1</total_fee>"+
					"<trade_type><![CDATA[APP]]></trade_type>"+
					"<transaction_id><![CDATA[4000212001201609275048259210]]></transaction_id>"+
					"</xml>";
		try {
			String responseXml = HttpclientUtil.postXml(url, str, Constants.ENCODE_UTF8);			
			System.out.println("微信下单返回交易结果报文:" + responseXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}