package ffb.analyzer.application;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import ffb.analyzer.core.database.PostgresqlEntityManagerProducer;

/**
 * Application initializer for the project.
 */
//TODO: Add Web module once that's ready
@SpringBootApplication(scanBasePackages = {"ffb.analyzer.core", "ffb.analyzer.application"}, exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
public class ApplicationInitializer {
    private static final String[] ENTITY_PACKAGES = {
        "ffb.analyzer.models"
    };

    //TODO: Make this @Scope("request") once application is web-aware. This will be done with issue #48.
    @Bean
    @Scope("prototype")
    public EntityManager makeEntityManagerBean() {
        PostgresqlEntityManagerProducer entityManagerProducer = new PostgresqlEntityManagerProducer(ENTITY_PACKAGES);
        return entityManagerProducer.createEntityManager();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationInitializer.class);
    }
}
