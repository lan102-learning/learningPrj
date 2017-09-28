package robot.weatherCode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherCodeRobot {
    final static Pattern FINDER = Pattern.compile("^((cn)\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([0-9]\\S+) +([0-9]\\S+)$");
    public static void main(String[] args) throws IOException {
        System.out.println("regExp："+FINDER.toString()+"\n------------------------");
        System.out.println("\n---------------------------------------");
        FileInputStream fis = new FileInputStream("note\\和风天气中国城市列表 v1.3.txt");
        Reader reader = new InputStreamReader(fis, "Gbk");
        BufferedReader bufferedReader = new BufferedReader(reader);
        for (int j = 0; j < 3; j++) {//去掉标题
            bufferedReader.readLine();
        }
        int i = 0;
        String tempStr = null;
        List<WeatherCodeBean> list = new ArrayList<>();
        WeatherCodeBean bean  = new WeatherCodeBean();
        while ((tempStr = bufferedReader.readLine()) != null) {
            if (i == 1) return;
            i++;
            System.out.println("==============================\n"+tempStr);
            tempStr = "CN101010100 beijing 北京  CN  China   中国  beijing 北京  beijing 北京  39.904989   116.405285";
            Matcher matcher = FINDER.matcher(tempStr);
            while (matcher.find()) {
                /*bean.setCity(matcher.group(1));
                bean.setCityEnName(matcher.group(2));
                bean.setCityCnName(matcher.group(3));
                bean.setCountryCode(matcher.group(4));
                bean.setCountryEnName(matcher.group(5));
                bean.setCountryCnName(matcher.group(6));
                bean.setProvinceEnName(matcher.group(7));
                bean.setProvinceCnName(matcher.group(8));
                bean.setAreaEnName(matcher.group(9));
                bean.setAreaCnName(matcher.group(10));
                bean.setWeidu(matcher.group(11));
                bean.setJingdu(matcher.group(12));*/
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(5));
                System.out.println(matcher.group(6));
                System.out.println(matcher.group(7));
                System.out.println(matcher.group(8));
                System.out.println(matcher.group(9));
                System.out.println(matcher.group(10));
                System.out.println(matcher.group(11));
                System.out.println(matcher.group(12));
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
