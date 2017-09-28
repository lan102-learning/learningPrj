/**
  * Copyright 2017 bejson.com 
  */
package test.gsontest.model.subModel;

/**
 * Auto-generated: 2017-09-28 14:33:37
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Now {

    private Cond cond;
    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tmp;
    private String vis;
    private Wind wind;
    public void setCond(Cond cond) {
         this.cond = cond;
     }
     public Cond getCond() {
         return cond;
     }

    public void setFl(String fl) {
         this.fl = fl;
     }
     public String getFl() {
         return fl;
     }

    public void setHum(String hum) {
         this.hum = hum;
     }
     public String getHum() {
         return hum;
     }

    public void setPcpn(String pcpn) {
         this.pcpn = pcpn;
     }
     public String getPcpn() {
         return pcpn;
     }

    public void setPres(String pres) {
         this.pres = pres;
     }
     public String getPres() {
         return pres;
     }

    public void setTmp(String tmp) {
         this.tmp = tmp;
     }
     public String getTmp() {
         return tmp;
     }

    public void setVis(String vis) {
         this.vis = vis;
     }
     public String getVis() {
         return vis;
     }

    public void setWind(Wind wind) {
         this.wind = wind;
     }
     public Wind getWind() {
         return wind;
     }
    @Override
    public String toString() {
        return "Now [cond=" + cond.toString() + ", fl=" + fl + ", hum=" + hum + ", pcpn=" + pcpn + ", pres=" + pres + ", tmp="
                + tmp + ", vis=" + vis + ", wind=" + wind.toString() + "]";
    }

}