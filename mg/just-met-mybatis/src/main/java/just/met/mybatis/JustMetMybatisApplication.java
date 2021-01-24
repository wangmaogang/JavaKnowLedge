package just.met.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan({"just.met.mybatis.*.dao","just.met.mybatis.*.*.dao"})
public class JustMetMybatisApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JustMetMybatisApplication.class, args);
		System.out.print("**************JustMetMybatisApplication-BUILD-SUCCESS**************");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JustMetMybatisApplication.class);
	}
}
