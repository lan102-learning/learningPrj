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
public class Wind {

    private String deg;
    private String dir;
    private String sc;
    private String spd;
    public void setDeg(String deg) {
         this.deg = deg;
     }
     public String getDeg() {
         return deg;
     }

    public void setDir(String dir) {
         this.dir = dir;
     }
     public String getDir() {
         return dir;
     }

    public void setSc(String sc) {
         this.sc = sc;
     }
     public String getSc() {
         return sc;
     }

    public void setSpd(String spd) {
         this.spd = spd;
     }
     public String getSpd() {
         return spd;
     }
    @Override
    public String toString() {
        return "Wind [deg=" + deg + ", dir=" + dir + ", sc=" + sc + ", spd=" + spd + "]";
    }

}