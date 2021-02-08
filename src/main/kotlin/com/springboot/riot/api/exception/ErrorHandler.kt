package com.springboot.riot.api.exception

import com.springboot.riot.api.exception.dto.ErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import java.lang.NumberFormatException
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(NumberFormatException::class)
    fun numberFormatException(): ResponseEntity<Any> {

        return ResponseEntity(ErrorResponseDto("numberFormatException", "타입이 잘못됨"), HttpStatus.BAD_REQUEST)

    }
}