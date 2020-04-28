package ffb.analyzer.core.web.request;

import ffb.analyzer.core.web.HttpProtocol;
import org.junit.Assert;
import org.junit.Test;

public class UrlBuilderTest {
    private static final String HOST = "localhost";
    private static final int PORT = 443;

    /**
     * Verfies that URL construction fails if no host was provided to a {@link UrlBuilder}.
     */
    @Test
    public void testUrlWithNotHostFails() {
        String url = UrlBuilder.newInstance().build();
        Assert.assertTrue(url.isEmpty());
    }

    /**
     * Verifies that URL construction fails if not HTTP protocol was provided to a {@link UrlBuilder}.
     */
    @Test
    public void testUrlWithNoProtocolFails() {
        String url = UrlBuilder.newInstance().build();
        Assert.assertTrue(url.isEmpty());
    }

    /**
     * Verifies that a port is optional when constructing a URL.
     */
    @Test
    public void testUrlCreationWithNoPort() {
        String httpUrl = UrlBuilder.newInstance()
            .atHost(HOST)
            .using(HttpProtocol.HTTP)
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .atHost(HOST)
            .using(HttpProtocol.HTTPS)
            .build();


        Assert.assertTrue("http://localhost".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost".equalsIgnoreCase(httpsUrl));
    }

    /**
     * Verifies that ports can be added to a URL.
     */
    @Test
    public void testUrlWithPort() {
        String httpUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTP)
            .atHost(HOST)
            .atPort(PORT)
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTPS)
            .atHost(HOST)
            .atPort(PORT)
            .build();

        Assert.assertTrue("http://localhost:443".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost:443".equalsIgnoreCase(httpsUrl));
    }

    /**
     * Verifies that request parameters are added to a URL correctly.
     */
    @Test
    public void testUrlWithRequestParameters() {
        String httpUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTP)
            .atHost(HOST)
            .addRequestParameter("one")
            .addRequestParameter("two")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTPS)
            .atHost(HOST)
            .addRequestParameter("three")
            .addRequestParameter("four")
            .build();

        Assert.assertTrue("http://localhost/one/two".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost/three/four".equalsIgnoreCase(httpsUrl));
    }

    /**
     * Verifies that query parameters are added to a URL correctly.
     */
    @Test
    public void testUrlWithQueryParameters() {
        String httpUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTP)
            .atHost(HOST)
            .addQueryParameter("one", "one")
            .addQueryParameter("two", "two")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTPS)
            .atHost(HOST)
            .addQueryParameter("three", "three")
            .addQueryParameter("four",  "four")
            .build();

        Assert.assertTrue("http://localhost?one=one&two=two".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost?three=three&four=four".equalsIgnoreCase(httpsUrl));
    }

    /**
     * Tests the construction of a URL with both query parameters and request parameters.
     */
    @Test
    public void testUrlWithAllParts() {
        String httpUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTP)
            .atHost(HOST)
            .addRequestParameter("request")
            .addQueryParameter("query", "one")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(HttpProtocol.HTTPS)
            .atHost(HOST)
            .addRequestParameter("request")
            .addQueryParameter("query", "two")
            .build();

        Assert.assertTrue("http://localhost/request?query=one".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost/request?query=two".equalsIgnoreCase(httpsUrl));
    }

}
