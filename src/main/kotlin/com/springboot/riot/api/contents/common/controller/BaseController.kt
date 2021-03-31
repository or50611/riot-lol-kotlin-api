package com.springboot.riot.api.contents.common.controller

import com.google.gson.Gson
import com.springboot.riot.api.contents.common.dto.DataDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.service.CommonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.ServletRequestUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/lol/base")
class BaseController {

    @Autowired
    lateinit var commonService: CommonService

    fun getSearch(request: HttpServletRequest): MatchSearchDto {
        var search: MatchSearchDto = MatchSearchDto()

        search.listSize = ServletRequestUtils.getIntParameter(request,"listSize",20)
        search.nextCursor = ServletRequestUtils.getLongParameter(request,"nextCursor",0)
        search.gameId = ServletRequestUtils.getLongParameter(request,"gameId",0)
        search.accountId = ServletRequestUtils.getStringParameter(request,"accountId","")

        return search
    }

    @RequestMapping(value =  ["/v1/version"], method = [RequestMethod.GET])
    fun baseV1Version(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonVersionList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value =  ["/v1/item"], method = [RequestMethod.GET])
    fun baseV1Item(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonItemList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value =  ["/v1/champion"], method = [RequestMethod.GET])
    fun baseV1Champion(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonChampionList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value =  ["/v1/summonerSpell"], method = [RequestMethod.GET])
    fun baseV1SummonerSpell(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonSummonerSpellsList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value =  ["/v1/rune"], method = [RequestMethod.GET])
    fun baseV1Rune(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonRuneList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }

    @RequestMapping(value =  ["/v1/championSpell"], method = [RequestMethod.GET])
    fun baseV1Spell(request: HttpServletRequest): ResponseEntity<Any> {
        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonChampionSpellList()
        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }



}