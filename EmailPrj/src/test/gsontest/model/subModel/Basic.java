/**
  * Copyright 2017 bejson.com 
  */
package test.gsontest.model.subModel;

/**
 * ������Ϣ
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Basic {

    private String city;
    /**����*/
    private String cnty;
    /**��������*/
    private String id;
    /**γ��*/
    private String lat;
    /**����*/
    private String lon;
    /**����ʱ��*/
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
    /**����*/
     public String getCnty() {
         return cnty;
     }

    public void setId(String id) {
         this.id = id;
     }
    /**��������*/
     public String getId() {
         return id;
     }

    public void setLat(String lat) {
         this.lat = lat;
     }
    /**γ��*/
     public String getLat() {
         return lat;
     }

    public void setLon(String lon) {
         this.lon = lon;
     }
    /**����*/
     public String getLon() {
         return lon;
     }

    public void setUpdate(Update update) {
         this.update = update;
     }
    /**����ʱ��*/
     public Update getUpdate() {
         return update;
     }
    @Override
    public String toString() {
        return "Basic [city=" + city + ", cnty=" + cnty + ", id=" + id + ", lat=" + lat + ", lon=" + lon + ", update="
                + update.toString() + "]";
    }

}