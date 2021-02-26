package com.springboot.riot.api.contents.detail.vo

data class MatchBasicVo(
    val gameId: Long = 0L,
    val platformId: String? = null,
    val gameCreation: Long = 0L,
    val gameDuration: Long = 0L,
    val queueId: Int = 0,
    val mapId: Int = 0,
    val seasonId: Int = 0,
    val gameVersion: String? = null,
    val gameMode: String? = null,
    val gameType: String? = null,
)
