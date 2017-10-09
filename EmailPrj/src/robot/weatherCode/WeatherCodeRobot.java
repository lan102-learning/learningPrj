package robot.weatherCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherCodeRobot {
    final static Pattern FINDER = Pattern.compile("((CN)\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([a-zA-Z]\\S+) +([\\u4e00-\\u9fa5]\\S+) +([0-9]\\S+) +([0-9]\\S+)");
    public static void main(String[] args) throws IOException {
        System.out.println("regExp��"+FINDER.toString()+"\n------------------------");//��ʾ������ʽ
        //���ļ�
        FileInputStream fis = new FileInputStream("note\\�ͷ������й������б� v1.3.txt");
        Reader reader = new InputStreamReader(fis, "Gbk");
        BufferedReader bufferedReader = new BufferedReader(reader);
        for (int j = 0; j < 3; j++) {//ȥ������
            bufferedReader.readLine();//��һ��
        }
        int i = 0;//����������
        String tempStr = null;
        List<WeatherCodeBean> list = new ArrayList<>();//����bean list
        WeatherCodeBean bean  = new WeatherCodeBean();//����bean
        while ((tempStr = bufferedReader.readLine()) != null) {
            if (i == 4) return;  //�ڼ��н���
            i++;
            System.out.println("==============================\n"+tempStr);
//            tempStr = "CN101010100 beijing ����  CN  China   �й�  beijing ����  beijing ����  39.904989   116.405285";
            Matcher matcher = FINDER.matcher(tempStr);
            String province,area,city = null,code = null;
            File file;
            while (matcher.find()) {
//                System.out.println(matcher.group(11));//ʡ
                province = matcher.group(11);
                file = new File("note\\�ͷ������й������б�v1.3\\"+province);
                if (!file.exists()) {//�����ڸó����ļ��У��򴴽�
                    System.out.println("���������ļ���"+file.mkdirs());
                }
//                System.out.println(matcher.group(9));//��
                area = matcher.group(9);
                file = new File("note\\�ͷ������й������б�v1.3\\"+province+"\\"+area+".txt");
                if (!file.exists()) {//�����ڸõ����ļ��У��򴴽�
                    System.out.println("��������txt"+file.createNewFile());
                }
                //�򿪵���txt�ļ�
                FileWriter fw = new FileWriter(file,true);
                city = matcher.group(4);
                code = matcher.group(1);
                fw.write(city);
                fw.write("       ");
                fw.write(code);
//                System.out.println(matcher.group(4));//����
//                System.out.println(matcher.group(1));//����
 //--------------------------------------------------------------------
//                System.out.println(matcher.group(1));//����
//                System.out.println(matcher.group(2));
//                System.out.println(matcher.group(3));
//                System.out.println(matcher.group(4));//����
//                System.out.println(matcher.group(5));
//                System.out.println(matcher.group(6));
//                System.out.println(matcher.group(7));
//                System.out.println(matcher.group(8));
//                System.out.println(matcher.group(9));//��
//                System.out.println(matcher.group(10));
//                System.out.println(matcher.group(11));//ʡ
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
