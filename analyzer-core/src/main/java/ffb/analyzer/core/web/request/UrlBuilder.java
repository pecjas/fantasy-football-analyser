package ffb.analyzer.core.web.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import ffb.analyzer.core.web.HttpProtocol;

/**
 * Builder class to construct a URL from individual components.
 */
public final class UrlBuilder {

    private String host;
    private Optional<String> port;
    private HttpProtocol protocol;
    private final List<String> requestParameters;
    private final List<HttpQueryParameter> queryParameters;

    private UrlBuilder() {
        this.port = Optional.empty();
        this.requestParameters = new ArrayList<>();
        this.queryParameters = new ArrayList<>();
    }

    /**
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder atHost(String targetHost) {
        this.host = targetHost.toLowerCase();
        return this;
    }

    /**
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder atPort(int targetPort) {
        this.port = Optional.of(String.valueOf(targetPort));
        return this;
    }

    /**
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder using(HttpProtocol httpProtocol) {
        this.protocol = httpProtocol;
        return this;
    }

    /**
     * Specifies (as a string) the HTTP Protocol to use.
     * @param httpProtocol Protocol to use.
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder using(String httpProtocol) {
        this.protocol = ffb.analyzer.core.web.HttpProtocol.valueOf(httpProtocol);
        return this;
    }

    /**
     * Adds a path parameter to the URL.
     * @param parameter Parameter to add.
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder addRequestParameter(String parameter) {
        requestParameters.add(parameter.toLowerCase());
        return this;
    }

    /**
     * Adds a query parameter to the URL.
     * @param name Query parameter name.
     * @param value Query parameter value.
     * @return Reference to this instance of {@link UrlBuilder}.
     */
    public UrlBuilder addQueryParameter(String name, String value) {
        queryParameters.add(new HttpQueryParameter(name, value));
        return this;
    }

    /**
     * Constructs a URL from the components entered into the builder.
     * @return "" if no host or protocol was provided. Constructed URL otherwise.
     */
    public String build() {
        if (host == null || host.isEmpty() || protocol == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        makeBaseUrl(sb);
        makeRequestParameters(sb);
        makeQueryParameters(sb);

        return sb.toString();
    }

    private void makeBaseUrl(StringBuilder sb) {
        sb.append(protocol.toString().toLowerCase())
            .append("://")
            .append(host)
            .append(port.map(value -> ":" + value).orElse(""));
    }

    private void makeRequestParameters(StringBuilder sb) {
        if (requestParameters.isEmpty()) {
            return;
        }

        sb.append("/");
        StringJoiner joiner = new StringJoiner("/");
        requestParameters.forEach(joiner::add);

        sb.append(joiner.toString());
    }

    private void makeQueryParameters(StringBuilder sb) {
        if (queryParameters.isEmpty()) {
            return;
        }

        sb.append("?");
        StringJoiner joiner = new StringJoiner("&");
        queryParameters.forEach(q -> joiner.add(q.getFormattedParameter()));

        sb.append(joiner.toString());
    }

    /**
     * Instantiates a instance of {@link UrlBuilder}.
     * @return A new {@link UrlBuilder}.
     */
    public static UrlBuilder newInstance() {
        return new UrlBuilder();
    }
}
