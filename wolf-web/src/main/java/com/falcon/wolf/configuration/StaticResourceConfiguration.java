package com.falcon.wolf.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/META-INF/resources/static/img/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/META-INF/resources/static/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/META-INF/resources/static/js/");
    }
}

