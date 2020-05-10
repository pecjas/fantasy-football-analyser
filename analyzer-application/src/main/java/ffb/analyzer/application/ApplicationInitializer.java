package ffb.analyzer.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * Application initializer for the project.
 */
@SpringBootApplication(scanBasePackages = {"ffb.analyzer.core"}) //TODO: Add Web module once that's ready
public class ApplicationInitializer {

    @Autowired
    private Logger logger;

    @Bean
    public Logger getLogger() {
        return LogManager.getLogger();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationInitializer.class);
    }
}
