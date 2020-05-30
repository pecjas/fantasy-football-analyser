package ffb.analyzer.core.persistence;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * Configures a {@link DataSource} to use with Postgresql.
 */
public class PostgresqlDataSourceBuilder {

    private static PostgresqlDataSourceBuilder connector = null;

    private final DataSource dataSource;

    private PostgresqlDataSourceBuilder() throws IOException {
        this.dataSource = configureDataSource();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    private DataSource configureDataSource() throws IOException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        ResourceBackedDataSourceSettings dataSourceSettings = new ResourceBackedDataSourceSettings().load();

        dataSource.setServerNames(new String[] {dataSourceSettings.host});
        dataSource.setPortNumbers(new int[] {dataSourceSettings.port});

        dataSource.setDatabaseName(dataSourceSettings.databaseName);
        dataSource.setCurrentSchema(dataSourceSettings.schema);

        dataSource.setUser(dataSourceSettings.userName);
        dataSource.setPassword(dataSourceSettings.password);

        return dataSource;
    }

    public static PostgresqlDataSourceBuilder getInstance() throws IOException {
        if (connector == null) {
            connector = new PostgresqlDataSourceBuilder();
        }

        return connector;
    }

    private static class ResourceBackedDataSourceSettings {
        private static final String PROPERTY_FILE_NAME = "connection.properties";
        private static final String HOST_PROPERTY_FIELD = "DB_HOST";
        private static final String PORT_PROPERTY_FIELD = "DB_PORT";
        private static final String DB_NAME_PROPERTY_FIELD = "DB_NAME";
        private static final String USER_NAME_PROPERTY_FIELD = "DB_USER";
        private static final String PASSWORD_PROPERTY_FIELD = "DB_PASSWORD";
        private static final String SCHEMA_PROPERTY_FIELD = "DB_SCHEMA";

        private String host;
        private int port;
        private String databaseName;
        private String userName;
        private String password;
        private String schema;

        public ResourceBackedDataSourceSettings load() throws IOException {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME));

            storeDataSourceProperties(properties);
            return this;
        }

        private void storeDataSourceProperties(Properties properties) {
            host = getPropertyValue(properties, HOST_PROPERTY_FIELD);
            port = Integer.parseInt(getPropertyValue(properties, PORT_PROPERTY_FIELD));
            databaseName = getPropertyValue(properties, DB_NAME_PROPERTY_FIELD);
            userName = getPropertyValue(properties, USER_NAME_PROPERTY_FIELD);
            password = getPropertyValue(properties, PASSWORD_PROPERTY_FIELD);
            schema = getPropertyValue(properties, SCHEMA_PROPERTY_FIELD);
        }

        private String getPropertyValue(Properties props, String fieldName) {
            return props.getProperty(fieldName);
        }

    }
}
