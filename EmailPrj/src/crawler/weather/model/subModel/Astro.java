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
public class Astro {
    /**����ʱ��*/
    private String mr;
    /**����ʱ��  */
    private String ms;
    /**�ճ�ʱ��*/
    private String sr;
    /**����ʱ��*/
    private String ss;
    public void setMr(String mr) {
         this.mr = mr;
     }
    /**����ʱ��*/
     public String getMr() {
         return mr;
     }

    public void setMs(String ms) {
         this.ms = ms;
     }
    /**����ʱ��*/
     public String getMs() {
         return ms;
     }

    public void setSr(String sr) {
         this.sr = sr;
     }
    /**�ճ�ʱ��*/
     public String getSr() {
         return sr;
     }

    public void setSs(String ss) {
         this.ss = ss;
     }
    /**����ʱ��*/
     public String getSs() {
         return ss;
     }
    @Override
    public String toString() {
        return "Astro [mr=" + mr + ", ms=" + ms + ", sr=" + sr + ", ss=" + ss + "]";
    }

}