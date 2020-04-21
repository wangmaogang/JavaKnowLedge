package just.met.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域配置
 * 注册到注册中心时，需要注释掉该方法。
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        System.out.println("*******@Bean|GlobalCorsConfig加载*******");

        // 1.添加CORS配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 放行哪些原始域
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        // 是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        // 放行哪些原始域(头部信息)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // 放行哪些原始域(请求方式)
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        // getResponseHeader()可返回的值（在web端获取ajax request的response中的自定义的header值，必须addExposedHeader
        corsConfiguration.addExposedHeader("sessionID");
        corsConfiguration.addExposedHeader("token");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        // 3.返回新的CorsFilter
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
