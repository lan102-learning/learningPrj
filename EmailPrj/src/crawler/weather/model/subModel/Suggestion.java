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
public class Suggestion {

    private Air air;
    private Comf comf;
    private Cw cw;
    private Drsg drsg;
    private Flu flu;
    private Sport sport;
    private Trav trav;
    private Uv uv;
    public void setAir(Air air) {
         this.air = air;
     }
     public Air getAir() {
         return air;
     }

    public void setComf(Comf comf) {
         this.comf = comf;
     }
     public Comf getComf() {
         return comf;
     }

    public void setCw(Cw cw) {
         this.cw = cw;
     }
     public Cw getCw() {
         return cw;
     }

    public void setDrsg(Drsg drsg) {
         this.drsg = drsg;
     }
     public Drsg getDrsg() {
         return drsg;
     }

    public void setFlu(Flu flu) {
         this.flu = flu;
     }
     public Flu getFlu() {
         return flu;
     }

    public void setSport(Sport sport) {
         this.sport = sport;
     }
     public Sport getSport() {
         return sport;
     }

    public void setTrav(Trav trav) {
         this.trav = trav;
     }
     public Trav getTrav() {
         return trav;
     }

    public void setUv(Uv uv) {
         this.uv = uv;
     }
     public Uv getUv() {
         return uv;
     }
    @Override
    public String toString() {
        return "Suggestion [air=" + air.toString() + ", comf=" + comf.toString() + ", cw=" + cw.toString() + ", drsg=" + drsg.toString() + ", flu=" + flu.toString()
                + ", sport=" + sport.toString() + ", trav=" + trav.toString() + ", uv=" + uv.toString() + "]";
    }

}