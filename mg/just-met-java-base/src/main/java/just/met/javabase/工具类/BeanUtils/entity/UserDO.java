package just.met.javabase.工具类.BeanUtils.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息实体类
 * @author wangmaogang
 */
public class UserDO implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 出生日期
     */
    private String birthDate;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 是否启用
     */
    private Boolean useFlag;

    /**
     * 家庭住址
     */
    private List<AddressDO> homeAddressDOS;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public List<AddressDO> getHomeAddressDOS() {
        return homeAddressDOS;
    }

    public void setHomeAddressDOS(List<AddressDO> homeAddressDOS) {
        this.homeAddressDOS = homeAddressDOS;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", sex=" + sex +
                ", useFlag=" + useFlag +
                ", homeAddressDOS=" + homeAddressDOS +
                '}';
    }
}
