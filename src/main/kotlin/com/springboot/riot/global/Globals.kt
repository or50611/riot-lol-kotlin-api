package com.springboot.riot.global

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

object Globals {

    const val FILE_CHAMPION_PATH = "/riotImage/champion/"
    const val FILE_ITEM_PATH = "/riotImage/item/"
    const val FILE_SUMMONER_SPELL_PATH = "/riotImage/summoner_spell/"
    const val FILE_RUNE_PATH = "/riotImage/rune/"
    const val FILE_CHAMPION_SPELL_PATH = "/riotImage/spells/"
    const val FILE_RANKED_POSITION_PATH = "/riotImage/ranked_positions/"

    fun getDomain(): String {
        val sra: ServletRequestAttributes = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
        val request = sra.request
        return request.scheme+"://"+request.serverName+":"+request.serverPort
    }

    fun queue(key: Int): String? {
        var str: String? = null
        when(key) {
            420 -> str = "솔랭"
        }

        return str
    }
}
