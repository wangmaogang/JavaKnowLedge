package just.met.mybatis.useful.controller;

import com.github.pagehelper.PageInfo;
import just.met.mybatis.common.eneity.PageUtils;
import just.met.mybatis.common.eneity.R;
import just.met.mybatis.useful.entity.BigTable;
import just.met.mybatis.useful.service.BigTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (BigTable)表控制层
 *
 * @author mg
 * @since 2021-01-13 11:06:41
 */
@RestController
@RequestMapping("bigTable")
public class BigTableController {
    /**
     * 服务对象
     */
    @Resource
    private BigTableService bigTableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return R  data:BigTable
     */
    @GetMapping("get")
    public R get(String id) {
        BigTable bigTable = bigTableService.selectById(id);
        return R.ok().put("data", bigTable);
    }

    /**
     * 通过Map查询列表
     *
     * @param map 查询参数集合
     * @return R  data:List<BigTable>
     */
    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> map) {
        R r = null;
        try {
            List<BigTable> result = bigTableService.selectList(map);
            PageInfo<BigTable> pageInfo = new PageInfo<>(result);
            PageUtils pageUtil = new PageUtils(pageInfo.getList(), pageInfo.getTotal());
            r = R.ok().put("data", pageUtil);
        } catch (Exception e) {
            e.printStackTrace();
            r = R.error(e.getMessage());
        }
        return r;
    }

    /**
     * 保存
     *
     * @param bigTable 实体类
     * @return R
     */
    @RequestMapping("/save")
    @ResponseBody
    public R save(@ModelAttribute("bigTable") BigTable bigTable) {
        R r = null;
        try {
            if (bigTableService.insert(bigTable) > 0) {
                r = R.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            r = R.error(e.getMessage());
        }
        return r;
    }

    /**
     * 编辑
     *
     * @param bigTable 实体类
     * @return R
     */
    @RequestMapping("/update")
    @ResponseBody
    public R update(@ModelAttribute("bigTable") BigTable bigTable) {
        R r = null;
        try {
            if (bigTableService.update(bigTable) > 0) {
                r = R.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            r = R.error(e.getMessage());
        }
        return r;
    }

    /**
     * 删除功能
     *
     * @param id 主键
     * @return 成功失败
     */
    @RequestMapping("/delete")
    @ResponseBody
    public R delete(String id) {
        R r = null;
        try {
            if (bigTableService.deleteById(id) > 0) {
                r = R.ok();
            }
        } catch (Exception e) {
            e.printStackTrace();
            r = R.error(e.getMessage());
        }
        return r;
    }

    /**
     * 测试
     */
    @RequestMapping("/test")
    @ResponseBody
    public void test() {

        //1.测试单个插入
        for(int i = 0;i <20 ;i++){
            BigTable bigTable = new BigTable();
            bigTable.setName(UUID.randomUUID().toString());
            bigTableService.insert(bigTable);
        }

        //2.测试批量插入
        List<BigTable> list = new ArrayList<>();
        for(int i = 0;i <20 ;i++){
            BigTable bigTable = new BigTable();
            bigTable.setName(UUID.randomUUID().toString());
            list.add(bigTable);
        }
        bigTableService.insertBatch(list);

        //3.测试单个更新
        for(int i = 0;i <10 ;i++){
            BigTable bigTable = new BigTable();
            bigTable.setId(i);
            bigTable.setMobile(UUID.randomUUID().toString().substring(0,11));
            bigTable.setName(UUID.randomUUID().toString());
            bigTableService.update(bigTable);
        }

        //4.测试批量插入
        List<BigTable> updateList = new ArrayList<>();
        for(int i = 10;i <20 ;i++){
            BigTable bigTable = new BigTable();
            bigTable.setId(i);
            bigTable.setMobile(UUID.randomUUID().toString().substring(0,11));
            bigTable.setName(UUID.randomUUID().toString());
            updateList.add(bigTable);
        }
        bigTableService.updateBatch(updateList);
    }
}