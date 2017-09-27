package crawler.fjnuHqjtNotice;

import java.util.List;
import crawler.utils.MailUtil;

public class Main {

    private static FjnuHqjtNoticeCrawler noticeCrawler = new FjnuHqjtNoticeCrawler();
   
    public static void main(String[] args) {
        List<FjnuHqjtNoticeBean> list = noticeCrawler.getNoticeList();
        for (FjnuHqjtNoticeBean fjnuHqjtNoticeBean : list) {
            String subject = fjnuHqjtNoticeBean.getTittle();// 主题;
            String contant = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + fjnuHqjtNoticeBean.getContant() + "<br><br>详情见"
                    + fjnuHqjtNoticeBean.getUrl() + "<br><br>" + fjnuHqjtNoticeBean.getDate();// 内容;
            MailUtil.sendMailBySmtp(subject, contant);
//            System.out.println("主题："+subject+"\n内容："+contant+"\n===================================\n");
        }
    }
    
    
}
