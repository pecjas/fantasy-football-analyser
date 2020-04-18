package ffb.analyzer.core.web.request;

public final class HttpQueryParameter {
    private String name;
    private String value;

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
