package ffb.analyzer.core.pubsub;

import java.util.*;

public class Publisher {
    private Object mutex = new Object();

    public enum Event {
        EXAMPLE_EVENT
    }

    private static Publisher publisher;
    private Map<Event, Set<Subscriber>> subscribers = new HashMap<>();

    private Publisher() {
        Arrays.asList(Event.values()).
                forEach(event -> {
                    subscribers.put(
                            event,
                            new HashSet<Subscriber>()
                    );
                });
    }

    public static Publisher getPublisher() {
        if (publisher == null) {
            publisher = new Publisher();
        }

        return publisher;
    }

    public boolean unsubscribe(Event event, Subscriber subscriber) {
        synchronized (mutex) {
            final Set<Subscriber> eventSubscriptions = this.subscribers.get(event);

            //TODO: Do we need to handle unsubscribe when not subscribed/event not listed?
            return eventSubscriptions.remove(subscriber);
        }
    }

    public boolean subscribe(Event event, Subscriber subscriber) {
        synchronized (mutex) {
            return subscribers.get(event).add(subscriber);
        }
    }

    public void publishResults(Event event, String resultString) {
        synchronized (mutex) {
            final Set<Subscriber> eventSubscribers = this.subscribers.get(event);
            eventSubscribers.parallelStream().forEach(subscriber -> subscriber.update(resultString));
        }
    }

    /***
     * Returns a clone of the subscribers HashSet to view subscriptions without allowing
     * direct aditing of the subscribers object.
     * @return A clone of the subscribers HashSet
     */
    public Map<Event, Set<Subscriber>> getSubscribersClone() {
        Map<Event, Set<Subscriber>> subscribersClone = new HashMap<>();

        Set<Subscriber> eventSubscribers;


        for (Map.Entry<Event, Set<Subscriber>> entry : subscribers.entrySet()) {
            subscribersClone.put(entry.getKey(),
                    new HashSet<>(entry.getValue()));
        }

        return subscribersClone;
    }
}
