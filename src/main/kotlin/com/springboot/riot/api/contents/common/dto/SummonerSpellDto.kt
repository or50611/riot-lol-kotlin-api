package com.springboot.riot.api.contents.common.dto

data class SummonerSpellDto (
    var key: Int = 0,
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var imageUrl: String? = null
)