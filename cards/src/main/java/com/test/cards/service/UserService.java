package com.test.cards.service;

import com.test.cards.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RefreshScope
public class UserService {
    private final AppConfig appConfig;

    public UserService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public String getConfiguredMessage() {
        return appConfig.getMessage();
    }

    public String getConfiguredEmail() {
        return appConfig.getEmail();
    }

    public List<String> getConfiguredNames() {
        return appConfig.getNames();
    }
}
