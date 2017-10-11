package test;

import base.BeanFactory;
import services.AbstractService;

public class Tester {

	public static void main(String[] args) {
		//服务调用测试
		BeanFactory beanFactory = new BeanFactory("resource/cfg/service.xml");
		AbstractService service = (AbstractService) beanFactory.getBean("fjnuHqjtNoticeService");
		service.run();
	}
	
}
