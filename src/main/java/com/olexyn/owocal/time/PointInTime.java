package com.olexyn.owocal.time;

import com.olexyn.owocal.event.Event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointInTime {

    private Set<PointInTime> timeGrid = new HashSet<>();

    List<Event> endingEvents = new ArrayList<>();
    List<Event> startingEvents = new ArrayList<>();


    PointInTime(){
        this.timeGrid.add(this);
    }

}
