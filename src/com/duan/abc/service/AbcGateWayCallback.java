package com.duan.abc.service;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;

public class AbcGateWayCallback {
	private static final String url =  "http://jrweb.nxin.com/web/callback/abcGateWay/abcGateWayCallback.shtml";
	private static final String testUrl =  "https://jrt.nxin.com/web/callback/abcGateWay/abcGateWayCallback.shtml";
	private static final String ProdUrl =  "https://jr.nxin.com/web/callback/abcGateWay/abcGateWayCallback.shtml";
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("MSG", "sdfsdfsdfsdfsdfsdf");
		try {
			HttpclientUtil.postForm(ProdUrl, map);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
