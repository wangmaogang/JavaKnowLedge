package just.met.javabase.工具类.BeanUtils.entity;

import java.io.Serializable;

/**
 * 地址信息实体类
 * @author wangmaogang
 */
public class AddressDO implements Serializable {
    /**
     * 国家，如 '中国'
     */
    private String country;

    /**
     * 省份，如 '山东省'
     */
    private String province;

    /**
     * 城市，如 '青岛市'
     */
    private String city;

    /**
     * 区县，如 '李沧区'
     */
    private String district;

    /**
     * 乡镇（街道），如'浮山街道'
     */
    private String street;

    /**
     * 详细描述，如'XXX小区3单元301'
     */
    private String detailedDesc;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetailedDesc() {
        return detailedDesc;
    }

    public void setDetailedDesc(String detailedDesc) {
        this.detailedDesc = detailedDesc;
    }

    @Override
    public String toString() {
        return "AddressDO{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", detailedDesc='" + detailedDesc + '\'' +
                '}';
    }
}
