package ffb.analyzer.core.web.request;

/**
 * Class representing a HTTP query parameter.
 */
public final class HttpQueryParameter {
    private String name;
    private String value;

    /**
     * Parameterized constructor.
     * @param name Name for the query parameter.
     * @param value Value for the query parameter.
     */
    public HttpQueryParameter(String name, String value) {
        this.name = name.toLowerCase();
        this.value = value.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormattedParameter() {
        return String.format("%s=%s", name, value);
    }
}
