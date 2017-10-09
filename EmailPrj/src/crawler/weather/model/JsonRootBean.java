/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model;
import java.util.List;

/**
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private List<HeWeather5> HeWeather5;
    public void setHeWeather5(List<HeWeather5> HeWeather5) {
         this.HeWeather5 = HeWeather5;
     }
     public List<HeWeather5> getHeWeather5() {
         return HeWeather5;
     }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (HeWeather5 heWeather52 : HeWeather5) {
            sb.append(heWeather52.toString()+"\n");
        }
        return sb.toString();
    }

}