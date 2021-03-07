package com.springboot.riot.api.contents.detail.dto

data class TimelineEventItemDto(
    var participantId: Int = 0,
    var parentTimestamp: Int = 0,
    var timestamp: Int = 0,
    var type: String? = null,
    var itemId: Int = 0,
    var afterId: Int = 0,
    var beforeId: Int = 0
)
