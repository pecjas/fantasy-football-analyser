package ffb.analyzer.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Application initializer for the project.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"ffb.analyzer.core"}) //TODO: Add Web module once that's ready
public class ApplicationInitializer implements ApplicationRunner {

    @Autowired
    private Logger logger;

    @Bean
    public Logger getLogger() {
        return LogManager.getLogger();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationInitializer.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Application has started.");
    }
}
