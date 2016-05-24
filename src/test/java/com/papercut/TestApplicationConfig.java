package com.papercut;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.papercut.*"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = PrintJobConsoleRunner.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Application.class)
})
public class TestApplicationConfig {
}
