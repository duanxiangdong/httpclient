package com.duan.api.service;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;

public class GuaranteeConfQueryService {
	private static String guaranteeConfQueryUrl = "http://jrweb.nxin.com/web/callback/getGuaranteeCfmResult.shtml";
	private static String guaranteeConfQueryTestUrl =  "https://jr.t.nxin.com/web/callback/getGuaranteeCfmResult.shtml";
	
	
	public static void main(String[] args) {
		Map map = sendMsg();
		try {
			String res = HttpclientUtil.postForm(guaranteeConfQueryTestUrl, map);
			System.out.println("返回结果:" + res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map sendMsg() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("times", "201811111");
		paramMap.put("orderNo", "S16102020480001");
		paramMap.put("busiNo", "NX-I-001");
		paramMap.put("confirmNo", "170071");
		String str = CollectionUtils.sortMap(paramMap);
		System.out.println("签名字符串:"+str);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return paramMap;
	}

}
