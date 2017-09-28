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
    private static final String subject = "主题";
    private static final String contant = "内容";
    private static final String smtpPort = "25";
    public static void sendMail() throws Exception {
        // 1.创建连接对象，连接到邮箱服务器
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        Session session = null;
        props.setProperty("mail.smtp.port", smtpPort);//smtp端口
        // 设置邮件服务器主机名
        // 发送邮件的邮箱如果是qq邮箱，值就是"smtp.qq.com"，如果是网易邮箱，值就是"smtp.163.com"，同理，新浪就是"smtp.sina.com"，这里用qq邮箱做示例。
        props.setProperty("mail.smtp.host",smtpHost);
        // qq邮箱不同于其它两种邮箱，它的使用需要进行ssl加密，以下4行代码只有使用qq邮箱才用上
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);//ssl端口
        
        // 同时，这儿设置的邮箱密码qq邮箱也是与其它两者不同的。我们知道，进行javaMail开发首先要对发件邮箱进行设置，需要在邮箱设置中允许stmp/pop3的使用。
        // 而qq邮箱则在你开启stmp/pop3使用的时候会给予你一个授权码，那才是真正在邮箱开发中使用的邮箱密码。（不得不说老马保密工作还是一流）
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendMail, sendMailPassword);
            }
        });
        // 2.创建邮件对象
        Message message = new MimeMessage(session);
        // 2.1设置发件人：
        message.setFrom(new InternetAddress(sendMail));
        // 2.2设置收件人：
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        // 2.3设置邮件的主题
        message.setSubject(subject);
        // 2.4设置邮件的正文
        message.setContent(contant, "text/html;charset=UTF-8");
        // 3.发送一封激活邮件
        Transport.send(message);
    }

}
