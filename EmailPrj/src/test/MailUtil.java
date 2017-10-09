package test;

import java.util.Properties;

import javax.mail.Authenticator;

import javax.mail.Message;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil {
    private static final String to = "347579300@qq.com";
    private static final String smtpHost = "smtp.qq.com";
    private static final String sendMail = "dayinzq@sina.com";
    private static final String sendMailPassword = "a123456";
    private static final String subject = "����";
    private static final String contant = "����";
    private static final String smtpPort = "25";
    public static void sendMail() throws Exception {
        // 1.�������Ӷ������ӵ����������
        Properties props = new Properties();
        // ����debug����
        props.setProperty("mail.debug", "true");
        // ���ͷ�������Ҫ�����֤
        props.setProperty("mail.smtp.auth", "true");
        // �����ʼ�Э������
        props.setProperty("mail.transport.protocol", "smtp");
        Session session = null;
        props.setProperty("mail.smtp.port", smtpPort);//smtp�˿�
        // �����ʼ�������������
        // �����ʼ������������qq���䣬ֵ����"smtp.qq.com"��������������䣬ֵ����"smtp.163.com"��ͬ�����˾���"smtp.sina.com"��������qq������ʾ����
        props.setProperty("mail.smtp.host",smtpHost);
        // qq���䲻ͬ�������������䣬����ʹ����Ҫ����ssl���ܣ�����4�д���ֻ��ʹ��qq���������
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);//ssl�˿�
        
        // ͬʱ��������õ���������qq����Ҳ�����������߲�ͬ�ġ�����֪��������javaMail��������Ҫ�Է�������������ã���Ҫ����������������stmp/pop3��ʹ�á�
        // ��qq���������㿪��stmp/pop3ʹ�õ�ʱ��������һ����Ȩ�룬�ǲ������������俪����ʹ�õ��������롣�����ò�˵�����ܹ�������һ����
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendMail, sendMailPassword);
            }
        });
        // 2.�����ʼ�����
        Message message = new MimeMessage(session);
        // 2.1���÷����ˣ�
        message.setFrom(new InternetAddress(sendMail));
        // 2.2�����ռ��ˣ�
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        // 2.3�����ʼ�������
        message.setSubject(subject);
        // 2.4�����ʼ�������
        message.setContent(contant, "text/html;charset=UTF-8");
        // 3.����һ�⼤���ʼ�
        Transport.send(message);
    }

}
