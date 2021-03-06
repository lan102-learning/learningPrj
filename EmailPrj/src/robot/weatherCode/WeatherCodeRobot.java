package robot.weatherCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherCodeRobot {
    final static Pattern FINDER = Pattern.compile("((CN)\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([0-9]\\S+) +([0-9]\\S+)");
    public static void main(String[] args) throws IOException {
        System.out.println("regExp："+FINDER.toString()+"\n------------------------");//显示正则表达式
        //读文件
        FileInputStream fis = new FileInputStream("note\\和风天气中国城市列表 v1.3.txt");
        Reader reader = new InputStreamReader(fis, "Gbk");
        BufferedReader bufferedReader = new BufferedReader(reader);
        for (int j = 0; j < 3; j++) {//去掉标题
            bufferedReader.readLine();//读一行
        }
        String tempStr = null;
        while ((tempStr = bufferedReader.readLine()) != null) {
            System.out.println("==============================\n"+tempStr);
            Matcher matcher = FINDER.matcher(tempStr);
            String province,area,city = null,code = null;
            File file;
            while (matcher.find()) {
                province = matcher.group(9);
                file = new File("note\\和风天气中国城市列表v1.3\\"+province);
                if (!file.exists()) {//不存在该城市文件夹，则创建
                    System.out.println("创建城市文件夹"+file.mkdirs());
                }
                area = matcher.group(11);
                file = new File("note\\和风天气中国城市列表v1.3\\"+province+"\\"+area/*+".txt"*/);
                if (!file.exists()) {//不存在该地区文件夹，则创建
                    System.out.println("创建地区txt"+file.createNewFile());
                }
                //打开地区txt文件
                FileWriter fw = new FileWriter(file,true);
                city = matcher.group(4);
                code = matcher.group(1);
                fw.write(city+"       "+code+"\r\n");
                fw.flush();
                fw.close();
 //--------------------------------------------------------------------
//                System.out.println(matcher.group(1));//编码
//                System.out.println(matcher.group(2));
//                System.out.println(matcher.group(3));
//                System.out.println(matcher.group(4));//地市
//                System.out.println(matcher.group(5));
//                System.out.println(matcher.group(6));
//                System.out.println(matcher.group(7));
//                System.out.println(matcher.group(8));
//                System.out.println(matcher.group(9));//省
//                System.out.println(matcher.group(10));
//                System.out.println(matcher.group(11));//区
//                System.out.println(matcher.group(12));
            }
//            System.out.println(bean+"\n==============================");
        }
        reader.close();
    }
    /*
    private static void getBeanFromLine(String lineStr) {
        StringBuffer sb = new StringBuffer();
        for(int i=0 ;i<=lineStr.length();i++) {
            sb.append(lineStr).charAt(index)
        }
    }*/
}
