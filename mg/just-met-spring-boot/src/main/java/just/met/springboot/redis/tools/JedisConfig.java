package just.met.springboot.redis.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author wangmaogang
 */
@Slf4j
@Configuration
public class JedisConfig  {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWaitMillis;

	@Value("${spring.redis.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.redis.testOnReturn}")
	private boolean testOnReturn;

	@Bean
	public JedisPool redisPoolFactory(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setMaxTotal(maxActive);
		jedisPoolConfig.setMinIdle(minIdle);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		jedisPoolConfig.setTestOnReturn(testOnReturn);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,null);
		log.info("JedisPool注入成功！");
		return  jedisPool;
	}
}
