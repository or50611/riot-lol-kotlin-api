package com.springboot.riot.api.contents.detail.vo

data class TimelineEventItemVo(
    val seq: Int = 0,
    val gameId: Int = 0,
    val parentTimestamp: Int = 0,
    val timestamp: Int = 0,
    val eType: String? = null,
    val participantId: Int = 0,
    val itemId: Int = 0,
    val afterId: Int = 0,
    val beforeId: Int = 0
)
