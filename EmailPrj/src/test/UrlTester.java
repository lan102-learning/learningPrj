package test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTester {

    public static void main(String[] args) {
        try {
            URLConnection conn = new URL("http://hqjt.fjnu.edu.cn/4234/list.htm")
                    .openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
            InputStream is = conn.getInputStream();
            FileOutputStream out = new FileOutputStream("test.html");
            int a = 0;
            while ((a = is.read()) != -1) {
                out.write(a);
            }
            is.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
