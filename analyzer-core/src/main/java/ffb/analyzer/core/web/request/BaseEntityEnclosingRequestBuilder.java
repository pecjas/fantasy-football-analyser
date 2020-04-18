package ffb.analyzer.core.web.request;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public interface BaseEntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase> {

    BaseEntityEnclosingRequestBuilder<T> addUrl(String url);

    BaseEntityEnclosingRequestBuilder<T> addRequestBodyParameter(String key, String value);

    T build();
}
