	package crawler.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���߼���
 * 
 * @author liuwenkang
 *
 */
public class Utils {
    /**
     * ��ȡĿ����ַ��Դ��
     * 
     * @param url Ŀ����ַ
     * @param fileUrl �����ļ���·��
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
     * �������ļ�����String
     * 
     * @param fileName Դ�ļ�·��
     * @param encoding ����
     * @return �ļ�����
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
     * @return ��yyyy-mm-dd��ʽ���ʱ��
     */
    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        return sdf.format(new Date());
          return "2017-09-21";
    }

    /**
     * ɾ��Ŀ¼�������ļ�������Ŀ¼����
     * @param dir 
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //�ݹ�ɾ��Ŀ¼���ļ�
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // Ŀ¼��ʱΪ�գ�����ɾ��
        return dir.delete();
    }
}
