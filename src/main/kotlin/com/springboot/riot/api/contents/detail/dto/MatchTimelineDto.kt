package com.springboot.riot.api.contents.detail.dto

data class MatchTimelineDto (
    var itemEvent: List<TimelineEventItemDto>? = null,
    var skillEvent: List<TimelineEventSkillDto>? = null,
)