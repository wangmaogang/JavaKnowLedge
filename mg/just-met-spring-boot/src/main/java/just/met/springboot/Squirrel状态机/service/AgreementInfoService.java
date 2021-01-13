package just.met.springboot.Squirrel状态机.service;

import just.met.springboot.Squirrel状态机.entity.AgreementInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * (AgreementInfo)表数据库接口层
 *
 * @author mg
 * @since 2020-12-10 10:14:06
 */
public interface AgreementInfoService {

    /**
     * 通过ID查询单条数据
     */
    AgreementInfo selectById(String id);

    /**
     * 通过Map作为筛选条件查询
     */
    List<AgreementInfo> selectList(Map<String, Object> map);

    /**
     * 新增数据
     */
    int insert(AgreementInfo agreementInfo);

    /**
     * 批量新增数据
     */
    int insertBatch(@Param("list")List<AgreementInfo> list);

    /**
     * 修改数据
     */
    int update(AgreementInfo agreementInfo);

    /**
     * 批量更新数据
     */
    int updateBatch(@Param("list")List<AgreementInfo> list);

    /**
     * 通过主键删除数据
     */
    int deleteById(String id);

}