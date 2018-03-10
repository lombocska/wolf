package com.falcon.wolf.resource_handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
@ComponentScan
public class WolfPropertyConfiguration {

    static final String ENVIRONMENT = System.getProperty("env");

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(final ConfigurableEnvironment environment) throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        Resource[] resources = propertyResources();
        for (Resource resource : resources) {
            environment.getPropertySources().addLast(new ResourcePropertySource(resource));
        }
        return configurer;
    }

    private Resource[] propertyResources() {
        List<Resource> resources = new ArrayList<>();
        if (ENVIRONMENT != null) {
            resources.addAll(Arrays.asList(getResources(String.format("file://%s/*properties", ENVIRONMENT))));
        }
        return resources.toArray(new Resource[0]);
    }

    private Resource[] getResources(String format) {
        log.info("Add property resources: {}", format);
        try {
            return new PathMatchingResourcePatternResolver().getResources(format);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
