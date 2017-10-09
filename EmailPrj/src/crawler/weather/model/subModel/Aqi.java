/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model.subModel;

/**
 * 空气质量指数
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Aqi {
    /**城市空气质量*/
    private City city;
    public void setCity(City city) {
         this.city = city;
     }
    /**城市空气质量*/
     public City getCity() {
         return city;
     }
    @Override
    public String toString() {
        return "Aqi [city=" + city.toString() + "]";
    }

}