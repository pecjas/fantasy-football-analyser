package ffb.analyzer.core.web.webclient;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ffb.analyzer.core.web.request.SimpleEntityEnclosingRequestBuilder;
import ffb.analyzer.core.web.webclient.servlet.TestPerson;
import ffb.analyzer.core.web.webclient.servlet.TestServletInitializer;

/**
 * Tests a {@link SimpleWebClient}. Assumes that port 9090 is available to run a Springboot Application.
 * See {@link TestServletInitializer} for more information about the service.
 */
public class SimpleWebClientTest {

    private static final String BASE_URL = "http://localhost:9000";
    private static final String GET_SINGLE_URL = BASE_URL + "/test-single-get";
    private static final String GET_ARRAY_URL =  BASE_URL + "/test-get";
    private static final String POST_URL = BASE_URL + "/test-post";

    private static SimpleWebClient client;

    /**
     * Initializes servlet for the tests.
     */
    @BeforeClass
    public static void prepareTests() {
        TestServletInitializer.main(new String[1]);
        client = new SimpleWebClient();
    }

    /**
     * Closes servlet after all the tests are run.
     */
    @AfterClass
    public static void cleanupTests() {
        TestServletInitializer.closeContext();
    }

    /**
     * @throws IOException Thrown if request fails.
     */
    @Test
    public void testGetRequestWithArrayAsResponse() throws IOException {
        HttpGet request = new HttpGet(GET_ARRAY_URL);
        List<TestPerson> response = client.sendGet(request, TestPerson.class);

        Assert.assertNotNull(response);
        Assert.assertFalse(response.isEmpty());
        Assert.assertNotNull(response.get(0).getFirstName());
        Assert.assertNotNull(response.get(0).getLastName());
    }

    /**
     * @throws IOException Thrown if the request fails.
     */
    @Test
    public void testGetRequestWithSingleObjectAsResponse() throws IOException {
        HttpGet request = new HttpGet(GET_SINGLE_URL);
        List<TestPerson> response = client.sendGet(request, TestPerson.class);

        Assert.assertNotNull(response);
        Assert.assertEquals(1, response.size());
        Assert.assertNotNull(response.get(0).getFirstName());
        Assert.assertNotNull(response.get(0).getLastName());
    }

    /**
     * @throws IOException Thrown if request fails.
     */
    @Test
    public void testPostRequest() throws IOException {
        HttpPost request = SimpleEntityEnclosingRequestBuilder.newInstance(HttpPost::new)
            .addUrl(POST_URL)
            .addRequestBodyParameter("firstName", "First")
            .addRequestBodyParameter("lastName", "Last")
            .build();

        client.sendPost(request);
    }

}
