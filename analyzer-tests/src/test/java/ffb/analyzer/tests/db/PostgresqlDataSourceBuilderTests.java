package ffb.analyzer.tests.db;

import ffb.analyzer.core.database.PostgresqlDataSourceBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import javax.sql.DataSource;

public class PostgresqlDataSourceBuilderTests {

    @Test
    public void testDatabaseConnection() {
        try {
            DataSource dataSource = PostgresqlDataSourceBuilder.getInstance().getDataSource();
            Connection connection = dataSource.getConnection();

            Assert.assertNotNull(connection);
            Assert.assertFalse(connection.isClosed());

            connection.close();
        }

        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
