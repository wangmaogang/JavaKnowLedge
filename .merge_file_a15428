package just.met.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author wangmaogang
 */
@Configuration
public class TestConfig {

    @Bean
    public String BeanTest(){
        System.out.println("*******@Bean|TestConfig-BeanTest加载*******");
        return "TestConfig";
    }

    @Component
    public class ComponentTest{
        public ComponentTest(){
            System.out.println("*******@Component|ComponentTest加载*******");
        }
    }

    @Service
    public class ServiceTest{
        public ServiceTest(){
            System.out.println("*******@Service|ServiceTest加载*******");
        }
    }
    @Repository
    public class RepositoryTest{
        public RepositoryTest(){
            System.out.println("*******@Repository|RepositoryTest加载*******");
        }
    }

}
