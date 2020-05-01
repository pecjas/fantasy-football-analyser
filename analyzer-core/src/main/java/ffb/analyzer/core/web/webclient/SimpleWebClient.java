package ffb.analyzer.core.web.webclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

/**
 *  Web client with basic functionality to send HTTP requests.
 */
public class SimpleWebClient implements BaseWebClient {

    private static final List<DeserializationFeature> DEFAULT_DESERIALIZATION_OPTIONS = List.of(
        DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY
    );

    private final ObjectMapper objectMapper;

    public SimpleWebClient() {
        this.objectMapper = new ObjectMapper();
        DEFAULT_DESERIALIZATION_OPTIONS.forEach(objectMapper::enable);
    }

    @Override
    public <T> List<T> sendGet(HttpGet request, Class<T> entity) throws IOException {

        return objectMapper.readValue(
            sendAndGetResult(request),
            transformToList(entity)
        );
    }

    @Override
    public void sendPost(HttpPost request) throws IOException {
        try (CloseableHttpResponse response = doSend(request)) {
            //Close resources
        }

    }

    private InputStream sendAndGetResult(HttpRequestBase request) throws IOException {
        return doSend(request).getEntity().getContent();
    }

    private CloseableHttpResponse doSend(HttpRequestBase request) throws IOException {
        return HttpClients.createDefault().execute(request);
    }

    private <T> CollectionType transformToList(Class<T> entity) {
        return objectMapper.getTypeFactory().constructCollectionType(List.class, entity);
    }
}
