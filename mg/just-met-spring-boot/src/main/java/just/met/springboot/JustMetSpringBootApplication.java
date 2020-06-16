package just.met.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
}
