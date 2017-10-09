/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model.subModel;

/**
 * 基本信息
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Basic {

    private String city;
    /**国家*/
    private String cnty;
    /**地区编码*/
    private String id;
    /**纬度*/
    private String lat;
    /**经度*/
    private String lon;
    /**更新时间*/
    private Update update;
    public void setCity(String city) {
         this.city = city;
     }
     public String getCity() {
         return city;
     }

    public void setCnty(String cnty) {
         this.cnty = cnty;
     }
    /**国家*/
     public String getCnty() {
         return cnty;
     }

    public void setId(String id) {
         this.id = id;
     }
    /**地区编码*/
     public String getId() {
         return id;
     }

    public void setLat(String lat) {
         this.lat = lat;
     }
    /**纬度*/
     public String getLat() {
         return lat;
     }

    public void setLon(String lon) {
         this.lon = lon;
     }
    /**经度*/
     public String getLon() {
         return lon;
     }

    public void setUpdate(Update update) {
         this.update = update;
     }
    /**更新时间*/
     public Update getUpdate() {
         return update;
     }
    @Override
    public String toString() {
        return "Basic [city=" + city + ", cnty=" + cnty + ", id=" + id + ", lat=" + lat + ", lon=" + lon + ", update="
                + update.toString() + "]";
    }

}