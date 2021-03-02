package com.springboot.riot.api.contents.common.dto

data class ChampionSpellDto (
    var key: Int = 0,
    var skillSlot: Int = 0,
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var tooltip: String? = null,
    var maxRank: Int = 0,
    var cooldownBurn: String? = null,
    var costBurn: String? = null,
    var costYype: String? = null,
    var maxAmmo: String? = null,
    var rangeBurn: String? = null,
    var resource: String? = null,
    var imageUrl: String? = null,
)