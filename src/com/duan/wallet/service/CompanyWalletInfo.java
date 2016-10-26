package com.duan.wallet.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;

public class CompanyWalletInfo {
	private static final Logger log = Logger.getLogger(CompanyWalletInfo.class);
	private static final String url = "http://sct.nxin.com/compWallet/getCompBankAccountInfo.action";

	public static void main(String[] args) {
		Map<String, String> map = sendMsg();
		try {
			String xml = HttpclientUtil.postForm(url, map);
			System.out.println(xml);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public static Map<String, String> sendMsg() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", "1252077");
		map.put("times", DateUtils.formatDate(new Date(), Constants.DATE_FORMAT_TYPE_EN_TIME));
		String signmsgStr = CollectionUtils.sortMap(map);
		String signmsg = MD5.encryption(signmsgStr);
		map.put("signmsg", signmsg);
		return map;
	}
}
