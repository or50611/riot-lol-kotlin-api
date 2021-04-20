package com.springboot.riot.api.contents.detail.dto

data class TimelineEventMonsterDto(
    var killerId: Int = 0,
    var parentTimestamp: Int = 0,
    var timestamp: Int = 0,
    var type: String? = null,
    var monsterType: String? = null,
    var monsterSubType: String? = null,
    var x: Int = 0,
    var y: Int = 0
)
