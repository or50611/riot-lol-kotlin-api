package com.springboot.riot.api.contents.feed.controller

import com.google.gson.Gson
import com.springboot.riot.api.contents.common.dto.DataDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.feed.service.FeedService
import com.springboot.riot.api.exception.ErrorHandler
import com.springboot.riot.api.exception.dto.ErrorResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.NumberFormatException
import javax.xml.crypto.Data

@RestController
@RequestMapping("/feed")
class FeedController {
    @Autowired
    lateinit var commonService: CommonService

    @Autowired
    lateinit var feedService: FeedService

    @RequestMapping(value =  ["/list"], method = [RequestMethod.POST])
    fun feedMatchList(@RequestBody params: MatchSearchDto?): ResponseEntity<Any> {

        println("--------------------params listSize : "+params?.listSize)

        val gson = Gson()
        var data: DataDto? = DataDto()
        var result: String? = null

        val list = commonService.commonMatchList(params)

        data?.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }
}