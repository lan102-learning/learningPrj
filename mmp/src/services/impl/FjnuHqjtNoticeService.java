package services.impl;

import services.AbstractService;
/**
 * fjnu 后勤消息通知服务
 * @author cwj
 *
 */
public class FjnuHqjtNoticeService extends AbstractService {

	public FjnuHqjtNoticeService(){}
	
	public FjnuHqjtNoticeService(String context){
		super(context);
	}
	
	@Override
	public void run() {
		//1.后勤  服务实现
		
		String subject = "service 通知";
		String content = "niubi niubi";
		//2.推送邮件
//		sendMessage(subject, content);
	}

}
