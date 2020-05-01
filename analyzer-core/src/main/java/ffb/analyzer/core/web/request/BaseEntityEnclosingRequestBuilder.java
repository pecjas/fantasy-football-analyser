package ffb.analyzer.core.web.request;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * Common interface to describe a builder class to construct a request with a request body.
 * @param <T> Type of request to be built.
 */
public interface BaseEntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase> {

    /**
     * @return Reference to the builder class.
     */
    BaseEntityEnclosingRequestBuilder<T> addUrl(String url);

    /**
     * @return Reference to the builder class.
     */
    BaseEntityEnclosingRequestBuilder<T> addRequestBodyParameter(String key, String value);

    /**
     * @return The constructed request.
     */
    T build();
}
