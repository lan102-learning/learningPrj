package test.gsontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import crawler.utils.Utils;
import test.gsontest.model.HeWeather5;
import test.gsontest.model.JsonRootBean;

public class GsonTester {
    static String jsonString = Utils.readToString("weather.json", "utf-8");

    public static void main(String[] args) {
        System.out.println(jsonString + "\n==========================");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        Gson gson = new Gson();
        JsonRootBean JsonRootBean = gson.fromJson(jsonString, JsonRootBean.class);
        System.out.println(JsonRootBean);
    }

    public static void main1(String[] args) throws IOException {
        String urlPath = "https://free-api.heweather.com/v5/weather?city=cn101230101&key=086ccf68c62a4df8951fa93382306b72";
        URL url = new URL(urlPath);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        // 对应的字符编码转换
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            sb.append(str);
        }
        reader.close();
        connection.disconnect();
        System.out.println(sb);
    }
}
