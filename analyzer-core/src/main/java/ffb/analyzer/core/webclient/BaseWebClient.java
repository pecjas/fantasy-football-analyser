package ffb.analyzer.core.webclient;

import java.io.IOException;
import java.util.Optional;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public interface BaseWebClient {

    <T> Optional<T> sendGet (HttpGet request, Class<T> entity) throws IOException;

    void sendPost (HttpPost request);
}
