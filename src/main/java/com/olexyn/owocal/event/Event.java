package com.olexyn.owocal.event;

import com.olexyn.owocal.time.PointInTime;

import java.io.Serializable;
import java.util.*;

public class Event implements Serializable {

    private static Long ID_Factory =0L;
    private final Long id;

    private PointInTime startTime;
    private PointInTime endTime;
    private String summary;
    private String description = "Missing event description.";
    private boolean optional = false;
    private Set<Event> supplierEvents = new HashSet<>();
    private Set<Event> customerEvents = new HashSet<>();


    Event(PointInTime startTime, PointInTime endTime, String summary){

        this.id = ID_Factory++;

        this.startTime = startTime;
        this.endTime = endTime;
        this.summary = summary;
    }




    public void setStartTime(PointInTime startTime){
        this.startTime = startTime;
    }




    public void setEndTime(PointInTime endTime){
        this.endTime = endTime;
    }




    public  void addSupplierEvent(Event event){
        supplierEvents.add(event);
        event.addCustomerEvent(this);
    }

    public  void addCustomerEvent(Event event){
        customerEvents.add(event);
        event.addSupplierEvent(this);
    }

    public void removeSupplierEvent(Event event){
        supplierEvents.remove(event);
        event.removeCustomerEvent(this);
    }

    public  void removeCustomerEvent(Event event){
        customerEvents.remove(event);
        event.removeSupplierEvent(this);
    }
}



