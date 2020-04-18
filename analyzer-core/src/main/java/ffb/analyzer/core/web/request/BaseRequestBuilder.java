package ffb.analyzer.core.web.request;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public interface BaseRequestBuilder<T extends HttpEntityEnclosingRequestBase> {

    BaseRequestBuilder<T> addUrl(String url);

    BaseRequestBuilder<T> addRequestBodyParameter(String key, String value);

    T build();
}
