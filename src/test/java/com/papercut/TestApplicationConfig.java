package com.papercut;
/**
* Minimal config spring Boot config minus the console runner class that does
* not need to be run with tests
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
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
