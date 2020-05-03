package ffb.analyzer.core.pubsub;

import java.util.Map;

public interface Subscriber {
    public void update(String publishedResult);
}