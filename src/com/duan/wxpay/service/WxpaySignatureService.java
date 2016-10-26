package com.duan.wxpay.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.nxin.sysmodule.security.MD5;

public class WxpaySignatureService {
	public final static String sortParameterMap(final Map<String, String> param) {
		if (null == param || param.isEmpty()) {
			return null;
		}
		List<Map.Entry<String, String>> sortList = new ArrayList<Map.Entry<String, String>>(param.entrySet());
		Collections.sort(sortList, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> paramOne, Map.Entry<String, String> paramTwo) {
				return paramOne.getKey().compareTo(paramTwo.getKey());
			}
		});
		StringBuffer str = new StringBuffer();
		for (Map.Entry<String, String> map : sortList) {
			if (null != map.getValue() && !"".equals(map.getValue())) {
				str.append(map.getKey().trim());
				str.append("=" + map.getValue() + "&");
			}
		}
		str.append("key=579347Eeff744ea59B6e4448226Dc2ef");
		return str.toString();
	}

	public final static String wxpaySignature(final String str) {
		return MD5.encryption(str).toUpperCase();
	}

}