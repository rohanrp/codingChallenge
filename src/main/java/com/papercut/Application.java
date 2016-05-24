package com.papercut;

/**
* Minimal config spring Boot main class that inits the PrintJobConsoleRunner class
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        
    }

}
