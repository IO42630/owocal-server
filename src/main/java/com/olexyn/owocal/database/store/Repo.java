package com.olexyn.owocal.database.store;


import com.olexyn.owocal.database.model.AbstractEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class Repo<E extends AbstractEntity> {

    @PersistenceContext
    protected static final EntityManager em;

    static {
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metaData = new MetadataSources(sr).getMetadataBuilder().build();
        em = metaData.getSessionFactoryBuilder().build().createEntityManager();
    }

    protected final JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    public abstract E get(Long key);

    public abstract List<E> getAll();

    public abstract E save(E entity);

    public abstract void update(E entity);

    protected RecordState unknown(E entity) {
        if (entity.getId() == null || get(entity.getId()) == null) {
            return RecordState.UNKNOWN;
        }
        return RecordState.KNOWN;
    }

    protected void savePersist(E entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
    }

}
