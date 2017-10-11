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
 * service的xml 解析工具类
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
		// 创建SAXReader的对象reader
		SAXReader reader = new SAXReader();
		try {
			// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
			Document document = reader.read(new File(contextPath));
			// 通过document对象获取根节点bookstore
			Element element = document.getRootElement();
			// 通过element对象的elementIterator方法获取迭代器
			Iterator it = element.elementIterator();
			// 遍历迭代器，获取根节点中的信息
			while (it.hasNext()) {
				Element service = (Element) it.next();
				// service id
				List<Attribute> list = service.attributes();
//				System.out.println(list.get(0).getValue());
				// 比较id值
				if (serviceId.equals(list.get(0).getValue())) {
					// service子节点
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
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        try {
        	// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File(contextPath));
            // 通过document对象获取根节点bookstore
            Element element = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = element.elementIterator();
            
            String serviceId = "";
            // 遍历迭代器，获取根节点中的信息
            while (it.hasNext()) {
            	Element service = (Element) it.next();
            	//service id
            	List<Attribute> list = service.attributes();
            	serviceId = list.get(0).getValue();
            	//service子节点
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
