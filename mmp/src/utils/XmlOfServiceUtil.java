package utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * service��xml ����������
 * @author cwj
 *
 */
public class XmlOfServiceUtil {
	private String contextPath = null;
	
	public XmlOfServiceUtil(String contextPath){
		this.contextPath = contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public  Map<String, String> getServiceCfgById(String serviceId) {
		Map<String, String> resultMap = new HashMap<String, String>();
		// ����SAXReader�Ķ���reader
		SAXReader reader = new SAXReader();
		try {
			// ͨ��reader�����read��������books.xml�ļ�,��ȡdocuemnt����
			Document document = reader.read(new File(contextPath));
			// ͨ��document�����ȡ���ڵ�bookstore
			Element element = document.getRootElement();
			// ͨ��element�����elementIterator������ȡ������
			Iterator it = element.elementIterator();
			// ��������������ȡ���ڵ��е���Ϣ
			while (it.hasNext()) {
				Element service = (Element) it.next();
				// service id
				List<Attribute> list = service.attributes();
//				System.out.println(list.get(0).getValue());
				// �Ƚ�idֵ
				if (serviceId.equals(list.get(0).getValue())) {
					// service�ӽڵ�
					Iterator iterator = service.elementIterator();
					while (iterator.hasNext()) {
						Element property = (Element) iterator.next();
						List<Attribute> attList = property.attributes();
						String key = "";
						for (Attribute att : attList) {
							if (att.getName().equals("name")) {
								key = att.getValue();
							}
							if (att.getName().equals("value")) {
								resultMap.put(key, att.getValue());
							}
						}

					}
				}
				return resultMap;
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Map<String, Map<String,String>> getAllServiceCfg() {
		Map<String, Map<String,String>> resultMap = new HashMap<String, Map<String,String>>();
        // ����SAXReader�Ķ���reader
        SAXReader reader = new SAXReader();
        try {
        	// ͨ��reader�����read��������books.xml�ļ�,��ȡdocuemnt����
            Document document = reader.read(new File(contextPath));
            // ͨ��document�����ȡ���ڵ�bookstore
            Element element = document.getRootElement();
            // ͨ��element�����elementIterator������ȡ������
            Iterator it = element.elementIterator();
            
            String serviceId = "";
            // ��������������ȡ���ڵ��е���Ϣ
            while (it.hasNext()) {
            	Element service = (Element) it.next();
            	//service id
            	List<Attribute> list = service.attributes();
            	serviceId = list.get(0).getValue();
            	//service�ӽڵ�
            	Iterator iterator = service.elementIterator();
            	
            	Map<String, String> proMap = new HashMap<String, String>();
            	while(iterator.hasNext()){
            		Element property = (Element) iterator.next();
            		List<Attribute> attList = property.attributes();
					String key = "";
					for (Attribute att : attList) {
						if (att.getName().equals("name")) {
							key = att.getValue();
						}
						if (att.getName().equals("value")) {
							proMap.put(key, att.getValue());
						}         		
					}
            	}
            	resultMap.put(serviceId, proMap);
            }
			return resultMap;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
        return null;
	}
}
