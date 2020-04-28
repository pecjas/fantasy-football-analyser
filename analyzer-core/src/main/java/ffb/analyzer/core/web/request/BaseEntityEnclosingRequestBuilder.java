package ffb.analyzer.core.web.request;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * Common interface to describe a builder class to construct a request with a request body.
 * @param <T> Type of request to be built.
 */
public interface BaseEntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase> {

    /**
     * Adds a URL to the request.
     * @param url URL to send the request to.
     * @return Reference to the builder class.
     */
    BaseEntityEnclosingRequestBuilder<T> addUrl(String url);

    /**
     * Adds content to the request body.
     * @param key The parameter name in the body.
     * @param value The value for the parameter.
     * @return Reference to the builder class.
     */
    BaseEntityEnclosingRequestBuilder<T> addRequestBodyParameter(String key, String value);

    /**
     * Builds the request.
     * @return The constructed request.
     */
    T build();
}
