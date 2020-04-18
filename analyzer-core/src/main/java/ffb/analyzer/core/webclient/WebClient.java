package ffb.analyzer.core.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Optional;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WebClient implements BaseWebClient {

    private static final ObjectMapper sharedMapper = new ObjectMapper();

    private final ObjectMapper objectMapper;

    private WebClient (ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> Optional<T> sendGet(HttpGet request, Class<T> entity) {

        CloseableHttpClient client = HttpClients.createDefault();
        Optional<T> responseObject = Optional.empty();

        try {
            responseObject = Optional.ofNullable(objectMapper.readValue(
                client.execute(request).getEntity().getContent(),
                entity
            ));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseObject;
    }

    @Override
    public void sendPost(HttpPost request) {
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebClient createWebClient() {
        return new WebClient(sharedMapper);
    }
}
