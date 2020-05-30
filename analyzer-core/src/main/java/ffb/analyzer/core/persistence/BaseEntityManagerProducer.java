package ffb.analyzer.core.persistence;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Base implementation of {@link LocalEntityManagerProducer}.
 */
public abstract class BaseEntityManagerProducer implements LocalEntityManagerProducer {

    private JpaVendorAdapterSettings jpaVendorAdapterSettings;
    private String[] entityPackages;

    public BaseEntityManagerProducer(JpaVendorAdapterSettings jpaVendorAdapterSettings, String[] entityPackage) {
        this.jpaVendorAdapterSettings = jpaVendorAdapterSettings;
        this.entityPackages = entityPackage;
    }

    public JpaVendorAdapterSettings getJpaVendorAdapterSettings() {
        return jpaVendorAdapterSettings;
    }

    public void setJpaVendorAdapterSettings(JpaVendorAdapterSettings jpaVendorAdapterSettings) {
        this.jpaVendorAdapterSettings = jpaVendorAdapterSettings;
    }

    @Override
    public String[] getEntityClassPackages() {
        return entityPackages;
    }

    public void setEntityClassPackages(String[] entityPackage) {
        this.entityPackages = entityPackage;
    }

    protected EntityManagerFactory createEntityManagerFactory() throws IOException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan(getEntityClassPackages());
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());

        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean.getObject();
    }

    @Override
    public EntityManager createEntityManager() {
        try {
            return createEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            return null;
        }
    }
}
