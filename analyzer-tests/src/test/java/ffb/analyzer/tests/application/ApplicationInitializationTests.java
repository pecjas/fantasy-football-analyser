package ffb.analyzer.tests.application;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ffb.analyzer.application.ApplicationInitializer;

@SpringBootTest(classes = ffb.analyzer.application.ApplicationInitializer.class)
public class ApplicationInitializationTests {

    @PersistenceContext
    EntityManager em;

    @BeforeClass
    public static void prepareApplicationContext() {
        ApplicationInitializer.main(new String[0]);
    }

    @Test
    public void entityManagerCanBeInjected() {
        Assert.assertNotNull(em);
    }

}
