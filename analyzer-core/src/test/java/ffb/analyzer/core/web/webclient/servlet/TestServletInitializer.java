package ffb.analyzer.core.web.webclient.servlet;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestServletInitializer extends SpringBootServletInitializer {

    private static ConfigurableApplicationContext context;

    /**
     * Closes the application context once the servlet should be destroyed.
     */
    public static void closeContext() {
        context.close();
    }

    /**
     * Initializes a Springboot Application instance.
     * @param args Application runner arguments. Ignored.
     */
    public static void main(String[] args) {
        SpringApplication testApplication = new SpringApplication(TestServletInitializer.class);
        testApplication.setDefaultProperties(Collections.singletonMap("server.port", "9000"));

        context = testApplication.run();
    }
}
