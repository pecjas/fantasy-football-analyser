package ffb.analyzer.core.web.request;

import ffb.analyzer.core.web.HttpProtocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

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

    public UrlBuilder atHost(String targetHost) {
        this.host = targetHost.toLowerCase();
        return this;
    }

    public UrlBuilder atPort(int targetPort) {
        this.port = Optional.of(String.valueOf(targetPort));
        return this;
    }

    public UrlBuilder using(HttpProtocol httpProtocol) {
        this.protocol = httpProtocol;
        return this;
    }

    public UrlBuilder using(String httpProtocol) {
        this.protocol = ffb.analyzer.core.web.HttpProtocol.valueOf(httpProtocol);
        return this;
    }

    public UrlBuilder addRequestParameter(String parameter) {
        requestParameters.add(parameter.toLowerCase());
        return this;
    }

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

    public static UrlBuilder newInstance() {
        return new UrlBuilder();
    }
}
