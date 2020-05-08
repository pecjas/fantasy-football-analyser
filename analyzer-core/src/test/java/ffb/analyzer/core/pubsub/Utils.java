package ffb.analyzer.core.pubsub;

import java.util.Map;
import java.util.Set;

public abstract class Utils {
    protected static void unsubscribeAll(Publisher publisher) {
        Map<Publisher.Event, Set<Subscriber>> currentSubscriptions = publisher.getSubscribersClone();

        for (Map.Entry<Publisher.Event, Set<Subscriber>> entry : currentSubscriptions.entrySet()) {
            for (Subscriber subscriber : entry.getValue()) {
                publisher.unsubscribe(entry.getKey(), subscriber);
            }
        }
    }

    protected static void subscribeToExampleEvent(Publisher publisher, Subscriber subscriber) {
        publisher.subscribe(Publisher.Event.EXAMPLE_EVENT, subscriber);
    }
}
