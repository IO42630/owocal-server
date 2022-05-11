package com.olexyn.owocal.database.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointInTime {

    private Set<PointInTime> timeGrid = new HashSet<>();

    List<EventDto> endingEvents = new ArrayList<>();
    List<EventDto> startingEvents = new ArrayList<>();


    PointInTime(){
        this.timeGrid.add(this);
    }

}
