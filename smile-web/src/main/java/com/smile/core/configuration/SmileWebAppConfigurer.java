package com.smile.core.configuration;

import com.smile.core.error.SmileErrorAttributes;
import com.smile.core.error.SmileErrorController;
import com.smile.core.session.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class SmileWebAppConfigurer
        extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/login").excludePathPatterns("/logout");
        super.addInterceptors(registry);
    }

    @Bean
    public SmileErrorController basicErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver>errorViewResolvers) {
        return new SmileErrorController(errorAttributes,serverProperties.getError() ,errorViewResolvers);
    }


    @Bean
    public SmileErrorAttributes errorAttributes() {
        return new SmileErrorAttributes();
    }

}