package ffb.analyzer.core.web.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

public class UrlBuilder {

    public enum HttpProtocol {
        HTTP,
        HTTPS
    }

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

    public UrlBuilder atHost(String host) {
        this.host = host.toLowerCase();
        return this;
    }

    public UrlBuilder atPort(int port) {
        this.port = Optional.of(String.valueOf(port));
        return this;
    }

    public UrlBuilder using(HttpProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    public UrlBuilder using(String protocol) {
        this.protocol = HttpProtocol.valueOf(protocol);
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
