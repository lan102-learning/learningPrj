package crawler.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �ʼ�����
 * 
 * @author liuwenkang
 *
 */
public class MailUtil {
    // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,
    // ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
    // public static String myEmailAccount = "dayinz1@sina.com";//��������
    // public static String myEmailPassword = "a123456";//���������˺�
    // public static String myEmailSMTPHost = "smtp.sina.com";//����������� SMTP ��������ַ
    // public static String receiveMailAccount = "903914294@qq.com";//�ռ�����

    private static String myEmailSMTPHost;// ����������� SMTP ��������ַ
    private static String port;// �˿�
    private static String sendMail;// ���������˺�
    private static String sendMailPassword;// ������������
    private static String sendName;// ������
    private static String receiveMail;// �ռ�����;
    private static String receiveName;// �ռ���;
    private static String charset = "utf-8";// ����;

    
    //��ʼ��������Ϣ
    static{
    	Properties properties = new Properties();
    	//���������ļ�
    	InputStream is = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
    	
    	try {
			properties.load(new InputStreamReader(is,"UTF-8"));		
			
			
			myEmailSMTPHost = properties.getProperty("myEmailSMTPHost");
			port = properties.getProperty("port");
			sendMail = properties.getProperty("sendMail");
			sendMailPassword = properties.getProperty("sendMailPassword");
			sendName = properties.getProperty("sendName");
			receiveMail = properties.getProperty("receiveMail");
			receiveName = properties.getProperty("receiveName");
			charset = properties.getProperty("charset");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    public static void main(String[] args) throws Exception {
    	
    }

    /**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session �ͷ����������ĻỰ
     * @param sendMail ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String sendName, String receiveMail,
            String receiveName, String subject, String contant, String charset) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);
        // 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
        message.setFrom(new InternetAddress(sendMail, sendName, charset));
        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        //3.1 �ָ�receiveMail ��  receiveName
        String [] reMails = receiveMail.split(",");  
        String[] reNames = receiveName.split(",");
        //3.2 ����addresses ����
        InternetAddress[] addresses = new InternetAddress[reMails.length];
        for(int i = 0;i<reMails.length;i++){
        	addresses[i] = new InternetAddress(reMails[i],reNames[i],charset);
        }    
//      message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveName, charset)); 
        message.setRecipients(MimeMessage.RecipientType.TO, addresses);
        // 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
        message.setSubject(subject, charset);
        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
        message.setContent(contant, "text/html;charset=" + charset);
        // 6. ���÷���ʱ��
        message.setSentDate(new Date());
        // 7. ��������
        message.saveChanges();
        return message;
    }

    public static void sendMailBySmtp(String subject,String contant) {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties(); // ��������
        props.setProperty("mail.transport.protocol", "smtp"); // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost); // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true"); // ��Ҫ������֤

        // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
        // ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
        // ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�

        /*
         * props.setProperty("mail.smtp.port", smtpPort);
         * props.setProperty("mail.smtp.socketFactory.class",
         * "javax.net.ssl.SSLSocketFactory");
         * props.setProperty("mail.smtp.socketFactory.fallback", "false");
         */
        props.setProperty("mail.smtp.socketFactory.port", port);// smtp�˿� ��ǰ����Ӧ������������Ҷ˿�

        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true); // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

        // 3. ����һ���ʼ�
        try {
            MimeMessage message = createMimeMessage(session, sendMail, sendName, receiveMail, receiveName, subject,
                    contant, charset);

            // 4. ���� Session ��ȡ�ʼ��������
            Transport transport = session.getTransport();

            // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
            // ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
            // (1) ����û�п��� SMTP ����;
            // (2) �����������, ����ĳЩ���俪���˶�������;
            // (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
            // (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
            // (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
            transport.connect(sendMail, sendMailPassword);

            // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������,
            // ������
            transport.sendMessage(message, message.getAllRecipients());

            // 7. �ر�����
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
