package ffb.analyzer.core.web.request;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public final class EntityEnclosingRequestBuilder<T extends HttpEntityEnclosingRequestBase>
    implements BaseEntityEnclosingRequestBuilder<T>
{

    private final Set<NameValuePair> requestParameters;
    private final Supplier<T> providedConstructor;
    private String url;

    private EntityEnclosingRequestBuilder(final Supplier<T> constructor) {
        this.providedConstructor = constructor;
        this.requestParameters = new HashSet<>();
    }

    @Override
    public BaseEntityEnclosingRequestBuilder<T> addUrl(String targetUrl) {
        this.url = targetUrl;
        return this;
    }

    @Override
    public BaseEntityEnclosingRequestBuilder<T> addRequestBodyParameter(String key, String value) {
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

    public static <T extends HttpEntityEnclosingRequestBase> EntityEnclosingRequestBuilder<T>
        newInstance(Supplier<T> constructor)
    {
        return new EntityEnclosingRequestBuilder<>(constructor);
    }
}
