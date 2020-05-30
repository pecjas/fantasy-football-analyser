package ffb.analyzer.core.persistence;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaVendorAdapter;

/**
 * Interface to create an entity manager.
 */
public interface LocalEntityManagerProducer {

    EntityManager createEntityManager() throws IOException;

    DataSource getDataSource() throws IOException;

    String[] getEntityClassPackages();

    JpaVendorAdapter getJpaVendorAdapter();
}
