package com.test.cards;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.Database;

import java.util.List;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "app.config")
@Data
public class AppConfig {
    private String message;
    private String email;
    private List<String> names;
    private DatabaseSettings database;

    @Data
    public static class DatabaseSettings {
        private String url;
        private String username;
        private String driver;
    }
}
