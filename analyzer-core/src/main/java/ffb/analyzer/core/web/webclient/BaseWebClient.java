package ffb.analyzer.core.web.webclient;

import java.io.IOException;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/**
 * Common interface for a web request client.
 */
public interface BaseWebClient {

    /**
     * Sends the GET request specified.
     * @param request Request to send.
     * @param entity Entity that the response should be deserialized into.
     * @param <T> Type of class to deserialize.
     * @return A {@link List} of {@link T}
     * @throws IOException Thrown if the request fails.
     */
    <T> List<T> sendGet(HttpGet request, Class<T> entity) throws IOException;

    /**
     * Sends the POST request specified.
     * @param request Request to send.
     * @throws IOException Thrown if the request fails.
     */
    void sendPost(HttpPost request) throws IOException;
}
