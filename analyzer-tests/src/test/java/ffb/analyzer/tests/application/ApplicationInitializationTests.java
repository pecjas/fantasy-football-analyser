package ffb.analyzer.tests.application;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ffb.analyzer.application.ApplicationInitializer;

@SpringBootTest(classes = ffb.analyzer.application.ApplicationInitializer.class)
public class ApplicationInitializationTests {

    @Test
    public void contextLoads () {
        ApplicationInitializer.main(new String[1]);
    }

}
