package ffb.analyzer.beans.persistence;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ffb.analyzer.core.persistence.PostgresqlEntityManagerProducer;

/**
 * Local implementation of {@link EntityManager} that delegates responsibilities to another
 * concrete entity manager.
 */
@Component
@Scope("prototype")
public class DelegatingEntityManager implements EntityManager{
    private static final String[] ENTITY_PACKAGES = {
        "ffb.analyzer.models"
    };

    private final EntityManager delegateEntityManager;

    public DelegatingEntityManager() {
        delegateEntityManager = new PostgresqlEntityManagerProducer(ENTITY_PACKAGES).createEntityManager();
    }

    public DelegatingEntityManager(EntityManager delegate) {
        this.delegateEntityManager = delegate;
    }

    @Override
    public void persist(Object o) {
        delegateEntityManager.persist(o);
    }

    @Override
    public <T> T merge(T t) {
        return delegateEntityManager.merge(t);
    }

    @Override
    public void remove(Object o) {
        delegateEntityManager.remove(o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o) {
        return delegateEntityManager.find(aClass, o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
        return delegateEntityManager.find(aClass, o, map);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
        return delegateEntityManager.find(aClass, o, lockModeType);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
        return delegateEntityManager.find(aClass, o, lockModeType, map);
    }

    @Override
    public <T> T getReference(Class<T> aClass, Object o) {
        return delegateEntityManager.getReference(aClass, o);
    }

    @Override
    public void flush() {
        delegateEntityManager.flush();
    }

    @Override
    public void setFlushMode(FlushModeType flushModeType) {
        delegateEntityManager.setFlushMode(flushModeType);
    }

    @Override
    public FlushModeType getFlushMode() {
        return delegateEntityManager.getFlushMode();
    }

    @Override
    public void lock(Object o, LockModeType lockModeType) {
        delegateEntityManager.lock(o, lockModeType);
    }

    @Override
    public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {
        delegateEntityManager.lock(o, lockModeType, map);
    }

    @Override
    public void refresh(Object o) {
        delegateEntityManager.refresh(o);
    }

    @Override
    public void refresh(Object o, Map<String, Object> map) {
        delegateEntityManager.refresh(o, map);
    }

    @Override
    public void refresh(Object o, LockModeType lockModeType) {
        delegateEntityManager.refresh(o, lockModeType);
    }

    @Override
    public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {
        delegateEntityManager.refresh(o, lockModeType, map);
    }

    @Override
    public void clear() {
        delegateEntityManager.clear();
    }

    @Override
    public void detach(Object o) {
        delegateEntityManager.detach(o);
    }

    @Override
    public boolean contains(Object o) {
        return delegateEntityManager.contains(o);
    }

    @Override
    public LockModeType getLockMode(Object o) {
        return delegateEntityManager.getLockMode(o);
    }

    @Override
    public void setProperty(String s, Object o) {
        delegateEntityManager.setProperty(s, o);
    }

    @Override
    public Map<String, Object> getProperties() {
        return delegateEntityManager.getProperties();
    }

    @Override
    public Query createQuery(String s) {
        return delegateEntityManager.createQuery(s);
    }

    @Override
    public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return delegateEntityManager.createQuery(criteriaQuery);
    }

    @Override
    public Query createQuery(CriteriaUpdate criteriaUpdate) {
        return delegateEntityManager.createQuery(criteriaUpdate);
    }

    @Override
    public Query createQuery(CriteriaDelete criteriaDelete) {
        return delegateEntityManager.createQuery(criteriaDelete);
    }

    @Override
    public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
        return delegateEntityManager.createQuery(s, aClass);
    }

    @Override
    public Query createNamedQuery(String s) {
        return delegateEntityManager.createNativeQuery(s);
    }

    @Override
    public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
        return delegateEntityManager.createNamedQuery(s, aClass);
    }

    @Override
    public Query createNativeQuery(String s) {
        return delegateEntityManager.createNativeQuery(s);
    }

    @Override
    public Query createNativeQuery(String s, Class aClass) {
        return delegateEntityManager.createNativeQuery(s, aClass);
    }

    @Override
    public Query createNativeQuery(String s, String s1) {
        return delegateEntityManager.createNativeQuery(s, s1);
    }

    @Override
    public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
        return delegateEntityManager.createNamedStoredProcedureQuery(s);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s) {
        return delegateEntityManager.createStoredProcedureQuery(s);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
        return delegateEntityManager.createStoredProcedureQuery(s, classes);
    }

    @Override
    public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
        return delegateEntityManager.createStoredProcedureQuery(s, strings);
    }

    @Override
    public void joinTransaction() {
        delegateEntityManager.joinTransaction();
    }

    @Override
    public boolean isJoinedToTransaction() {
        return delegateEntityManager.isJoinedToTransaction();
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return delegateEntityManager.unwrap(aClass);
    }

    @Override
    public Object getDelegate() {
        return delegateEntityManager.getDelegate();
    }

    @Override
    public void close() {
        delegateEntityManager.close();
    }

    @Override
    public boolean isOpen() {
        return delegateEntityManager.isOpen();
    }

    @Override
    public EntityTransaction getTransaction() {
        return delegateEntityManager.getTransaction();
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return delegateEntityManager.getEntityManagerFactory();
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        return delegateEntityManager.getCriteriaBuilder();
    }

    @Override
    public Metamodel getMetamodel() {
        return delegateEntityManager.getMetamodel();
    }

    @Override
    public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
        return delegateEntityManager.createEntityGraph(aClass);
    }

    @Override
    public EntityGraph<?> createEntityGraph(String s) {
        return delegateEntityManager.createEntityGraph(s);
    }

    @Override
    public EntityGraph<?> getEntityGraph(String s) {
        return delegateEntityManager.getEntityGraph(s);
    }

    @Override
    public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
        return delegateEntityManager.getEntityGraphs(aClass);
    }
}
