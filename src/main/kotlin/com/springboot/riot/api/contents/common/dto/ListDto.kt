package com.springboot.riot.api.contents.common.dto

data class ListDto (
    var nextCursor: Long = 0L,
    var list: Any? = null
)