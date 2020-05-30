package ffb.analyzer.core.persistence;

/**
 * Simple representation of {@link org.springframework.orm.jpa.JpaVendorAdapter} settings.
 */
public class JpaVendorAdapterSettings {
    private final boolean showSql;
    private final boolean shouldGenerateDdl;

    public JpaVendorAdapterSettings(boolean showSql, boolean shouldGenerateDdl) {
        this.showSql = showSql;
        this.shouldGenerateDdl = shouldGenerateDdl;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public boolean isShouldGenerateDdl() {
        return shouldGenerateDdl;
    }
}
