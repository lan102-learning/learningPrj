package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {

    public static void main(String[] args) {
        //测试字符串
        String source="<div class='wp_articlecontent'><div class='Article_Content'><DIV><SPAN style=\"FONT-SIZE: 18px\">因能源管理平台设备调试需要，应物理与能源学院要求。物理与能源学院将对能源管理平台设备进行调试，须停电施工。具体停电时间：2017年7月28日（周五）—7月31日（周一）每日19:00～24:00。将影响以下区域正常供电：理工楼群、动物实验室、发酵中心、软件学院、旅游学院、传播学院、许书典楼、音乐学院、美术学院、人文楼群。给您带来不便敬请谅解。联系人：罗老师。电话：22868189。 </SPAN></DIV><P style=\"TEXT-ALIGN: right; FONT-SIZE: 18px\">后勤服务集团</P><P style=\"TEXT-ALIGN: right\"><SPAN style=\"FONT-SIZE: 18px\">2017年7月28日</SPAN></P></div></div> ";
        StringBuilder result=new StringBuilder();
        System.out.println("=======开始匹配文字内容========");
        //匹配的正则表达式
        String patternStrs="<meta name=\"description\" content=\"(.*)\".*/>";
//        String patternStrs=".*";
        System.out.println("--------匹配正则表达式-------"+patternStrs);
        Pattern pattern=Pattern.compile(patternStrs);
        Matcher matcher=pattern.matcher(source);
        while(matcher.find()){
//            result.append(matcher.group()+"\n");
//            result.append("======================\n");
            result.append(matcher.group(4)+"\n");
            result.append("======================\n");
//            result.append(matcher.group(1)+"\n");
//            result.append("======================\n");
//            result.append(matcher.group(2)+"\n");
            result.append("======================\n");
//            result.append(matcher.group(3)+"\n");
        }
        System.out.println(result.toString());
        
        System.out.println("=======开始匹配name属性值========");
        String patternName="(<div class=\"hdwiki_tmml\"><a.+?)name=\"(.+?)\">(.+?</a></div>)";
        pattern=Pattern.compile(patternName);
        matcher=pattern.matcher(source);
        result=result.delete(0, result.length());
        while(matcher.find()){
            result.append(matcher.group(2)+"\n");
        }
        System.out.println(result.toString());
    }

}
