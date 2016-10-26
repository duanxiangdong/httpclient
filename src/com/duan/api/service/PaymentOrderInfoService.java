package com.duan.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.SecurityUtils;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.nxin.sysmodule.util.StringUtils;

public class PaymentOrderInfoService {
	
	private static String getOrderInfoUrl = "http://jrapi.t.nxin.com/api/payment/getOrderInfo.shtml";
	private static String url = "http://jrapi.nxin.com/api/payment/getOrderInfo.shtml";
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("busiNo", "NX-I-001");
		map.put("orderNo", "S16091813420001");
		String smsg = "busiNo" + StringUtils.strVal(map.get("busiNo")) + "orderNo" + StringUtils.strVal(map.get("orderNo"));
		String sign = SecurityUtils.getSignmsg(smsg);
		map.put("signmsg", sign);
		String time = DateUtils.formatDate(new Date(), Constants.DATE_FORMAT_TYPE_EN_TIME);
		map.put("times", time);
		String resMsg = "";
		try {
			resMsg = HttpclientUtil.postForm(getOrderInfoUrl, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("交易返回结果:"+resMsg);
	}
}
