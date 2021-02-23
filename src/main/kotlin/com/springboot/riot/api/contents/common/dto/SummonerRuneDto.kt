package com.springboot.riot.api.contents.common.dto

data class SummonerRuneDto(
    var id: Int = 0,
    var parentId: Int = 0,
    var key: String? = null,
    var imageUrl: String? = null,
    var name: String? = null,
    var shortDesc: String? = null,
    var longDesc: String? = null,
)
