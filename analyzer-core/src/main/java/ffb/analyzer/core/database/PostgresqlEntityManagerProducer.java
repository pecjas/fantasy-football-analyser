package ffb.analyzer.core.database;

import java.io.IOException;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class PostgresqlEntityManagerProducer extends BaseEntityManagerProducer {

    private static final String POSTGRESQL_DIALECT_PACKAGE = "org.hibernate.dialect.PostgreSQLDialect";

    private DataSource dataSource;
    private JpaVendorAdapter jpaVendorAdapter;

    public PostgresqlEntityManagerProducer(String[] entityPackages) {
        super(new JpaVendorAdapterSettings(true, true), entityPackages);
    }

    public PostgresqlEntityManagerProducer(JpaVendorAdapterSettings jpaVendorAdapterSettings,
                                           String[] entityPackages)
    {
        super(jpaVendorAdapterSettings, entityPackages);
    }

    @Override
    public DataSource getDataSource() throws IOException {
        if (dataSource == null) {
            dataSource = PostgresqlDataSourceBuilder.getInstance().getDataSource();
        }
        return dataSource;
    }

    @Override
    public JpaVendorAdapter getJpaVendorAdapter() {
        if (jpaVendorAdapter == null) {
            jpaVendorAdapter = configureJpaVendorAdapter();
        }

        return jpaVendorAdapter;
    }

    private JpaVendorAdapter configureJpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(getJpaVendorAdapterSettings().isShowSql());
        jpaVendorAdapter.setGenerateDdl(getJpaVendorAdapterSettings().isShouldGenerateDdl());
        jpaVendorAdapter.setDatabasePlatform(POSTGRESQL_DIALECT_PACKAGE);

        return jpaVendorAdapter;
    }
}
