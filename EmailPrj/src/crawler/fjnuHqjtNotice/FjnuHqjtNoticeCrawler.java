package crawler.fjnuHqjtNotice;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import crawler.utils.Utils;

public class FjnuHqjtNoticeCrawler {
    private static Logger logger = Logger.getLogger(FjnuHqjtNoticeCrawler.class);

    /** 目标url */
    final static String Url = "http://hqjt.fjnu.edu.cn/4234/list.htm";
    /** 搜索url和标题正则表达式 groupid 1-url 2-标题 */
    final static Pattern URL_AND_TITTLE_BEGGER = Pattern.compile("<a href='(.*)' target.*>(.*)</a>");
    /** 搜索日期 正则表达式 groupid 1-日期 *///
    final static Pattern DATE_PATTERN = Pattern.compile("<td.*><div.*>([0-9]{4}(-[0-9]{2}){2})</div></td>");
    /** 搜索内容 正则表达式 4-内容 */
    final static Pattern CONTANT_PATTERN = Pattern.compile("<meta name=\"description\" content=\"(.*)\".*/>");
    /** 搜索类 正则表达式 */
    final static String TODAY_DATE_STRING = "<td.*><div.*>(" + Utils.getToday() + ")</div></td>";
    final static Pattern SEARCH_PATTERN = Pattern.compile(
            "<tr>\\s*<td.*><a href=.*>.*</a></td>\\s*<td.*><div.*>" + Utils.getToday() + "</div></td>\\s*</tr>");

    public List<FjnuHqjtNoticeBean> getNoticeList() {
        // 创建临时文件目录
        File file = new File("temp");
//        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            logger.info("创建临时文件夹"+file.mkdirs());
        }
        // 获得网页源码
        try {
            Utils.downloadHtml(Url, "temp/test.html");
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
        }
//        List<String> noticeStringList = new ArrayList<String>();// 通知字符集
        // 将源码全面读取到String中
        String fileString = Utils.readToString("temp/test.html", "utf-8");
        List<FjnuHqjtNoticeBean> noticeBeanList = new ArrayList<>(); //notice 结果集
        String tempNoticeString = null; //notice 临时字符串
        Matcher beanStringMatcher = SEARCH_PATTERN.matcher(fileString);// 根据正则表达式匹配对应的块
        while (beanStringMatcher.find()) {// 将所有匹配的块加入到 通知集中
            tempNoticeString = beanStringMatcher.group();
            FjnuHqjtNoticeBean noticeBean = new FjnuHqjtNoticeBean();
            // 匹配url和标题
            Matcher noticeObjectmatcher = URL_AND_TITTLE_BEGGER.matcher(tempNoticeString);
            while (noticeObjectmatcher.find()) {
                String tempUrl = Url.substring(0, Url.length() - 9);
                noticeBean.setUrl(tempUrl + noticeObjectmatcher.group(1));
                noticeBean.setTittle(noticeObjectmatcher.group(2));
            }
            // 匹配时间
            noticeObjectmatcher = DATE_PATTERN.matcher(tempNoticeString);
            while (noticeObjectmatcher.find()) {
                noticeBean.setDate(noticeObjectmatcher.group(1));
            }
            getNoticeContant(noticeBean);
            // 添加bean到List中
            noticeBeanList.add(noticeBean);
        }
        //删除临时文件
        Utils.deleteDir(file);
        return noticeBeanList;
    }

    /**
     * 获取bean的内容
     * @param noticeBean （需含url）
     */
    private static void getNoticeContant(FjnuHqjtNoticeBean noticeBean) {
        // 下载源码
        try {
            Utils.downloadHtml(noticeBean.getUrl(), "temp/test2.html");
        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        // 将源码全面读取到String中
        String fileString = Utils.readToString("temp/test2.html", "utf-8");
        // 匹配内容
        Matcher noticeObjectmatcher = CONTANT_PATTERN.matcher(fileString);
        while (noticeObjectmatcher.find()) {
            noticeBean.setContant(noticeObjectmatcher.group(1));
        }
    }

    /**
     * 获得FjnuHqjtNoticeBean 的基本信息 标题 时间 Url
     * 
     * @param noticeString
     * @param noticeBean
     */
    public static void getNoticeBasicInfo(FjnuHqjtNoticeBean noticeBean, String noticeString) {
        // 匹配url和标题
        Matcher noticeObjectmatcher = URL_AND_TITTLE_BEGGER.matcher(noticeString);
        while (noticeObjectmatcher.find()) {
            String tempUrl = Url.substring(0, Url.length() - 9);
            noticeBean.setUrl(tempUrl + noticeObjectmatcher.group(1));
            noticeBean.setTittle(noticeObjectmatcher.group(2));
        }
        // 匹配时间
        noticeObjectmatcher = DATE_PATTERN.matcher(noticeString);
        while (noticeObjectmatcher.find()) {
            noticeBean.setDate(noticeObjectmatcher.group(1));
        }
    }

}
