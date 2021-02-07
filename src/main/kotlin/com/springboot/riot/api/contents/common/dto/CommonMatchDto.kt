package com.springboot.riot.api.contents.common.dto

data class CommonMatchDto(
    val accountId: String? = null,
    val gameId: Long = 0L,
    val platformId: String? = null,
    val champion: Int = 0,
    val queue: Int = 0,
    val season: Int = 0,
    val timeStamp: Long = 0L,
    val lane: String? = null,
    val enemyChampion: Int = 0,

)
