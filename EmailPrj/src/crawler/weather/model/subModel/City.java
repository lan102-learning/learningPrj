/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model.subModel;

/**
 * ����ָ��
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class City {
    /**��������ָ��*/
    private String aqi;
    private String co;
    private String no2;
    private String o3;
    private String pm10;
    private String pm25;
    /**���������𣬷ֱ��ţ����������Ⱦ���ж���Ⱦ���ض���Ⱦ��������Ⱦ*/
    private String qlty;
    private String so2;
    public void setAqi(String aqi) {
         this.aqi = aqi;
     }
    /**��������ָ��*/
     public String getAqi() {
         return aqi;
     }

    public void setCo(String co) {
         this.co = co;
     }
     public String getCo() {
         return co;
     }

    public void setNo2(String no2) {
         this.no2 = no2;
     }
     public String getNo2() {
         return no2;
     }

    public void setO3(String o3) {
         this.o3 = o3;
     }
     public String getO3() {
         return o3;
     }

    public void setPm10(String pm10) {
         this.pm10 = pm10;
     }
     public String getPm10() {
         return pm10;
     }

    public void setPm25(String pm25) {
         this.pm25 = pm25;
     }
     public String getPm25() {
         return pm25;
     }

    public void setQlty(String qlty) {
         this.qlty = qlty;
     }
    /**���������𣬷ֱ��ţ����������Ⱦ���ж���Ⱦ���ض���Ⱦ��������Ⱦ*/
     public String getQlty() {
         return qlty;
     }

    public void setSo2(String so2) {
         this.so2 = so2;
     }
     public String getSo2() {
         return so2;
     }
    @Override
    public String toString() {
        return "City [aqi=" + aqi + ", co=" + co + ", no2=" + no2 + ", o3=" + o3 + ", pm10=" + pm10 + ", pm25=" + pm25
                + ", qlty=" + qlty + ", so2=" + so2 + "]";
    }

}