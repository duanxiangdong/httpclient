package com.duan.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;

public class GuaranteeConfService {
	private static String guaranteeConfUrl = "http://jrweb.nxin.com/web/guaranteeCfm/guaranteeCfm.shtml";
	private static String guaranteeConfTestUrl = "https://jr.t.nxin.com/web/callback/guaranteeCfm.shtml";
	private static String testUrl = "https://jr.t.nxin.com/web/callback/abcGateWay/abcGateWayCallback.shtml";
	
	
	public static void main(String[] args) {
		Map map = sendMsg();
		try {
			String res = HttpclientUtil.postForm(guaranteeConfTestUrl, map);
			System.out.println("返回结果:" + res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map sendMsg() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("times", "201811111");
		paramMap.put("orderNo", "S16101817450001");
		paramMap.put("orderDetailNo", "S16101817450001");
		paramMap.put("busiNo", "NX-I-001");
		String confirmNo = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		paramMap.put("confirmNo", confirmNo);
		paramMap.put("callBackUrl", "11111");
		paramMap.put("payAmount", "200.00");
		paramMap.put("shareData", "");
		paramMap.put("sellerId", "1253530");
		String str = CollectionUtils.sortMap(paramMap);
		System.out.println("签名字符串:"+str);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return paramMap;
	}

}
