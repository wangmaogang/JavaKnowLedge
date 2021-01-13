package just.met.springboot.Squirrel状态机.dao;

import just.met.springboot.Squirrel状态机.entity.AgreementInfo;

import java.util.List;
import java.util.Map;


/**
 * (AgreementInfo)表数据库访问层
 *
 * @author mg
 * @since 2020-12-10 10:14:05
 */
public interface AgreementInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AgreementInfo selectById(String id);

    /**
     * 通过Map作为筛选条件查询
     *
     * @param map 查询参数集合
     * @return 对象列表
     */
    List<AgreementInfo> selectList(Map<String, Object> map);

    /**
     * 新增数据
     *
     * @param agreementInfo 实例对象
     * @return 1成功 0失败
     */
    int insert(AgreementInfo agreementInfo);

    /**
     * 批量新增数据-自定义列
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    int insertBatch(List<AgreementInfo> list);

    /**
     * 修改数据
     *
     * @param agreementInfo 实例对象
     * @return 1成功 0失败
     */
    int update(AgreementInfo agreementInfo);

    /**
     * 批量更新数据-自定义列
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    int updateBatch(List<AgreementInfo> list);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 1成功 0失败
     */
    int deleteById(String id);

}