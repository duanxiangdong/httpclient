package com.duan.merchant.pay;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.duan.http.util.HttpclientUtil;
import com.duan.system.utils.Constants;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.DateUtils;

public class UnionPay {
	private static Random random = new Random();
	private static final String payUrl = "http://sct.nxin.com/chinapay/payment.action";
	private static final String payUrlProd = "https://jr.nxin.com/chinapay/payment.action";
	public static void main(String[] args) {
		pay();
//		query();
	}

	private static void pay() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", "635483618701158236");// ,,,
		map.put("source", "5");
		String order = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + random.nextInt(100);
		map.put("orderno", order);
		map.put("reporderno", "1111111111");
		map.put("businessNo", "11111");
		map.put("cardNo", "6214920202993042");//,,6214830104848816
		map.put("uname", "段向东");
		map.put("openBank", "光大银行");
		map.put("prov", "北京市");
		map.put("city", "北京市");
		map.put("transAmt", "0.07");
		map.put("purpose", "北京银联代付测试");
		map.put("subBank", "北京支行");
		map.put("subTime", DateUtils.formatDate(new Date(), "yyyyMMddHHmmss"));
		map.put("ptype", "5");
	//	map.put("isOrg", "");
//		map.put("signmsg", "111111");
		map.put("times", DateUtils.formatDate(new Date(), Constants.DATE_FORMAT_TYPE_EN_TIME));
		try {
			String signmsgStr = CollectionUtils.sortMap(map);
			System.out.println("签名参数"+signmsgStr);
			String signmsg = MD5.encryption(signmsgStr);
			map.put("signmsg", signmsg);
			String result = HttpclientUtil.postForm(payUrl, map);
			System.out.println("代付结果: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void query() {
		String url = "http://sct.nxin.com/chinapay/getPaymentResult.action";//https://jr.nxin.com/chinapay/getPaymentResult.action ,"http://sct.nxin.com/chinapay/getPaymentResult.action";
		Map<String, String> map = new HashMap<String, String>();
		map.put("orderno", "2016080210410467");
		map.put("nxOrderno", "");
		map.put("userId", "635483618701158236");
		map.put("times", DateUtils.formatDate(new Date(), Constants.DATE_FORMAT_TYPE_EN_TIME));
		try {
			String signmsgStr = CollectionUtils.sortMap(map);
			System.out.println("签名参数"+signmsgStr);
			String signmsg = MD5.encryption(signmsgStr);
			map.put("signmsg", signmsg);
			String result = HttpclientUtil.postForm(url, map);
			System.out.println("查询结果: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
