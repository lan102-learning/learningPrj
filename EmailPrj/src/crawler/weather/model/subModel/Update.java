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
public class Update {

    private String loc;
    private String utc;
    public void setLoc(String loc) {
         this.loc = loc;
     }
     public String getLoc() {
         return loc;
     }

    public void setUtc(String utc) {
         this.utc = utc;
     }
     public String getUtc() {
         return utc;
     }
    @Override
    public String toString() {
        return "Update [loc=" + loc + ", utc=" + utc + "]";
    }

}