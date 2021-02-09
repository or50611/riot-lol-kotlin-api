package com.springboot.riot.api.contents.common.dto

data class SummonerMatchDto (
    val accountId: String? = null,
    val gameId: Long = 0L,
    val platformId: String? = null,
    val champion: SummonerChampionDto? = null,
    val queue: Int = 0,
    val season: Int = 0,
    val timeStamp: Long = 0L,
    val lane: String? = null,
    val enemy_champion: SummonerChampionDto? = null,
    val spell1: SummonerSpellDto? = null,
    val spell2: SummonerSpellDto? = null,
    val teamId: Int = 0,
    val teamNm: Int = 0,
    val participantId: Int = 0,
    val win: Int = 0,
    val kills: Int = 0,
    val deaths: Int = 0,
    val assists: Int = 0,
    val item0: SummonerItemDto? = null,
    val item1: SummonerItemDto? = null,
    val item2: SummonerItemDto? = null,
    val item3: SummonerItemDto? = null,
    val item4: SummonerItemDto? = null,
    val item5: SummonerItemDto? = null,
    val item6: SummonerItemDto? = null
)

