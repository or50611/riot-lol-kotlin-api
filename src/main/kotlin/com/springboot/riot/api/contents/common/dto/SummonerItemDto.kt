package com.springboot.riot.api.contents.common.dto

data class SummonerItemDto (
    var key: Int = 0,
    var name: String? = null,
    var description: String? = null,
    var colloq: String? = null,
    var plaintext: String? = null,
    var base: Int = 0,
    var purchasable: Int = 0,
    var total: Int = 0,
    var sell: Int = 0,
    var imageUrl: String? = null
)