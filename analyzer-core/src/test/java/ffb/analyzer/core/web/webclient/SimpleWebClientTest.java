package ffb.analyzer.core.web.webclient;

import ffb.analyzer.core.web.request.EntityEnclosingRequestBuilder;
import ffb.analyzer.core.web.webclient.servlet.TestPerson;
import ffb.analyzer.core.web.webclient.servlet.TestServletInitializer;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleWebClientTest {

    private static final String BASE_URL = "http://localhost:9000";
    private static final String GET_URL =  BASE_URL + "/test-get";
    private static final String POST_URL = BASE_URL + "/test-post";

    private static SimpleWebClient client;

    @BeforeClass
    public static void prepareTests() {
        TestServletInitializer.main(new String[1]);
        client = SimpleWebClient.createWebClient();
    }

    @AfterClass
    public static void cleanupTests() {
        TestServletInitializer.closeContext();
    }

    @Test
    public void testGetRequest() throws IOException {
        HttpGet request = new HttpGet(GET_URL);
        List<TestPerson> response = client.sendGet(request, TestPerson.class);

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
        Assert.assertNotNull(response.get(0).getFirstName());
        Assert.assertNotNull(response.get(0).getLastName());
    }

    @Test
    public void testPostRequest() throws IOException {
        HttpPost request = EntityEnclosingRequestBuilder.newInstance(HttpPost::new)
            .addUrl(POST_URL)
            .addRequestBodyParameter("firstName", "First")
            .addRequestBodyParameter("lastName", "Last")
            .build();

        client.sendPost(request);
    }

}
