package just.met.springboot.Squirrel状态机.entity;

import java.io.Serializable;

/**
 * (AgreementInfo)实体类
 *
 * @author mg
 * @since 2020-12-10 10:14:04
 */
public class AgreementInfo implements Serializable {


    private Integer id;

    private String name;

    private String status;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private static final long serialVersionUID = 275230437961500353L;

}