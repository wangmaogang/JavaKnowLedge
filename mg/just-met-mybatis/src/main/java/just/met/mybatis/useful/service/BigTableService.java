package just.met.mybatis.useful.service;

import just.met.mybatis.useful.entity.BigTable;

import java.util.List;
import java.util.Map;


/**
 * (BigTable)表数据库接口层
 *
 * @author mg
 * @since 2021-01-13 11:06:39
 */
public interface BigTableService {

    /**
     * 通过ID查询单条数据
     */
    BigTable selectById(String id);

    /**
     * 通过Map作为筛选条件查询
     */
    List<BigTable> selectList(Map<String, Object> map);

    /**
     * 新增数据
     */
    int insert(BigTable bigTable);

    /**
     * 批量新增数据
     */
    int insertBatch(List<BigTable> list);

    /**
     * 修改数据
     */
    int update(BigTable bigTable);

    /**
     * 批量更新数据
     */
    int updateBatch(List<BigTable> list);

    /**
     * 通过主键删除数据
     */
    int deleteById(String id);

}