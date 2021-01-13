package just.met.mybatis.useful2.controller;

import just.met.mybatis.common.eneity.R;
import just.met.mybatis.useful2.dao.BigTable2Dao;
import just.met.mybatis.useful2.eneity.BigTable;
import just.met.mybatis.useful2.eneity.BigTableExample;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BigTable)表控制层
 *
 * @author mg
 * @since 2021-01-13 11:06:41
 */
@RestController
@RequestMapping("bigTable2")
public class BigTable2Controller {
    /**
     * 服务对象
     */
    @Resource
    private BigTable2Dao bigTableDAO;

    /**
     * 测试
     */
    @RequestMapping("/test_get")
    @ResponseBody
    public R test_get() {
        BigTableExample bigTableExample = new BigTableExample();
        BigTableExample.Criteria criteria = bigTableExample.createCriteria();
        criteria.andIdEqualTo(1);
        List<BigTable>  list = bigTableDAO.selectByExample(bigTableExample);
        return R.ok().put("data",list);
    }
}