package test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTester {

    public static void main(String[] args) {
        try {
            //http://hqjt.fjnu.edu.cn/4234/list.htm
            URLConnection conn = new URL("https://free-api.heweather.com/v5/weather?city=cn101230101&key=086ccf68c62a4df8951fa93382306b72")
                    .openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
            InputStream is = conn.getInputStream();
            FileOutputStream out = new FileOutputStream("weather.json");
            int a = 0;
            while ((a = is.read()) != -1) {
                out.write(a);
                System.out.print(a);
            }
            is.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
