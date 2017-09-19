package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTester {
    final static Pattern BR_PATTERN_BEGGER = Pattern.compile("<tr>");
    final static Pattern TD_TITTLE_PATTERN = Pattern.compile("<td.*><a href=.*>.*</a></td>");
    final static Pattern TD_DATE_PATTERN = Pattern.compile("<td.*><div.*>[0-9]{4}(-[0-9]{2}){2}</div></td>");
    final static Pattern BR_PATTERN_END = Pattern.compile("</tr>");
    final static Pattern SEARCH_PATTERN = Pattern
            .compile("<tr>\\s*<td.*><a href=.*>.*</a></td>\\s*<td.*><div.*>[0-9]{4}(-[0-9]{2}){2}</div></td>\\s*</tr>");

    public static void main(String[] args) {
        String fileString = readToString("test.html");
        Matcher m = SEARCH_PATTERN.matcher(fileString);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println("=======================================");
        }

    }

    public static void testFunction() throws IOException {
        FileInputStream fis = new FileInputStream("test.html");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String tempStr = null;
        StringBuffer noticeObj = null;
        while ((tempStr = bufferedReader.readLine()) != null) {
            System.out.println(tempStr);
        }
        fis.close();
    }

    public static String readToString(String fileName) {
        String encoding = "utf-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static void testReg() {
        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容 // 相当于埋好了陷阱匹配的地方就会掉下去
        // Pattern pattern = Pattern.compile("href=\"(.+?)\""); // 定义一个matcher用来做匹配
        String testString = "<td align=\"left\" width=\"30px\"><div style=\"white-space:nowrap\">2017-09-07</div></td> ";
        Matcher matcher = TD_DATE_PATTERN.matcher(testString); // 如果找到了
        System.out.println(testString);
        System.out.println(matcher.find());
        System.out.println(matcher.group(0));
    }

    public static void findAllByReg() {
        Matcher m = BR_PATTERN_BEGGER.matcher("dfad<tr>sdfas35<tr>");
        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
