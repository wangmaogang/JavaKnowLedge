package just.met.mybatis.useful.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BigTable)实体类
 *
 * @author mg
 * @since 2021-01-13 11:06:33
 */
public class BigTable implements Serializable {


    private Integer id;

    private String name;

    private String mobile;

    private String passwd;

    private Object sex;

    private Date birthday;

    private Date updatedTime;


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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    private static final long serialVersionUID = -55643785551041190L;

}