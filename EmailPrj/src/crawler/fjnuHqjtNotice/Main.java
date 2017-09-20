package crawler.fjnuHqjtNotice;

import java.util.List;
import crawler.utils.MailUtil;

public class Main {

    private static FjnuHqjtNoticeCrawler noticeCrawler = new FjnuHqjtNoticeCrawler();
   
    public static void main(String[] args) {
        List<FjnuHqjtNoticeBean> list = noticeCrawler.getNoticeList();
        for (FjnuHqjtNoticeBean fjnuHqjtNoticeBean : list) {
            String subject = fjnuHqjtNoticeBean.getTittle();// ����;
            String contant = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" + fjnuHqjtNoticeBean.getContant() + "<br><br>�����"
                    + fjnuHqjtNoticeBean.getUrl() + "<br><br>" + fjnuHqjtNoticeBean.getDate();// ����;
            MailUtil.sendMailBySmtp(subject, contant);
            
        }
    }
    
    
}
