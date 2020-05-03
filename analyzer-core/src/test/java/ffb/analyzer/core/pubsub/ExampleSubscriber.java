package ffb.analyzer.core.pubsub;

import org.junit.Assert;

import java.util.Map;

public class ExampleSubscriber implements Subscriber {
    final static String EXPECTED_RESULT = "ExampleSubscriber";

    @Override
    public void update(String publishedResult) {
        Assert.assertEquals(publishedResult, EXPECTED_RESULT);
    }
}
