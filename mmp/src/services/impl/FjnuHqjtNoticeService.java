package services.impl;

import services.AbstractService;
/**
 * fjnu ������Ϣ֪ͨ����
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
		//1.����  ����ʵ��
		
		String subject = "";
		String content = "";
		//2.�����ʼ�
		sendMessage(subject, content);	
	}

}
