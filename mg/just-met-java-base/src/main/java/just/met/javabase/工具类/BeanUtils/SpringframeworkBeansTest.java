package just.met.javabase.工具类.BeanUtils;

import just.met.javabase.工具类.BeanUtils.entity.AddressDO;
import just.met.javabase.工具类.BeanUtils.entity.UserDO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试org.springframework.beans.BeanUtils下的copyProperties功能 : A中的值赋给B
 * 主要测试点：
 * 1.firstUser是否会覆盖secondUser已有属性 ：是
 * 2.firstUser中的null属性是否会覆盖secondUser：是
 * 3.firstUser中的List属性是否会和secondUser合并 ：否，直接覆盖
 * @author wangmaogang
 */
public class SpringframeworkBeansTest {

    public static void main(String[] args) {

        UserDO firstUser = getFirstUser();
        System.out.println(firstUser.toString());
        UserDO secondUser = getSecondUser();
        System.out.println(secondUser.toString());
        //A中的值赋值给B
        BeanUtils.copyProperties(firstUser,secondUser);
        System.out.println(secondUser.toString());
    }

    /**
     * 获取第一个用户信息
     * @return
     */
    public static UserDO getFirstUser(){
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setName("name1");
        userDO.setEmail("email1");
        List<AddressDO> list = new ArrayList<>();
        AddressDO addressDO = new AddressDO();
        addressDO.setCity("city1");
        addressDO.setCountry("country1");
        addressDO.setDistrict("distinct1");
        list.add(addressDO);
        userDO.setHomeAddressDOS(list);
        return userDO;
    }

    /**
     * 获取第二个用户信息
     * @return
     */
    public static UserDO getSecondUser(){
        UserDO userDO = new UserDO();
        userDO.setId(2);
        userDO.setName("name2");
        userDO.setMobile("mobile2");
        List<AddressDO> list = new ArrayList<>();
        AddressDO addressDO = new AddressDO();
        addressDO.setCity("city2");
        addressDO.setCountry("country2");
        addressDO.setProvince("province2");
        list.add(addressDO);
        userDO.setHomeAddressDOS(list);
        return userDO;
    }

}
