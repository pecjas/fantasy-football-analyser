package ffb.analyzer.core.pubsub;

import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public  class PubSubTests {
    Publisher publisher = Publisher.getPublisher();
    ExampleSubscriber subscriber = new ExampleSubscriber();

    public void subscribeToExampleEvent() {
        publisher.subscribe(Publisher.Event.EXAMPLE_EVENT, subscriber);
    }

    @After
    public void unsubscribeAll() {
        Map<Publisher.Event, Set<Subscriber>> currentSubscriptions = publisher.getSubscribersClone();

        for (Map.Entry<Publisher.Event, Set<Subscriber>> entry : currentSubscriptions.entrySet()) {
            for (Subscriber subscriber : entry.getValue()) {
                publisher.unsubscribe(entry.getKey(), subscriber);
            }
        }
    }

    @Test
    public void subscribeTest() {
        Map<Publisher.Event, Set<Subscriber>> originalSubscribers = publisher.getSubscribersClone();
        subscribeToExampleEvent();
        Map<Publisher.Event, Set<Subscriber>> newSubscribers = publisher.getSubscribersClone();

        Assert.assertNotEquals(originalSubscribers, newSubscribers);
        Assert.assertEquals(originalSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size() + 1,
                newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).size());

        Assert.assertTrue(newSubscribers.get(Publisher.Event.EXAMPLE_EVENT).contains(subscriber));
    }

    @Test
    public void unsubscribeTest() {
        subscribeToExampleEvent();
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
        subscribeToExampleEvent();
        publisher.publishResults(Publisher.Event.EXAMPLE_EVENT, ExampleSubscriber.EXPECTED_RESULT);
    }

}
