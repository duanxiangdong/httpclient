package com.duan.wxpay.bean;

import com.thoughtworks.xstream.XStream;

public class WxpayXmlTest {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.processAnnotations(WxPayOrder.class);
		WxPayOrder wxPayOrder = new WxPayOrder("","","","","","","","","","","","","","","","","","");
		String bodyXml = xstream.toXML(wxPayOrder);
		System.out.println("请求报文:"+bodyXml);
	}
}
