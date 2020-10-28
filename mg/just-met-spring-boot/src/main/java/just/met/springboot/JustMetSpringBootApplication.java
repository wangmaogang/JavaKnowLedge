package just.met.springboot;

import feign.Request;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author wangmaogang
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan({"just.met.springboot.*.dao","just.met.springboot.*.*.dao"})
public class JustMetSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JustMetSpringBootApplication.class, args);
        System.out.printf("**************JustMetSpringBootApplication-BUILD-SUCCESS**************");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JustMetSpringBootApplication.class);
    }

    /**
     * 配置超时时间，亲测生效，默认超时时间10000,60000
     * @return
     */
    @Bean
    Request.Options feignOptions() {
        return new Request.Options(1 * 120000, 1 * 120000);
    }
}
