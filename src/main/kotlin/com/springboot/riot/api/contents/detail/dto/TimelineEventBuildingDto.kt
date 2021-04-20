package com.springboot.riot.api.contents.detail.dto

data class TimelineEventBuildingDto(
    val killerId: Int = 0,
    val parentTimestamp: Int = 0,
    val timestamp: Int = 0,
    val type: String? = null,
    val teamId: Int = 0,
    val buildingType: String? = null,
    val towerType: String? = null,
    val x: Int = 0,
    val y: Int = 0
)
