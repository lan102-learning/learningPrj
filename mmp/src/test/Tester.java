package test;

import base.BeanFactory;
import services.AbstractService;

public class Tester {

	public static void main(String[] args) {
		//������ò���
		BeanFactory beanFactory = new BeanFactory("resource/cfg/service.xml");
		AbstractService service = (AbstractService) beanFactory.getBean("fjnuHqjtNoticeService");
		service.run();
	}
	
}
