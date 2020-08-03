package just.met.springboot;

import feign.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author wangmaogang
 */
@SpringBootApplication
@EnableFeignClients
public class JustMetSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JustMetSpringBootApplication.class, args);
        System.out.printf("**************JustMetSpringBootApplication-BUILD-SUCCESS**************");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JustMetSpringBootApplication.class);
    }

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(/**connectTimeoutMillis**/1 * 120000, /** readTimeoutMillis **/1 * 120000);
    }
}
