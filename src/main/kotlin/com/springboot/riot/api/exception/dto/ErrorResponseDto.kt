package com.springboot.riot.api.exception.dto

data class ErrorResponseDto (
    val result: String,
    val reason: String
)