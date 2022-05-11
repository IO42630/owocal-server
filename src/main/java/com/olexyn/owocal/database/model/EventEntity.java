package com.olexyn.owocal.database.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "EVENTS", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class EventEntity implements AbstractEntity , Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

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
    private final Set<Long> supplierEvents = new HashSet<>();

    @Transient
    @Column(name = "CUSTOMER_EVENTS")
    private final Set<Long> customerEvents = new HashSet<>();



    @Column(name = "PRIORITY")
    private String priority;


    @Transient
    @Column(name = "TAGS")
    private final Set<String> tags = new HashSet<>();

    public void setId(Long eventId) {
        this.id = eventId;
    }

    public Long getId() {
        return id;
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

    public Set<Long> getSupplierEvents() {
        return supplierEvents;
    }

    public Set<Long> getCustomerEvents() {
        return customerEvents;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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
