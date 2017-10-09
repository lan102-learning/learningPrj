package robot.weatherCode;

public class WeatherCodeBean {
//                    
    private String city ;      //城市/地区编码
    private String cityEnName;//英文
    private String cityCnName;//中文
    private String countryCode;//国家代码
    private String countryEnName;//国家英文
    private String countryCnName;//国家中文  
    private String provinceEnName;//省英文
    private String provinceCnName;//省中文
    private String areaEnName;//所属上级市英文 
    private String areaCnName;//所属上级市中文
    private String weidu;//纬度
    private String jingdu;//经度
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCityEnName() {
        return cityEnName;
    }
    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }
    public String getCityCnName() {
        return cityCnName;
    }
    public void setCityCnName(String cityCnName) {
        this.cityCnName = cityCnName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryEnName() {
        return countryEnName;
    }
    public void setCountryEnName(String countryEnName) {
        this.countryEnName = countryEnName;
    }
    public String getCountryCnName() {
        return countryCnName;
    }
    public void setCountryCnName(String countryCnName) {
        this.countryCnName = countryCnName;
    }
    public String getProvinceEnName() {
        return provinceEnName;
    }
    public void setProvinceEnName(String provinceEnName) {
        this.provinceEnName = provinceEnName;
    }
    public String getProvinceCnName() {
        return provinceCnName;
    }
    public void setProvinceCnName(String provinceCnName) {
        this.provinceCnName = provinceCnName;
    }
    public String getAreaEnName() {
        return areaEnName;
    }
    public void setAreaEnName(String areaEnName) {
        this.areaEnName = areaEnName;
    }
    public String getAreaCnName() {
        return areaCnName;
    }
    public void setAreaCnName(String areaCnName) {
        this.areaCnName = areaCnName;
    }
    public String getWeidu() {
        return weidu;
    }
    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }
    public String getJingdu() {
        return jingdu;
    }
    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }
    @Override
    public String toString() {
        return "WeatherCodeBean [city=" + city + ", cityEnName=" + cityEnName + ", cityCnName=" + cityCnName
                + ", countryCode=" + countryCode + ", countryEnName=" + countryEnName + ", countryCnName="
                + countryCnName + ", provinceEnName=" + provinceEnName + ", provinceCnName=" + provinceCnName
                + ", areaEnName=" + areaEnName + ", areaCnName=" + areaCnName + ", weidu=" + weidu + ", jingdu="
                + jingdu + "]";
    }
    
    
    
}
