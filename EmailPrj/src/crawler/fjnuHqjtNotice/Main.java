package crawler.fjnuHqjtNotice;

import java.util.List;

import crawler.utils.MailUtil;

public class Main {
    private final static String myEmailSMTPHost = "smtp.sina.com";// 发件人邮箱的 SMTP 服务器地址
    private final static String port = "143";// 端口
    private final static String sendMail = "dayinz1@sina.com";// 发送邮箱账号
    private final static String sendMailPassword = "a123456";// 发送邮箱密码
    private final static String sendName = "后勤公告推送";// 发送人
    private final static String receiveMail = "347579300@qq.com";// 收件邮箱;//903914294
    private final static String receiveName = "收件人";// 收件人;

    private final static String charset = "utf-8";// 编码;
    private static FjnuHqjtNoticeCrawler noticeCrawler = new FjnuHqjtNoticeCrawler();

    public static void main(String[] args) {
        List<FjnuHqjtNoticeBean> list = noticeCrawler.getNoticeList();
        for (FjnuHqjtNoticeBean fjnuHqjtNoticeBean : list) {
            String subject = fjnuHqjtNoticeBean.getTittle();// 主题;
            String contant = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + fjnuHqjtNoticeBean.getContant() + "<br><br>详情见"
                    + fjnuHqjtNoticeBean.getUrl() + "<br><br>" + fjnuHqjtNoticeBean.getDate();// 内容;
            MailUtil.sendMailBySmtp(myEmailSMTPHost, port, sendMail, sendMailPassword, sendName, receiveMail,
                    receiveName, subject, contant, charset);

        }
    }
}
