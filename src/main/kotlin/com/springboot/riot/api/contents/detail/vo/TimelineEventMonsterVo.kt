package com.springboot.riot.api.contents.detail.vo

data class TimelineEventMonsterVo(
    val gameId: Long = 0L,
    val parentTimestamp: Int = 0,
    val timestamp: Int = 0,
    val eType: String? = null,
    val killerId: Int = 0,
    val monsterType: String? = null,
    val monsterSubType: String? = null,
    val x: Int = 0,
    val y: Int = 0
)
