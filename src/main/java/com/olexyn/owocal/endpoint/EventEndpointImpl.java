package com.olexyn.owocal.endpoint;

import com.olexyn.owocal.database.model.EventDto;
import com.olexyn.owocal.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventEndpointImpl {

    @Autowired
    EventService eventService;

    @GetMapping("/event/{id}")
    public ResponseEntity<EventDto> get(@PathVariable("id") Long id) {
        var event = eventService.get(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}
