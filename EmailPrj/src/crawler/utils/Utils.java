	package crawler.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具集合
 * 
 * @author liuwenkang
 *
 */
public class Utils {
    /**
     * 获取目标网址的源码
     * 
     * @param url 目标网址
     * @param fileUrl 生成文件的路径
     * @throws IOException
     * @throws MalformedURLException
     */
    public static void downloadHtml(String url, String fileUrl) throws MalformedURLException, IOException {
        URLConnection conn = new URL(url).openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
        InputStream is = conn.getInputStream();
        FileOutputStream out = new FileOutputStream(fileUrl);
        int a = 0;
        while ((a = is.read()) != -1) {
            out.write(a);
        }
        is.close();
        out.close();

    }
    
    /**
     * 从url获取json数据（String格式）
     * @param urlPath
     * @param charSet
     * @return 
     * @throws IOException
     */
   public static String getJsonStringFromWs(String urlPath,String charSet) throws IOException {
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();//打开链接
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        // 对应的字符编码转换
        Reader reader = new InputStreamReader(inputStream, charSet);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String tempStr = null;
        StringBuffer sb = new StringBuffer();
        while ((tempStr = bufferedReader.readLine()) != null) {
            sb.append(tempStr);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }
    
    /**
     * 将整个文件读到String
     * 
     * @param fileName 源文件路径
     * @param encoding 编码
     * @return 文件内容
     */
    public static String readToString(String fileName, String encoding) {
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

    /***
     * 
     * @return 以yyyy-mm-dd形式获得时间
     */
    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
//          return "2017-09-21";
    }

    /**
     * 删除目录下所有文件（包括目录本身）
     * @param dir 
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录下文件
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}
