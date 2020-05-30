package ffb.analyzer.core.database;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaVendorAdapter;

public interface LocalEntityManagerProducer {

    EntityManager createEntityManager() throws IOException;

    DataSource getDataSource() throws IOException;

    String[] getEntityClassPackages();

    JpaVendorAdapter getJpaVendorAdapter();
}
