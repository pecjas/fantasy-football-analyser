package ffb.analyzer.sql;

import ffb.analyzer.sql.connection.DatabaseConnector;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DatabaseConnectorTests {

    @Test
    public void testDatabaseConnection() {
        Connection connection = null;
        DatabaseConnector connector = null;
        try {
            connector = new DatabaseConnector();
            connection = connector.getConnection();

            Assert.assertNotNull(connection);

            connection.close();
        }
        catch (Exception e) {
            Assert.fail();
        }
    }
}
