package crawler.fjnuHqjtNotice;

/**
 * 福建师大后勤集团公告Bean
 * 
 * @author liuwenkang
 *
 */
public class FjnuHqjtNoticeBean {
    private String contant;
    private String tittle;
    private String url;
    private String date;

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FjnuHqjtNoticeBean :\ncontant=" + contant + "\ntittle=" + tittle + "\nurl=" + url + "\ndate=" + date;
    }

}
