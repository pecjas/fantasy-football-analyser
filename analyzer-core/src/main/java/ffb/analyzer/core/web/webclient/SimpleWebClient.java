package ffb.analyzer.core.web.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

public class SimpleWebClient implements BaseWebClient {

    private final ObjectMapper objectMapper;

    public SimpleWebClient() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> List<T> sendGet(HttpGet request, Class<T> entity) throws IOException {

        return objectMapper.readValue(doSend(request).getEntity().getContent(),
            objectMapper.getTypeFactory().constructCollectionType(List.class, entity));
    }

    @Override
    public void sendPost(HttpPost request) throws IOException {
        try (CloseableHttpResponse response = doSend(request)) {
            //Close resources
        }

    }

    private CloseableHttpResponse doSend(HttpRequestBase request) throws IOException {
        return HttpClients.createDefault().execute(request);
    }
}
