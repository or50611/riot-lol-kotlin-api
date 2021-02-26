package com.springboot.riot.api.contents.detail.vo

data class MatchTeamBanVo(
    val gameId: Long = 0L,
    val teamId: Int = 0,
    val championId: Int = 0,
    val pickTurn: Int = 0,
)
