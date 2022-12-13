package com.example.demo.configuration.settings;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class DatabaseProperties {
    private String username;
    private String password;
    private String url;
    public DatabaseProperties(@Qualifier("databaseSettingsProperties") Properties databaseSettingsProperties){
        this.password = databaseSettingsProperties.getProperty("spring.datasource.password");
        this.username = databaseSettingsProperties.getProperty("spring.datasource.username");
        this.url = databaseSettingsProperties.getProperty("spring.datasource.url");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
