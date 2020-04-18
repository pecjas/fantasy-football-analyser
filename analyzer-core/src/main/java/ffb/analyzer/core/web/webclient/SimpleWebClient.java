package ffb.analyzer.core.web.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

public class SimpleWebClient implements BaseWebClient {

    private static final ObjectMapper sharedMapper = new ObjectMapper();

    private final ObjectMapper objectMapper;

    private SimpleWebClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> List<T> sendGet(HttpGet request, Class<T> entity) throws IOException {

        return objectMapper.readValue(
            HttpClients.createDefault().execute(request).getEntity().getContent(),
            objectMapper.getTypeFactory().constructCollectionType(List.class, entity)
        );
    }

    @Override
    public void sendPost(HttpPost request) throws IOException {
        HttpClients.createDefault().execute(request);
    }

    public static SimpleWebClient createWebClient() {
        return new SimpleWebClient(sharedMapper);
    }
}
