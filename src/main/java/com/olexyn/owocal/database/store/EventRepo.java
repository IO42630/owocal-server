package com.olexyn.owocal.database.store;



import com.olexyn.owocal.database.model.EventEntity;
import com.olexyn.owocal.database.model.QEventEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class EventRepo extends Repo<EventEntity> {


    private final static QEventEntity qEntity = QEventEntity.eventEntity;

    @Override
    public EventEntity get(Long id) {
        if (id == null) { return null; }
        return queryFactory.selectFrom(qEntity).where(qEntity.id.eq(id)).fetchFirst();
    }

    @Override
    public List<EventEntity> getAll() {
        return queryFactory.selectFrom(qEntity).fetch();
    }


    @Override
    public EventEntity save(EventEntity entity) {
        switch (unknown(entity)) {
            case UNKNOWN:
                savePersist(entity);
                break;
            case KNOWN:
                update(entity);
                break;
            case DUPLICATE:
            default:
                break;
        }
        return get(entity.getId());
    }

    public void persistAll(Set<EventEntity> entitySet) {
        Set<EventEntity> entitiesToSave = new HashSet<>();
        Set<EventEntity> entitiesToUpdate = new HashSet<>();
        for (EventEntity entity : entitySet) {
            switch (unknown(entity)) {
                case UNKNOWN:
                    entitiesToSave.add(entity);
                    break;
                case KNOWN:
                    entitiesToUpdate.add(entity);
                    break;
                case DUPLICATE:
                default:
                    break;
            }
        }
        if (entitiesToSave.size() > 0) {
            saveAll(entitiesToSave);
        }
        if (entitiesToUpdate.size() > 0) {
            updateAll(entitiesToUpdate);
        }
    }

    private void saveAll(Set<EventEntity> entitySet) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (var entity : entitySet) {
            try {
                em.persist(entity);
            } catch (Exception e) {
                throw e;
            }
        }
        tx.commit();
    }

    @Override
    public void update(EventEntity entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        updateQuery(entity);
        tx.commit();
    }

    public void updateAll(Set<EventEntity> entitySet) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        for (var entity : entitySet) {
            updateQuery(entity);
        }
        tx.commit();
    }

    private void updateQuery(EventEntity entity) {
        if (entity.getId() == null) {
            return;
        }
        queryFactory.update(qEntity)
            .where(qEntity.id.eq(entity.getId()))
            .set(qEntity.summary, entity.getSummary())
            .set(qEntity.description, entity.getDescription())
            .execute(); // TODO complete.
    }

    @Override
    protected RecordState unknown(EventEntity entity) {
        if (entity.getId() != null && get(entity.getId()) != null) {
            return RecordState.KNOWN;
        }
        // TODO RecordState.DUPLICATE
        return RecordState.UNKNOWN;
    }

}
