package just.met.springboot.redis.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 流水号生成Dao层
 * @author noah
 **/
@Mapper
public interface RedisNumDao {

	/**
	 * 获取当天最大编号
	 * @return
	 */
	Integer getNowDayMaxNum();
}