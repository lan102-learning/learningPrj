package crawler.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件工具
 * 
 * @author liuwenkang
 *
 */
public class MailUtil {
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    // 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    // public static String myEmailAccount = "dayinz1@sina.com";//发送邮箱
    // public static String myEmailPassword = "a123456";//发送邮箱账号
    // public static String myEmailSMTPHost = "smtp.sina.com";//发件人邮箱的 SMTP 服务器地址
    // public static String receiveMailAccount = "903914294@qq.com";//收件邮箱

    private final static String myEmailSMTPHost = "smtp.sina.com";// 发件人邮箱的 SMTP 服务器地址
    private final static String port = "143";// 端口
    private final static String sendMail = "dayinz1@sina.com";// 发送邮箱账号
    private final static String sendMailPassword = "a123456";// 发送邮箱密码
    private final static String sendName = "咸鱼康";// 发送人
    private final static String receiveMail = "347579300@qq.com";// 收件邮箱;
    private final static String receiveName = "收件人";// 收件人;
    private final static String subject = "主题";// 主题;
    private final static String contant = "内容";// 内容;
    private final static String charset = "utf-8";// 编码;

    public static void main(String[] args) throws Exception {
        sendMailBySmtp(myEmailSMTPHost, port, sendMail, sendMailPassword, sendName, receiveMail, receiveName, subject,
                contant, charset);
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String sendName, String receiveMail,
            String receiveName, String subject, String contant, String charset) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, sendName, charset));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveName, charset));
        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(subject, charset);
        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(contant, "text/html;charset=" + charset);
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

    public static void sendMailBySmtp(String myEmailSMTPHost, String port, String sendMail, String sendMailPassword,
            String sendName, String receiveMail, String receiveName, String subject, String contant, String charset) {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties(); // 参数配置
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        // 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        // 打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。

        /*
         * props.setProperty("mail.smtp.port", smtpPort);
         * props.setProperty("mail.smtp.socketFactory.class",
         * "javax.net.ssl.SSLSocketFactory");
         * props.setProperty("mail.smtp.socketFactory.fallback", "false");
         */
        props.setProperty("mail.smtp.socketFactory.port", port);// smtp端口 请前往对应邮箱帮助，查找端口

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        try {
            MimeMessage message = createMimeMessage(session, sendMail, sendName, receiveMail, receiveName, subject,
                    contant, charset);

            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();

            // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            // 连接失败的原因通常为以下几点, 仔细检查代码:
            // (1) 邮箱没有开启 SMTP 服务;
            // (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
            // (3) 邮箱服务器要求必须要使用 SSL 安全连接;
            // (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
            // (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
            transport.connect(sendMail, sendMailPassword);

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
            // 密送人
            transport.sendMessage(message, message.getAllRecipients());

            // 7. 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendGroupMailBySmtp(String myEmailSMTPHost, String port, String sendMail,
            String sendMailPassword, String sendName, String receiveMail, String receiveName, String subject,
            String contant, String charset) throws Exception {
        sendMailBySmtp(myEmailSMTPHost, port, sendMail, sendMailPassword, sendName, receiveMail, receiveName, subject,
                contant, charset);
    }
}
