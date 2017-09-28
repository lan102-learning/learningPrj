/**
  * Copyright 2017 bejson.com 
  */
package crawler.weather.model.subModel;

/**
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Sport {

    private String brf;
    private String txt;
    public void setBrf(String brf) {
         this.brf = brf;
     }
     public String getBrf() {
         return brf;
     }

    public void setTxt(String txt) {
         this.txt = txt;
     }
     public String getTxt() {
         return txt;
     }
    @Override
    public String toString() {
        return "Sport [brf=" + brf + ", txt=" + txt + "]";
    }

}