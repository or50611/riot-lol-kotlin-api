package com.springboot.riot.api.contents.common.dto

data class SummonerChampionDto (
    var key: Int = 0,
    var id: String? = null,
    var name: String? = null,
    var title: String? = null,
    var blurb: String? = null,
    var parType: String? = null,
    var imageUrl: String? = null
)