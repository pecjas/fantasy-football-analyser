package ffb.analyzer.core.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import ffb.analyzer.core.webclient.servlet.TestPerson;
import ffb.analyzer.core.webclient.servlet.TestServletInitializer;
import java.net.http.HttpRequest;
import java.util.Optional;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebClientTest {

    private static final String BASE_URL = "http://localhost:9000";
    private static final String GET_URL =  BASE_URL + "/test-get";
    private static final String POST_URL = BASE_URL + "/test-post";

    private static WebClient client;

    @BeforeClass
    public static void setup () {
        TestServletInitializer.main(new String[1]);
        client = WebClient.createWebClient();
    }

    @AfterClass
    public static void cleanup() {
        TestServletInitializer.closeContext();
    }

    @Test
    public void testGetRequest() {
        HttpGet request = new HttpGet(GET_URL);
        Optional<TestPerson> response = client.sendGet(request, TestPerson.class);

        Assert.assertTrue(response.isPresent());
        Assert.assertNotNull(response.get().getFirstName());
        Assert.assertNotNull(response.get().getLastName());
    }

    @Test
    public void testPostRequest() {
        TestPerson tp = new TestPerson();
        tp.setFirstName("First");
        tp.setLastName("Last");
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(tp);
            HttpPost request = new HttpPost(POST_URL);

            request.setEntity(new StringEntity(requestBody));

            client.sendPost(request);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
