package com.springboot.riot.api.contents.detail.vo

data class TimelineEventSkillVo(
    val gameId: Long = 0L,
    val parentTimestamp: Int = 0,
    val timestamp: Int = 0,
    val eType: String? = null,
    val participantId: Int = 0,
    val skillSlot: Int = 0,
    val levelUpType: String? = null
)
