package ffb.analyzer.tests.db;

import ffb.analyzer.core.db.DatabaseConnector;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DatabaseConnectorTests {

    @Test
    public void testDatabaseConnection() {
        Connection connection = null;
        DatabaseConnector connector = null;
        try {
            connector = DatabaseConnector.getInstance();
            connection = connector.getConnection();

            Assert.assertNotNull(connection);

            connection.close();
        }
        catch (Exception e) {
            Assert.fail();
        }
    }
}
