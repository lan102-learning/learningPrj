package base;

import utils.XmlOfServiceUtil;

public class BeanFactory {
	
	private String contextPath = null;
	private XmlOfServiceUtil serviceUtil = null;
	
	public BeanFactory(String contextPath){
		this.contextPath = contextPath;
		serviceUtil = new XmlOfServiceUtil(contextPath);
	}
	
	
	public Object getBean(String beanId){
		serviceUtil.getServiceCfgById(beanId);
		return null;
	}


	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	

}
