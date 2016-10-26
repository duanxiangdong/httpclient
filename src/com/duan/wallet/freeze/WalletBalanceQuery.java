package com.duan.wallet.freeze;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.duan.wallet.bean.WalletFreezeRes;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.JSONUtils;

public class WalletBalanceQuery {
	private static String walletBalanceQueryUrl = "http://jrapi.nxin.com/api/web/wallet/getWalletBalance.shtml";
	private static String walletUnfreezeQueryUrlDev = "https://jrapi.p.nxin.com/api/web/wallet/getWalletBalance.shtml";													   
	public static void main(String[] args) {
		String jsonStr = sendMsg();
		try {
			String res = HttpclientUtil.postJson(walletBalanceQueryUrl, jsonStr, "utf8");
			System.out.println("返回结果___" + res);
			WalletFreezeRes resBean = JSONUtils.jsonStrToBean(res, WalletFreezeRes.class);
			Map<String, String> map = new HashMap<String, String>();
			map.putAll(resBean.getData());
			map.put("retCode", resBean.getRetCode());
			map.put("retMsg", resBean.getRetMsg());
			map.put("times", resBean.getTimes());
			String str = CollectionUtils.sortMap(map);
			System.out.println("参与加密的字符串___" + str);
			String verifySignmsg = MD5.encryption(str);
			if (!verifySignmsg.equals(resBean.getSignmsg())) {
				throw new Exception("签名信息不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String sendMsg() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", "1198185");
		paramMap.put("userType", "2");
		String str = CollectionUtils.sortMap(paramMap);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return JSONUtils.beanToJSONStr(paramMap);
	}
}
