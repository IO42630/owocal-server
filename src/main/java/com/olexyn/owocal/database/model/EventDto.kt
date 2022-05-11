package com.olexyn.owocal.database.model

public data class EventDto(
    var id: Number,
    var startTime: PointInTime,
    var endTime: PointInTime,
    var summary: String,
    var description: String,
    var supplierEvents: Set<Long>,
    var consumerEvents: Set<Long>,
    var priority: String,
    var tags: Set<String>
)

