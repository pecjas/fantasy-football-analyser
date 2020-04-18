package ffb.analyzer.core.web.webclient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.List;

public interface BaseWebClient {

    <T> List<T> sendGet(HttpGet request, Class<T> entity) throws IOException;

    void sendPost(HttpPost request) throws IOException;
}
