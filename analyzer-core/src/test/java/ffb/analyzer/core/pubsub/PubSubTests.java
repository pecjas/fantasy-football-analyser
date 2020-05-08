package ffb.analyzer.core.pubsub;

import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public  class PubSubTests {
    public class ExampleSubscriber implements Subscriber {
        final static String EXPECTED_RESULT = "ExampleSubscriber";

        @Override
        public void update(String publishedResult) {
            Assert.assertEquals(publishedResult, EXPECTED_RESULT);
        }
    }

    Publisher publisher = Publisher.getPublisher();
    ExampleSubscriber subscriber = new ExampleSubscriber();

    @After
    public void postTestCleanup() {
        Utils.unsubscribeAll(publisher);
    }

    @Test
    public void subscribeTest() {
        Map<Publisher.Event, Set<Subscriber>> originalSubscribers = publisher.getSubscribersClone();
        Utils.subscribeToExampleEvent(publisher, subscriber);
        Map<Publisher.Event, Set<Subscriber>> newSubscribers = publisher.getSubscribersClone();

        Assert.assertNotEquals(originalSubscribers, newSubscribers);
        Assert.assertEquals(originalSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size() + 1,
                newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size());

        Assert.assertTrue(newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).contains(subscriber));
    }

    @Test
    public void unsubscribeTest() {
        Utils.subscribeToExampleEvent(publisher, subscriber);
        Map<Publisher.Event, Set<Subscriber>> originalSubscribers = publisher.getSubscribersClone();

        publisher.unsubscribe(Publisher.Event.EXAMPLE_EVENT,subscriber);
        Map<Publisher.Event, Set<Subscriber>> newSubscribers = publisher.getSubscribersClone();

        Assert.assertNotEquals(originalSubscribers, newSubscribers);
        Assert.assertEquals(originalSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size(),
                newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size() + 1);

        Assert.assertFalse(newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).contains(subscriber));
    }

    @Test
    public void publishResultsTest() {
        Utils.subscribeToExampleEvent(publisher, subscriber);
        publisher.publishResults(Publisher.Event.EXAMPLE_EVENT, ExampleSubscriber.EXPECTED_RESULT);
    }

}
