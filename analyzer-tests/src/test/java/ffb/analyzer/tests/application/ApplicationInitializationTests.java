package ffb.analyzer.tests.application;

import ffb.analyzer.application.ApplicationInitializer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ffb.analyzer.application.ApplicationInitializer.class)
public class ApplicationInitializationTests {

    @Test
    public void contextLoads () {
        ApplicationInitializer.main(new String[1]);
    }

}
