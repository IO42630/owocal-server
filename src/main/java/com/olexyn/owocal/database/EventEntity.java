package com.olexyn.owocal.database;


import com.olexyn.owocal.event.Event;
import com.olexyn.owocal.time.PointInTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "EVENTS", uniqueConstraints = {@UniqueConstraint(columnNames = "EVENT_ID")})
public class EventEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID", unique = true, nullable = false)
    private Integer eventId;

    @Transient
    @Column(name = "START_TIME")
    private PointInTime startTime;

    @Transient
    @Column(name = "END_TIME")
    private PointInTime endTime;

    @Column(name = "SUMMARY", nullable = false)
    private String summary;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    @Column(name = "SUPPLIER_EVENTS")
    private final Set<Event> supplierEvents = new HashSet<>();

    @Transient
    @Column(name = "CUSTOMER_EVENTS")
    private final Set<Event> customerEvents = new HashSet<>();

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "EFFICIENCY")
    private String efficiency;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "OPPORTUNITY_COST")
    private String opportunityCost;

    @Transient
    @Column(name = "TAGS")
    private final Set<String> tags = new HashSet<>();

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setStartTime(PointInTime startTime) {
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Event> getSupplierEvents() {
        return supplierEvents;
    }

    public Set<Event> getCustomerEvents() {
        return customerEvents;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getOpportunityCost() {
        return opportunityCost;
    }

    public void setOpportunityCost(String opportunityCost) {
        this.opportunityCost = opportunityCost;
    }

    public Set<String> getTags() {
        return tags;
    }

    public PointInTime getEndTime() {
        return endTime;
    }

    public void setEndTime(PointInTime endTime) {
        this.endTime = endTime;
    }

    public PointInTime getStartTime() {
        return startTime;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
}
