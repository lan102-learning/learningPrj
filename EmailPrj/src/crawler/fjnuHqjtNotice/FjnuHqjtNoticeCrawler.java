package crawler.fjnuHqjtNotice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import crawler.utils.Utils;

public class FjnuHqjtNoticeCrawler {
    /** Ŀ��url */
    final static String Url = "http://hqjt.fjnu.edu.cn/4234/list.htm";
    /** ����url�ͱ����������ʽ groupid 1-url 2-���� */
    final static Pattern URL_AND_TITTLE_BEGGER = Pattern.compile("<a href='(.*)' target.*>(.*)</a>");
    /** �������� �������ʽ groupid 1-���� *///
    final static Pattern DATE_PATTERN = Pattern.compile("<td.*><div.*>([0-9]{4}(-[0-9]{2}){2})</div></td>");
    /** �������� �������ʽ 4-���� */
    final static Pattern CONTANT_PATTERN = Pattern.compile("<meta name=\"description\" content=\"(.*)\".*/>");
    /** ������ �������ʽ */
    final static String TODAY_DATE_STRING = "<td.*><div.*>(" + Utils.getToday() + ")</div></td>";
    final static Pattern SEARCH_PATTERN = Pattern.compile(
            "<tr>\\s*<td.*><a href=.*>.*</a></td>\\s*<td.*><div.*>" + Utils.getToday() + "</div></td>\\s*</tr>");

    public List<FjnuHqjtNoticeBean> getNoticeList() {
        // �����ҳԴ��
        try {
            Utils.downloadHtml(Url, "test.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> noticeStringList = new ArrayList<String>();// ֪ͨ�ַ���
        // ��Դ��ȫ���ȡ��String��
        String fileString = Utils.readToString("test.html", "utf-8");
        Matcher beanStringMatcher = SEARCH_PATTERN.matcher(fileString);// �����������ʽƥ���Ӧ�Ŀ�
        while (beanStringMatcher.find()) {// ������ƥ��Ŀ���뵽 ֪ͨ����
            noticeStringList.add(beanStringMatcher.group());
        }
        List<FjnuHqjtNoticeBean> noticeBeanList = new ArrayList<>();
        // ����-����-bean����
        for (String noticeString : noticeStringList) {
            FjnuHqjtNoticeBean noticeBean = new FjnuHqjtNoticeBean();
            // ƥ��url�ͱ���
            Matcher noticeObjectmatcher = URL_AND_TITTLE_BEGGER.matcher(noticeString);
            while (noticeObjectmatcher.find()) {
                String tempUrl = Url.substring(0, Url.length() - 9);
                noticeBean.setUrl(tempUrl + noticeObjectmatcher.group(1));
                noticeBean.setTittle(noticeObjectmatcher.group(2));
            }
            // ƥ��ʱ��
            noticeObjectmatcher = DATE_PATTERN.matcher(noticeString);
            while (noticeObjectmatcher.find()) {
                noticeBean.setDate(noticeObjectmatcher.group(1));
            }
            getNoticeContant(noticeBean);
            // ����bean��List��
            noticeBeanList.add(noticeBean);
        }
        return noticeBeanList;
        /*
         * for (FjnuHqjtNoticeBean fjnuHqjtNoticeBean : noticeBeanList) {
         * System.out.println(fjnuHqjtNoticeBean);
         * System.out.println("==========================="); }
         */
    }

    private static void getNoticeContant(FjnuHqjtNoticeBean noticeBean) {
        // ����Դ��
        try {
            Utils.downloadHtml(noticeBean.getUrl(), "test2.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ��Դ��ȫ���ȡ��String��
        String fileString = Utils.readToString("test2.html", "utf-8");
        // ƥ������
        Matcher noticeObjectmatcher = CONTANT_PATTERN.matcher(fileString);
        while (noticeObjectmatcher.find()) {
            noticeBean.setContant(noticeObjectmatcher.group(1));
        }
    }

    /**
     * ���FjnuHqjtNoticeBean �Ļ�����Ϣ ���� ʱ�� Url
     * 
     * @param noticeString
     * @param noticeBean
     */
    public static void getNoticeBasicInfo(FjnuHqjtNoticeBean noticeBean, String noticeString) {
        // ƥ��url�ͱ���
        Matcher noticeObjectmatcher = URL_AND_TITTLE_BEGGER.matcher(noticeString);
        while (noticeObjectmatcher.find()) {
            String tempUrl = Url.substring(0, Url.length() - 9);
            noticeBean.setUrl(tempUrl + noticeObjectmatcher.group(1));
            noticeBean.setTittle(noticeObjectmatcher.group(2));
        }
        // ƥ��ʱ��
        noticeObjectmatcher = DATE_PATTERN.matcher(noticeString);
        while (noticeObjectmatcher.find()) {
            noticeBean.setDate(noticeObjectmatcher.group(1));
        }
    }

}