package com.duan.cardinfo.service;

import java.util.HashMap;
import java.util.Map;

import com.duan.http.util.HttpclientUtil;
import com.nxin.sysmodule.security.MD5;
import com.nxin.sysmodule.util.CollectionUtils;
import com.thoughtworks.xstream.XStream;

public class CardInfoService {
	private static final String testUrl = "http://jrapi.t.nxin.com/api/web/cardManagement/syncCardInfo.shtml";
	private static final String devUrl = "http://jrapi.nxin.com/api/web/cardManagement/syncCardInfo.shtml";
	private static final String prodUrl = "http://jrapi.nxin.com/api/web/cardManagement/syncCardInfo.shtml";
	
	public static void main(String[] args) {
		try {
			String xml = generateXml();
			String res = HttpclientUtil.postXml(testUrl, xml, "utf8");
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String generateXml() {
		XStream xstream = new XStream();
		String userId = "1253732";
		String bankName = "农业银行";
		String mobile = "";
		String identityCode = "542500197104124806";
		String cardNo = "9559980471095861111";
		String cardHolder = "姜茔";
		String cardSignChannel = "1";
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("bankName", bankName);
		map.put("mobile", mobile);
		map.put("identityCode", identityCode);
		map.put("cardNo", cardNo);
		map.put("cardHolder", cardHolder);
		map.put("cardSignChannel", cardSignChannel);
		String str = CollectionUtils.sortMap(map);
		System.out.println("生成字符串:" + str);
		String signmsg = MD5.encryption(str);
		UserCardInfo cardInfo = new UserCardInfo(userId, bankName, mobile, identityCode, cardNo, cardHolder, signmsg,cardSignChannel);
		xstream.processAnnotations(UserCardInfo.class);
		String xml = xstream.toXML(cardInfo);
		System.out.println("生成文件:" + xml);
		return xml;
	}
}