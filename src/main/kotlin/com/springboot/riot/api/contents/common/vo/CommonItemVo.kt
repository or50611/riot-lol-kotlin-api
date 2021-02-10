package com.springboot.riot.api.contents.common.vo

data class CommonItemVo(
    val iKey: Int = 0,
    val iName: String? = null,
    val description: String? = null,
    val colloq: String? = null,
    val plaintext: String? = null,
    val base: Int = 0,
    val purchasable: Int = 0,
    val total: Int = 0,
    val sell: Int = 0,
    val iFull: String? = null
)
