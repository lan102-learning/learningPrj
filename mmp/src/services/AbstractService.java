package services;

import utils.MailUtil;

/**
 * service 抽象父类
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
		//发邮件
		MailUtil mailUtil = new MailUtil(context);
		mailUtil.sendMailBySmtp(subject, content);
	}
	
	//抽象服务方法,由子类做具体实现
	public abstract void run();

}
