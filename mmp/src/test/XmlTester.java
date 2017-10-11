package test;

import java.util.Map;

import utils.XmlOfServiceUtil;


public class XmlTester {

	public static void main(String[] args) {
		XmlOfServiceUtil util = new XmlOfServiceUtil("resource/cfg/service.xml");
		Map<String,String> map = util.getServiceCfgById("fjnuHqjtNoticeService");
		System.out.println(map.get("service-class"));
		System.out.println(map.get("service-prop"));
		System.out.println("================");
		Map<String, Map<String,String>> map2 = util.getAllServiceCfg();
		Map map3 = map2.get("weatherNoticeService");
		System.out.println(map3.get("service-class"));
		System.out.println(map3.get("service-prop")); 
	}

}
