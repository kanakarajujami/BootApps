package com.nt.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Configuration
@ConfigurationProperties(prefix="plan.module")
@Data
public class AppConfigProperties {
public Map<String,String> messages;
}
