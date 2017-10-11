package base;

import java.lang.reflect.Constructor;
import java.util.Map;

import org.apache.log4j.Logger;

import utils.MailUtil;
import utils.XmlOfServiceUtil;
/**
 * ������ 
 * ��Ŀǰ����service��
 * @author cwj
 *
 */
public class BeanFactory {
	private static Logger logger = Logger.getLogger(MailUtil.class);
	private XmlOfServiceUtil serviceUtil = null;
	
	public BeanFactory(String contextPath){
		serviceUtil = new XmlOfServiceUtil(contextPath);
	}
	
	//����id����ʵ������
	public Object getBean(String beanId){
		Map<String,String> infoMap = serviceUtil.getServiceCfgById(beanId);
		String serviceClass = infoMap.get("service-class");
		String serviceProp = infoMap.get("service-prop");
		Object obj = null;
		try {
			Class clazz = Class.forName(serviceClass);
			if(serviceProp !=null){
				//����ʹ�ù��췽����context��ֵ
				Constructor<?> c = clazz.getConstructor(String.class);
				obj = c.newInstance(serviceProp);
			}else{
				obj = clazz.newInstance();
			}
		} catch (Exception e) {
			logger.info(e.getStackTrace());
			e.printStackTrace();
		}
		return obj;
	}
	
}
