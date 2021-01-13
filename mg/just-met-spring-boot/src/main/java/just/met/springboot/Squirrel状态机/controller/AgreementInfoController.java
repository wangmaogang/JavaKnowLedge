package just.met.springboot.Squirrel状态机.controller;

import com.github.pagehelper.PageInfo;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.eneity.Agreement;
import just.met.springboot.Squirrel状态机.entity.AgreementInfo;
import just.met.springboot.Squirrel状态机.service.AgreementInfoService;
import just.met.springboot.idemp.eneity.PageUtils;
import just.met.springboot.idemp.eneity.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (AgreementInfo)表控制层
 *
 * @author mg
 * @since 2020-12-10 10:14:07
 */
@RestController
@RequestMapping("agreementInfo")
public class AgreementInfoController {
    /**
     * 服务对象
     */
    @Resource
    private AgreementInfoService agreementInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return R  data:AgreementInfo
     */
    @GetMapping("get")
    public R get(String id) {
        AgreementInfo agreementInfo = agreementInfoService.selectById(id);
        return R.ok().put("data", agreementInfo);
    }

    /**
     * 通过Map查询列表
     *
     * @param map 查询参数集合
     * @return R  data:List<AgreementInfo>
     */
    @RequestMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> map) {
        R r = null;
        try {
            List<AgreementInfo> result = agreementInfoService.selectList(map);
            PageInfo<AgreementInfo> pageInfo = new PageInfo<>(result);
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
     * @param agreementInfo 实体类
     * @return R
     */
    @RequestMapping("/save")
    @ResponseBody
    public R save(@ModelAttribute("agreementInfo") AgreementInfo agreementInfo) {
        R r = null;
        try {
            if (agreementInfoService.insert(agreementInfo) > 0) {
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
     * @param agreementInfo 实体类
     * @return R
     */
    @RequestMapping("/update")
    @ResponseBody
    public R update(@ModelAttribute("agreementInfo") AgreementInfo agreementInfo) {
        R r = null;
        try {
            if (agreementInfoService.update(agreementInfo) > 0) {
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
            if (agreementInfoService.deleteById(id) > 0) {
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
            AgreementInfo agreement = new AgreementInfo();
            agreement.setStatus(AgreementStatus.INIT.toString());
            agreement.setName(UUID.randomUUID().toString());
            agreementInfoService.insert(agreement);
        }

        //2.测试批量插入
        List<AgreementInfo> list = new ArrayList<>();
        for(int i = 0;i <20 ;i++){
            AgreementInfo agreement = new AgreementInfo();
            agreement.setStatus(AgreementStatus.INIT.toString());
            agreement.setName(UUID.randomUUID().toString());
            list.add(agreement);
        }
        agreementInfoService.insertBatch(list);

        //2.测试批量插入
        for(int i = 0;i <10 ;i++){
            AgreementInfo agreement = new AgreementInfo();
            agreement.setId(i);
            agreement.setStatus(AgreementStatus.IS_SUBMITTED.toString());
            agreement.setName(UUID.randomUUID().toString());
            agreementInfoService.update(agreement);
        }

        //2.测试批量插入
        List<AgreementInfo> updateList = new ArrayList<>();
        for(int i = 10;i <20 ;i++){
            AgreementInfo agreement = new AgreementInfo();
            agreement.setId(i);
            agreement.setStatus(AgreementStatus.IS_COMPLETED.toString());
            updateList.add(agreement);
        }
        agreementInfoService.updateBatch(updateList);
    }

}