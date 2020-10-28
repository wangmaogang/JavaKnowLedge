package just.met.springboot.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 * @author wangmaogang
 */
@Configuration
public class DynamicDataSourceConfig {

    @Value("${noah.driver-mysql}")
    private String mysqlDriver;

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource() {
        System.out.println(DruidDataSourceBuilder.create().build());
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        druidDataSource.setDriverClassName(mysqlDriver);
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        druidDataSource.setDriverClassName(mysqlDriver);
        return druidDataSource;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.third")
    public DataSource thirdDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        druidDataSource.setDriverClassName(mysqlDriver);
        return druidDataSource;
    }

    @Bean
    @Primary
    public DataSource dataSource(DataSource firstDataSource, DataSource secondDataSource, DataSource thirdDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>(8);
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        targetDataSources.put(DataSourceNames.THIRD, thirdDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
}
