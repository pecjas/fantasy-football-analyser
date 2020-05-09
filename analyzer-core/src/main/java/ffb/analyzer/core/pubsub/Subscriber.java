package ffb.analyzer.core.pubsub;

import javax.ws.rs.core.Response;

public interface Subscriber extends Cloneable {
    public Response update(Object modifiedObject);
}
