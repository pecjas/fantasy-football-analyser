package ffb.analyzer.sql.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnector implements AutoCloseable {

    private static final String PROPERTY_FILE_NAME = "connection.properties";
    private static final String HOST_PROPERTY_FIELD = "DB_HOST";
    private static final String PORT_PROPERTY_FIELD = "DB_PORT";
    private static final String DB_NAME_PROPERTY_FIELD = "DB_NAME";
    private static final String USER_NAME_PROPERTY_FIELD = "DB_USER";
    private static final String PASSWORD_PROPERTY_FIELD = "DB_PASSWORD";

    private Connection connection;
    private final MysqlDataSource dataSource;

    public DatabaseConnector() throws IOException, SQLException {
        this.dataSource = getDataSource();
    }

    private MysqlDataSource getDataSource() throws IOException, SQLException
    {
        MysqlDataSource dataSource = new MysqlDataSource();
        configureDataSource(dataSource);

        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = dataSource.getConnection();
        }

        return connection;
    }

    public void configureDataSource(MysqlDataSource dataSource) throws IOException, SQLException {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME));

        dataSource.setServerName(getPropertyValue(props, HOST_PROPERTY_FIELD));
        dataSource.setPort(Integer.parseInt(getPropertyValue(props, PORT_PROPERTY_FIELD)));
        dataSource.setDatabaseName(getPropertyValue(props, DB_NAME_PROPERTY_FIELD));

        dataSource.setUser(getPropertyValue(props, USER_NAME_PROPERTY_FIELD));
        dataSource.setPassword(getPropertyValue(props, PASSWORD_PROPERTY_FIELD));

        dataSource.setServerTimezone(ZoneId.systemDefault().toString());
    }

    private String getPropertyValue(Properties props, String fieldName) {
        return props.getProperty(fieldName);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
