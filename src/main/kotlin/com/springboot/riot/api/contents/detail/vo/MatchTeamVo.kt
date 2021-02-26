package com.springboot.riot.api.contents.detail.vo

data class MatchTeamVo (
    val gameId: Long = 0L,
    val teamId: Int = 0,
    val win: String? = null,
    val firstBlood: Boolean = false,
    val firstTower: Boolean = false,
    val firstInhibitor: Boolean = false,
    val firstBaron: Boolean = false,
    val firstDragon: Boolean = false,
    val firstRiftHerald: Boolean = false,
    val towerKills: Boolean = false,
    val inhibitorKills: Boolean = false,
    val baronKills: Boolean = false,
    val vilemawKills: Boolean = false,
    val riftHeraldKills: Boolean = false,
    val dominionVictoryScore: Boolean = false,
)