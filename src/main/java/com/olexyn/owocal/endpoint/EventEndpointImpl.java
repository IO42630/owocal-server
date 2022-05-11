package com.olexyn.owocal.endpoint;

import com.olexyn.owocal.database.model.EventDto;
import com.olexyn.owocal.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventEndpointImpl implements EventEndpoint {

    @Autowired
    EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> get(@PathVariable("id") Long id) {
        var event = eventService.get(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody EventDto event) {
        var id = eventService.save(event);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
