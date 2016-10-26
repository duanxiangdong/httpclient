package com.duan.wxpay.service;

import java.util.Map;
import java.util.UUID;

import com.duan.http.util.HttpclientUtil;
import com.duan.wxpay.bean.WxPayOrderQuery;
import com.duan.wxpay.bean.WxPayOrderQueryResult;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.Constants;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WxPayOrderQueryService {
	private static final String proUrl = "https://api.mch.weixin.qq.com/pay/orderquery";
	private static final String testUrl = "https://api.mch.weixin.qq.com/sandbox/pay/orderquery";

	public static void main(String[] args) {

		String noncestr = UUID.randomUUID().toString().trim().replaceAll("-", "");
		
		WxPayOrderQuery wxPayOrderQuery = new WxPayOrderQuery("wx28afed703d3c092a", "1392711702", "", "11609270200201", noncestr,"");

		Map<String, String> beanMap = CollectionUtils.beanToMap(wxPayOrderQuery);

		String signStr = WxpaySignatureService.sortParameterMap(beanMap);

		String signMsg = WxpaySignatureService.wxpaySignature(signStr);

		wxPayOrderQuery.setSign(signMsg);

		XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));

		xstream.processAnnotations(WxPayOrderQuery.class);

		String requestXml = xstream.toXML(wxPayOrderQuery);

		System.out.println("微信下单发送请求报文:" + requestXml);

		try {
			String responseXml = HttpclientUtil.postXml(testUrl, requestXml, Constants.ENCODE_UTF8);			
			System.out.println("微信下单返回交易结果报文:" + responseXml);
			xstream.processAnnotations(WxPayOrderQueryResult.class);
			WxPayOrderQueryResult response = (WxPayOrderQueryResult) xstream.fromXML(responseXml);
			System.out.println("微信下单返回实体Bean:"+response);	
			System.out.println(response.getReturn_code());
			System.out.println(response.getResult_code());
			System.out.println(response.getTrade_state());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}