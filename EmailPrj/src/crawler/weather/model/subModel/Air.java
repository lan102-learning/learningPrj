/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model.subModel;

/**
 * 空气建议
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Air {
    /**简介*/
    private String brf;
    /**内容*/
    private String txt;
    public void setBrf(String brf) {
         this.brf = brf;
     }
    /**简介*/
     public String getBrf() {
         return brf;
     }

    public void setTxt(String txt) {
         this.txt = txt;
     }
    /**内容*/
     public String getTxt() {
         return txt;
     }
    @Override
    public String toString() {
        return "Air [brf=" + brf + ", txt=" + txt + "]";
    }

     
}