package robot.weatherCode;

public class WeatherCodeBean {
//                    
    private String city ;      //����/��������
    private String cityEnName;//Ӣ��
    private String cityCnName;//����
    private String countryCode;//���Ҵ���
    private String countryEnName;//����Ӣ��
    private String countryCnName;//��������  
    private String provinceEnName;//ʡӢ��
    private String provinceCnName;//ʡ����
    private String areaEnName;//�����ϼ���Ӣ�� 
    private String areaCnName;//�����ϼ�������
    private String weidu;//γ��
    private String jingdu;//����
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
