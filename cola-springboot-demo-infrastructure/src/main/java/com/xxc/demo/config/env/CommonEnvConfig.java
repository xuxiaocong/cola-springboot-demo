package com.xxc.demo.config.env;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class CommonEnvConfig {
    @Value("${tempRootPath}")
    private String tempRootPath;
}
