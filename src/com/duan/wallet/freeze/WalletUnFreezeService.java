package com.duan.wallet.freeze;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.duan.wallet.bean.WalletFreezeRes;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.nxin.sysmodule.util.DateUtils;
import com.nxin.sysmodule.util.JSONUtils;

public class WalletUnFreezeService {
	private static String walletunfreezeUrl = "http://jrapi.nxin.com/api/web/wallet/walletUnfreeze.shtml";	
	private static String walletunfreezeUrlDev = "https://jrapi.p.nxin.com/api/web/wallet/walletUnfreeze.shtml";
	private static String walletunfreezeUrlTest = "http://jrapi.t.nxin.com/api/web/wallet/walletUnfreeze.shtml";
	public static void main(String[] args) {
		String jsonStr = sendMsg();
		try {
			String res = HttpclientUtil.postJson(walletunfreezeUrl, jsonStr, "utf8");
			System.out.println("返回结果___"+res);
			WalletFreezeRes resBean = JSONUtils.jsonStrToBean(res, WalletFreezeRes.class);
			Map<String,String> map = new HashMap<String,String>();
			map.putAll(resBean.getData());
			map.put("retCode", resBean.getRetCode());
			map.put("retMsg", resBean.getRetMsg());
			map.put("times", resBean.getTimes());
			String str = CollectionUtils.sortMap(map);
			System.out.println("参与加密的字符串___"+str);
			String verifySignmsg = MD5.encryption(str);
			if(!verifySignmsg.equals(resBean.getSignmsg())){
				throw new Exception("签名信息不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String sendMsg(){
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userId", "1252620"); // 个人:1175258  企业: 企业ID:1251912  个人ID：1251911
		paramMap.put("orgId", "1252646");//
		paramMap.put("amount", "10");
		paramMap.put("freezeType", "UNFREEZE_PIG_TRADE");
		paramMap.put("busType", "zjs");
		paramMap.put("busNo", "111");
		paramMap.put("description", "测试");
		paramMap.put("remarks", "测试");
		paramMap.put("orderno", "20160726090517");//DateUtils.formatDate(new Date(), "yyyyMMddhhmmss")
		paramMap.put("serialSumber", DateUtils.formatDate(new Date(), "yyyyMMddhhmmss"));
		String str = CollectionUtils.sortMap(paramMap);
		String signmsg = MD5.encryption(str);
		paramMap.put("signmsg", signmsg);
		return JSONUtils.beanToJSONStr(paramMap);		
	}
}