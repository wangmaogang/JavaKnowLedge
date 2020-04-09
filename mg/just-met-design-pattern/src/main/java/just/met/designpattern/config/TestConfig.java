package just.met.designpattern.config;

import just.met.designpattern.design2.Singleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangmaogang
 */
@Configuration
public class TestConfig {

    @Bean
    public void test(){
        Singleton.getInstance();
    }
}
