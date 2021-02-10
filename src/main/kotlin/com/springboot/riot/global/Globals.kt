package com.springboot.riot.global

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

object Globals {

    fun getDomain(): String {
        val sra: ServletRequestAttributes = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
        val request = sra.request
        return request.scheme+"://"+request.serverName+":"+request.serverPort
    }

}
