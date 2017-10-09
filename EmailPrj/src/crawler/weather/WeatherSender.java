package crawler.weather;

import java.io.IOException;

import org.apache.log4j.Logger;

import crawler.utils.Utils;

public class WeatherSender {
    private static Logger logger = Logger.getLogger(WeatherSender.class);

    public static void main(String[] args) {

        // »ñµÃJson ×Ö·û´®
        String weatherStr = null;
        try {
            weatherStr = Utils.getJsonStringFromWs(
                    "https://free-api.heweather.com/v5/weather?city=cn101230101&key=086ccf68c62a4df8951fa93382306b72",
                    "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
   
        
    }
}
