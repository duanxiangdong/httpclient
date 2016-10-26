package com.duan.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.SecurityUtils;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;

public class AbcSignStatusService {	
	private static final String url = "http://jrapi.nxin.com/api/web/cardManagement/getUserAbcSignStatus.shtml";
	private static final String testUrl = "http://jrapi.t.nxin.com/api/web/cardManagement/getUserAbcSignStatus.shtml";
	
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "11111");//1197964
		map.put("times", DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER));		
		String str = CollectionUtils.sortMap(map);
		System.out.println("签名字符串:"+str);
		String sign = SecurityUtils.getSignmsg(str);
		map.put("signmsg", sign);		
		try {
			String res = HttpclientUtil.postForm(testUrl, map);
			System.out.println("查询结果"+res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}