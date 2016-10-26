package com.duan.wxpay.service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.duan.http.util.HttpclientUtil;
import com.duan.wxpay.bean.WxPayOrder;
import com.duan.wxpay.bean.WxPayOrderResult;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WxPayOrderService {
	private static final String testUrl = "https://api.mch.weixin.qq.com/sandbox/pay/unifiedorder";
	private static final String prodUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
	public static void main(String[] args) {
		
		String noncestr = UUID.randomUUID().toString().trim().replaceAll("-", "");
		
		String orderNo = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);		
				
		WxPayOrder order = new WxPayOrder("wx28afed703d3c092a","1392711702","WEB",noncestr,"","腾讯充值中心-QQ会员充值","Ipad mini  16G  白色","深圳分店",orderNo,"CNY","1","123.12.12.123","","","","http://www.weixin.qq.com/wxpay/pay.php","NATIVE","");
		
		order.setProduct_id(orderNo);
		
		Map<String,String> beanMap = CollectionUtils.beanToMap(order);
		
		String signStr = WxpaySignatureService.sortParameterMap(beanMap);
		
		String signMsg = WxpaySignatureService.wxpaySignature(signStr);
		
		order.setSign(signMsg);
		
		XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));

		xstream.processAnnotations(WxPayOrder.class);
		
		String requestXml = xstream.toXML(order);
		
		System.out.println("微信下单发送请求报文:"+requestXml);
		try {
			String responseXml = HttpclientUtil.postXml(prodUrl, requestXml, Constants.ENCODE_UTF8);
			System.out.println("微信下单返回交易结果报文:"+responseXml);			
//			xstream.processAnnotations(WxPayOrderResult.class);
//			WxPayOrderResult response = (WxPayOrderResult) xstream.fromXML(responseXml);			
//			System.out.println("交易结果实体:"+response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}