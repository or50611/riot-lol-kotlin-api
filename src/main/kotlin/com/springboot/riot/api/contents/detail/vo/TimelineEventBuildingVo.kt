package com.springboot.riot.api.contents.detail.vo

data class TimelineEventBuildingVo(
    val gameId: Long = 0L,
    val parentTimestamp: Int = 0,
    val timestamp: Int = 0,
    val eType: String? = null,
    val killerId: Int = 0,
    val teamId: Int = 0,
    val buildingType: String? = null,
    val towerType: String? = null,
    val x: Int = 0,
    val y: Int = 0
)
