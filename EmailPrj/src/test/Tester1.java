package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester1 {
    public static void main(String[] args) {
        String source="<div class=\"hdwiki_tmml\"><a class=\" &nbsp;FCK__AnchorC\" name=\"1\">是大家是否</a></div><div class=\"hdwiki_tmml\"><a name=\"2\">士大夫士大夫</a></div> ";
        StringBuilder result=new StringBuilder();
        System.out.println("=======开始匹配文字内容========");
        String patternStrs="(<div class=\"hdwiki_tmml\"><a.+?>)(.+?)(</a></div>)";
        Pattern pattern=Pattern.compile(patternStrs);
        Matcher matcher=pattern.matcher(source);
        while(matcher.find()){
            result.append(matcher.group(2)+"\n");
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
