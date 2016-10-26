package com.duan.wallet.freeze;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.duan.wallet.bean.WalletFreezeRes;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.JSONUtils;

public class WalletFreezeQuery {
	private static String walletfreezeQueryUrlTest = "http://jrapi.t.nxin.com/api/web/wallet/getWalletFreezeResult.shtml";
	private static String walletfreezeQueryUrl = "http://jrapi.nxin.com/api/web/wallet/getWalletFreezeResult.shtml";
	private static String walletUnfreezeQueryUrl = "http://jrapi.nxin.com/api/web/wallet/getWalletUnFreezeResult.shtml";
	private static String walletUnfreezeQueryUrlDev = "https://jrapi.p.nxin.com/api/web/wallet/getWalletUnFreezeResult.shtml";
	private static String walletUnfreezeQueryUrlTest = "https://jrapi.t.nxin.com/api/web/wallet/getWalletUnFreezeResult.shtml";
	public static void main(String[] args) {
		String jsonStr = sendMsg();
		try {
			String res = HttpclientUtil.postJson(walletfreezeQueryUrlTest, jsonStr, "utf8");
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
		paramMap.put("orderno", "2222");
		paramMap.put("serialSumber", "20160718082739");
		paramMap.put("nxorderno", "201607181000807");
		paramMap.put("freezeType", "FREEZE_PIG_TRADE");
		paramMap.put("userType", "2");
		String str = CollectionUtils.sortMap(paramMap);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return JSONUtils.beanToJSONStr(paramMap);
	}
}
