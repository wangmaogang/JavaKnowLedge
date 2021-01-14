package just.met.mybatis.plus;

import just.met.mybatis.plus.test2.BigTable;
import just.met.mybatis.plus.test2.dao.BigTableMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Resource
    private BigTableMapper bigTableMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<BigTable> userList = bigTableMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
