package com.springboot.riot.api.contents.detail.dto

data class TimelineEventSkillDto(
    var participantId: Int = 0,
    var parentTimestamp: Int = 0,
    var timestamp: Int = 0,
    var type: String? = null,
    var skillSlot: Int = 0,
    var levelUpType: String? = null
)
