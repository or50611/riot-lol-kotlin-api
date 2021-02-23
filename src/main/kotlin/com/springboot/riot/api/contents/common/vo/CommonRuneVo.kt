package com.springboot.riot.api.contents.common.vo

data class CommonRuneVo (
    val id: Int = 0,
    val parentId: Int = 0,
    val rKey: String? = null,
    val fileNm: String? = null,
    val icon: String? = null,
    val rName: String? = null,
    val shortDesc: String? = null,
    val longDesc: String? = null,
)
