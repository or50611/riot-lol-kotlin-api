package com.springboot.riot.api.contents.common.vo

data class CommonChampionSpellVo (

    val cKey: Int = 0,
    val skillSlot: Int = 0,
    val id: String? = null,
    val sName: String? = null,
    val description: String? = null,
    val tooltip: String? = null,
    val maxRank: Int = 0,
    val cooldownBurn: String? = null,
    val costBurn: String? = null,
    val costYype: String? = null,
    val maxAmmo: String? = null,
    val rangeBurn: String? = null,
    val resource: String? = null,
    val sFull: String? = null

)

