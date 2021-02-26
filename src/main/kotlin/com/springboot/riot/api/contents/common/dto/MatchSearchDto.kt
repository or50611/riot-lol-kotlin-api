package com.springboot.riot.api.contents.common.dto

class MatchSearchDto {
    var gameId: Long = 0L
    var accountId: String? = null
    var nextCursor: Long = 0L
    var listSize: Int = 0
}
