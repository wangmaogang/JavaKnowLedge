package just.met.mybatis.useful.service.impl;

import just.met.mybatis.useful.dao.BigTableDao;
import just.met.mybatis.useful.entity.BigTable;
import just.met.mybatis.useful.service.BigTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * (BigTable)表服务实现类
 *
 * @author mg
 * @since 2021-01-13 11:06:40
 */
@Service("bigTableService")
public class BigTableServiceImpl implements BigTableService {

    @Resource
    private BigTableDao bigTableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BigTable selectById(String id) {
        return this.bigTableDao.selectById(id);
    }

    /**
     * 通过Map作为筛选条件查询
     *
     * @param map 查询参数集合
     * @return 对象列表
     */
    @Override
    public List<BigTable> selectList(Map<String, Object> map) {
        return this.bigTableDao.selectList(map);
    }

    /**
     * 新增数据
     *
     * @param bigTable 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int insert(BigTable bigTable) {
        int result = bigTableDao.insert(bigTable);
        return result;
    }

    /**
     * 批量新增数据
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int insertBatch(List<BigTable> list) {
        int result = bigTableDao.insertBatch(list);
        return result;
    }

    /**
     * 修改数据
     *
     * @param bigTable 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int update(BigTable bigTable) {
        return bigTableDao.update(bigTable);
    }

    /**
     * 批量更新数据
     *
     * @param list 实例对象
     * @return 1成功 0失败
     */
    @Override
    public int updateBatch(List<BigTable> list) {
        int result = bigTableDao.updateBatch(list);
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
        return this.bigTableDao.deleteById(id);
    }
}