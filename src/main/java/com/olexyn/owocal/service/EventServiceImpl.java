package com.olexyn.owocal.service;

import com.olexyn.owocal.database.model.EventDto;
import com.olexyn.owocal.database.model.EventEntity;
import com.olexyn.owocal.database.store.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepo eventRepo;

    @Override
    public EventDto get(Long id) {
        var event = eventRepo.get(id);
        return map(event);
    }

    private EventDto map(EventEntity event) {
        return new EventDto(
            event.getId(),
            event.getStartTime(),
            event.getEndTime(),
            event.getSummary(),
            event.getDescription(),
            event.getSupplierEvents(),
            event.getCustomerEvents(),
            event.getPriority(),
            event.getTags()
        );
    }

}
