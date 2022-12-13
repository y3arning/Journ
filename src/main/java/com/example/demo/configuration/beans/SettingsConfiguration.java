package com.example.demo.configuration.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class SettingsConfiguration {
    @Bean
    public Properties databaseSettingsProperties() throws IOException {
        return PropertiesLoaderUtils.loadProperties(new ClassPathResource("/application.properties"));
    }
}
