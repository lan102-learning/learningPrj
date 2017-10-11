package services;

import utils.MailUtil;

/**
 * service ������
 * @author cwj
 *
 */
public abstract class AbstractService {
	
	private String context = null;	
	public void setContext(String context) {
		this.context = context;
	}

	public AbstractService(String context){
		this.context = context;
	}
	
	public AbstractService(){}
	
	protected void sendMessage(String subject,String content){	
		//���ʼ�
		MailUtil mailUtil = new MailUtil(context);
		mailUtil.sendMailBySmtp(subject, content);
	}
	
	//������񷽷�,������������ʵ��
	public abstract void run();

}
