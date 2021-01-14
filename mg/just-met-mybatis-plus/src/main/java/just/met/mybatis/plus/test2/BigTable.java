package just.met.mybatis.plus.test2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BigTable {

    private Integer id;

    private String name;

    private String mobile;

    private String passwd;

    private Byte sex;

    private Date birthday;

    private Date updatedTime;

}
