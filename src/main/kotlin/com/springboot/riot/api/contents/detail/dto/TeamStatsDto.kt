package com.springboot.riot.api.contents.detail.dto

data class TeamStatsDto(
    var gameId: Long = 0L,
    var teamId: Int = 0,
    var win: String? = null,
    var firstBlood: Boolean = false,
    var firstTower: Boolean = false,
    var firstInhibitor: Boolean = false,
    var firstBaron: Boolean = false,
    var firstDragon: Boolean = false,
    var firstRiftHerald: Boolean = false,
    var towerKills: Boolean = false,
    var inhibitorKills: Boolean = false,
    var baronKills: Boolean = false,
    var vilemawKills: Boolean = false,
    var riftHeraldKills: Boolean = false,
    var dominionVictoryScore: Boolean = false,
)
