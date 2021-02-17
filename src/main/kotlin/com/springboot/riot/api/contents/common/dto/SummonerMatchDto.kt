package com.springboot.riot.api.contents.common.dto


data class SummonerMatchDto (
    var accountId: String? = null,
    var activityNm: String? = null,
    var activityKorNm: String? = null,
    var classification: Int = 0,
    var classificationNm: Int = 0,
    var teamSeq: Int = 0,
    var teamKorNm: String? = null,
    var mostLane: Int = 0,
    var userName: String? = null,
    var gameId: Long = 0L,
    var platformId: String? = null,
    var champion: SummonerChampionDto? = null,
    var queue: Int = 0,
    var queueNm: String? = null,
    var season: Int = 0,
    var timeStamp: Long = 0L,
    var lane: String? = null,
    var gameDuration: Int = 0,
    var enemyChampion: SummonerChampionDto? = null,
    var spell1: SummonerSpellDto? = null,
    var spell2: SummonerSpellDto? = null,
    var teamId: Int = 0,
    var teamNm: String? = null,
    var participantId: Int = 0,
    var win: Boolean = false,
    var kills: Int = 0,
    var deaths: Int = 0,
    var assists: Int = 0,
    var item0: SummonerItemDto? = null,
    var item1: SummonerItemDto? = null,
    var item2: SummonerItemDto? = null,
    var item3: SummonerItemDto? = null,
    var item4: SummonerItemDto? = null,
    var item5: SummonerItemDto? = null,
    var item6: SummonerItemDto? = null

)

