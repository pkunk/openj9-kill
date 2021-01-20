package com.example.ojk;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = LiquibaseAutoConfiguration.class)
public class Application {

    private TelemetryClient telemetryClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        this.telemetryClient = new TelemetryClient();
    }
}
