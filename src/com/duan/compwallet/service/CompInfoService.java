package com.duan.compwallet.service;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.JSONUtils;

public class CompInfoService {
	private static final String url = "http://jrapi.nxin.com/api/web/compWallet/getCompBankAccountInfo.shtml";

	public static void main(String[] args) {
		String jsonStr = sendMsg();
		System.out.println(jsonStr);
		try {
			String res = HttpclientUtil.postJson(url, jsonStr, "utf8");
			System.out.println("返回结果:" + res);
			Map map = JSONUtils.jsonStrToBean(res, Map.class);
			String signmsg = (String) map.remove("signmsg");
			String str = CollectionUtils.sortMap(map);
			System.out.println("参与加密的字符串___" + str);
			String verifySignmsg = MD5.encryption(str);
			if (!verifySignmsg.equals(signmsg)) {
				throw new Exception("签名信息不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sendMsg() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", "1252452");
		String str = CollectionUtils.sortMap(paramMap);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return JSONUtils.beanToJSONStr(paramMap);
	}

}
