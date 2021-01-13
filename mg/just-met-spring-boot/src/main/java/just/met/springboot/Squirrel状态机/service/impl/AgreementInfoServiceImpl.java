package just.met.springboot.Squirrel状态机.service.impl;

import just.met.springboot.Squirrel状态机.dao.AgreementInfoDao;
import just.met.springboot.Squirrel状态机.entity.AgreementInfo;
import just.met.springboot.Squirrel状态机.service.AgreementInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * (AgreementInfo)表服务实现类
 *
 * @author mg
 * @since 2020-12-10 10:14:06
 */
@Service("agreementInfoService")
public class AgreementInfoServiceImpl implements AgreementInfoService {

    @Autowired(required = false)
    @Lazy
    private AgreementInfoDao agreementInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AgreementInfo selectById(String id) {
        return this.agreementInfoDao.selectById(id);
    }

    /**
     * 通过Map作为筛选条件查询
     *
     * @param map 查询参数集合
     * @return 对象列表
     */
    @Override
    public List<AgreementInfo> selectList(Map<String, Object> map) {
        return this.agreementInfoDao.selectList(map);
    }

    /**
     * 新增数据
     *
     * @param agreementInfo 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int insert(AgreementInfo agreementInfo) {
        int result = agreementInfoDao.insert(agreementInfo);
        return result;
    }

    /**
     * 批量新增数据
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int insertBatch(List<AgreementInfo> list) {
        int result = agreementInfoDao.insertBatch(list);
        return result;
    }

    /**
     * 修改数据
     *
     * @param agreementInfo 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int update(AgreementInfo agreementInfo) {
        int result = agreementInfoDao.update(agreementInfo);
        return result;
    }

    /**
     * 批量更新数据
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int updateBatch(List<AgreementInfo> list) {
        int result = agreementInfoDao.updateBatch(list);
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 1成功 0失败
     */
    @Override
    public int deleteById(String id) {
        return this.agreementInfoDao.deleteById(id);
    }
}