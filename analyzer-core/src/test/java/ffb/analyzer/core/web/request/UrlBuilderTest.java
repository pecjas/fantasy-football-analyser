package ffb.analyzer.core.web.request;

import org.junit.Assert;
import org.junit.Test;

public class UrlBuilderTest {
    private static final String HOST = "localhost";
    private static final int PORT = 443;

    @Test
    public void testUrlWithNotHostFails() {
        String url = UrlBuilder.newInstance().build();
        Assert.assertTrue(url.isEmpty());
    }

    @Test
    public void testUrlWithNoProtocolFails() {
        String url = UrlBuilder.newInstance().build();
        Assert.assertTrue(url.isEmpty());
    }

    @Test
    public void testUrlCreationWithNoPort() {
        String httpUrl = UrlBuilder.newInstance()
            .atHost(HOST)
            .using(UrlBuilder.HttpProtocol.HTTP)
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .atHost(HOST)
            .using(UrlBuilder.HttpProtocol.HTTPS)
            .build();


        Assert.assertTrue("http://localhost".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost".equalsIgnoreCase(httpsUrl));
    }

    @Test
    public void testUrlWithPort() {
        String httpUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTP)
            .atHost(HOST)
            .atPort(PORT)
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTPS)
            .atHost(HOST)
            .atPort(PORT)
            .build();

        Assert.assertTrue("http://localhost:443".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost:443".equalsIgnoreCase(httpsUrl));
    }

    @Test
    public void testUrlWithRequestParameters() {
        String httpUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTP)
            .atHost(HOST)
            .addRequestParameter("one")
            .addRequestParameter("two")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTPS)
            .atHost(HOST)
            .addRequestParameter("three")
            .addRequestParameter("four")
            .build();

        Assert.assertTrue("http://localhost/one/two".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost/three/four".equalsIgnoreCase(httpsUrl));
    }

    @Test
    public void testUrlWithQueryParameters() {
        String httpUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTP)
            .atHost(HOST)
            .addQueryParameter("one", "one")
            .addQueryParameter("two", "two")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTPS)
            .atHost(HOST)
            .addQueryParameter("three","three")
            .addQueryParameter("four", "four")
            .build();

        Assert.assertTrue("http://localhost?one=one&two=two".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost?three=three&four=four".equalsIgnoreCase(httpsUrl));
    }

    @Test
    public void testUrlWithAllParts() {
        String httpUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTP)
            .atHost(HOST)
            .addRequestParameter("request")
            .addQueryParameter("query","one")
            .build();

        String httpsUrl = UrlBuilder.newInstance()
            .using(UrlBuilder.HttpProtocol.HTTPS)
            .atHost(HOST)
            .addRequestParameter("request")
            .addQueryParameter("query", "two")
            .build();

        Assert.assertTrue("http://localhost/request?query=one".equalsIgnoreCase(httpUrl));
        Assert.assertTrue("https://localhost/request?query=two".equalsIgnoreCase(httpsUrl));
    }

}
