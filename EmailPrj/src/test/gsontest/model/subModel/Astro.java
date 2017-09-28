/**
  * Copyright 2017 bejson.com 
  */
package test.gsontest.model.subModel;

/**
 * 天文指数
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Astro {
    /**月升时间*/
    private String mr;
    /**月落时间  */
    private String ms;
    /**日出时间*/
    private String sr;
    /**日落时间*/
    private String ss;
    public void setMr(String mr) {
         this.mr = mr;
     }
    /**月升时间*/
     public String getMr() {
         return mr;
     }

    public void setMs(String ms) {
         this.ms = ms;
     }
    /**月升时间*/
     public String getMs() {
         return ms;
     }

    public void setSr(String sr) {
         this.sr = sr;
     }
    /**日出时间*/
     public String getSr() {
         return sr;
     }

    public void setSs(String ss) {
         this.ss = ss;
     }
    /**日落时间*/
     public String getSs() {
         return ss;
     }
    @Override
    public String toString() {
        return "Astro [mr=" + mr + ", ms=" + ms + ", sr=" + sr + ", ss=" + ss + "]";
    }

}