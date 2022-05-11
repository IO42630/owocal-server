package com.olexyn.owocal.service;

import com.olexyn.owocal.database.model.EventDto;

public interface EventService {

    EventDto get(Long id);

    Long save(EventDto event);

}
