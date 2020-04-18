package ffb.analyzer.core.web.request;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.BasicNameValuePair;

public class EntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase> implements BaseRequestBuilder<T> {

    private final Set<NameValuePair> requestParameters;
    private final Supplier<T> providedConstructor;
    private String url;

    private EntityEnclosingRequestBuilder (Supplier<T> constructor) {
        this.providedConstructor = constructor;
        this.requestParameters = new HashSet<>();
    }

    @Override
    public BaseRequestBuilder<T> addUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public BaseRequestBuilder<T> addRequestBodyParameter(String key, String value) {
        requestParameters.add(new BasicNameValuePair(key, value));
        return this;
    }

    @Override
    public T build() {
        T request = providedConstructor.get();

        request.setURI(URI.create(url));
        request.setEntity(new UrlEncodedFormEntity(requestParameters));

        return request;
    }

    public static <T extends HttpEntityEnclosingRequestBase> EntityEnclosingRequestBuilder<T> newInstance(
        Supplier<T> constructor)
    {
        return new EntityEnclosingRequestBuilder<>(constructor);
    }
}
