package ffb.analyzer.core.web.request;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.BasicNameValuePair;

/**
 * Implementation of a {@link EntityEnclosingRequestBuilder}.
 * @param <T> Type of request to be built.
 */
public final class SimpleEntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase>
    implements EntityEnclosingRequestBuilder<T>
{

    private final Set<NameValuePair> requestParameters;
    private final Supplier<T> providedConstructor;
    private String url;

    private SimpleEntityEnclosingRequestBuilder(final Supplier<T> constructor) {
        this.providedConstructor = constructor;
        this.requestParameters = new HashSet<>();
    }

    @Override
    public EntityEnclosingRequestBuilder<T> addUrl(String targetUrl) {
        this.url = targetUrl;
        return this;
    }

    @Override
    public EntityEnclosingRequestBuilder<T> addRequestBodyParameter(String key, String value) {
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

    /**
     * @return New instance of a {@link SimpleEntityEnclosingRequestBuilder}.
     */
    public static <T extends HttpEntityEnclosingRequestBase> SimpleEntityEnclosingRequestBuilder<T>
        newInstance(Supplier<T> constructor)
    {
        return new SimpleEntityEnclosingRequestBuilder<>(constructor);
    }
}
