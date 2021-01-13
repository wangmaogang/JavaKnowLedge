package just.met.mybatis.useful.dao;

import just.met.mybatis.useful.entity.BigTable;

import java.util.List;
import java.util.Map;


/**
 * (BigTable)表数据库访问层
 *
 * @author mg
 * @since 2021-01-13 11:06:36
 */
public interface BigTableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BigTable selectById(String id);

    /**
     * 通过Map作为筛选条件查询
     *
     * @param map 查询参数集合
     * @return 对象列表
     */
    List<BigTable> selectList(Map<String, Object> map);

    /**
     * 新增数据
     *
     * @param bigTable 实例对象
     * @return 1成功 0失败
     */
    int insert(BigTable bigTable);

    /**
     * 批量新增数据-自定义列
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    int insertBatch(List<BigTable> list);

    /**
     * 修改数据
     *
     * @param bigTable 实例对象
     * @return 1成功 0失败
     */
    int update(BigTable bigTable);

    /**
     * 批量更新数据-自定义列
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    int updateBatch(List<BigTable> list);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 1成功 0失败
     */
    int deleteById(String id);

}