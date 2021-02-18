package com.springboot.riot.api.contents.common.vo

data class CommonMatchVo(

    val accountId: String? = null,
    val activityNm: String? = null,
    val activityKorNm: String? = null,
    val classification: String? = null,
    val classificationNm: String? = null,
    val teamSeq: Int = 0,
    val teamNm: String? = null,
    val teamKorNm: String? = null,
    val mostLane: Int = 0,
    val userName: String? = null,
    val gameId: Long = 0L,
    val platformId: String? = null,
    val champion: Int = 0,
    val queue: Int = 0,
    val season: Int = 0,
    val timeStamp: Long = 0L,
    val lane: String? = null,
    val enemyChampion: Int = 0,
    val gameDuration: Int = 0,
    val spell1Id: Int = 0,
    val spell2Id: Int = 0,
    val teamId: Int = 0,
    val participantId: Int = 0,
    val win: Boolean = false,
    val kills: Int = 0,
    val deaths: Int = 0,
    val assists: Int = 0,
    val item0: Int = 0,
    val item1: Int = 0,
    val item2: Int = 0,
    val item3: Int = 0,
    val item4: Int = 0,
    val item5: Int = 0,
    val item6: Int = 0,
    val nextCursor: Long = 0L

)
