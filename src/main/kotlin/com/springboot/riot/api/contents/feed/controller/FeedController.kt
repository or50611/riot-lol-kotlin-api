package com.springboot.riot.api.contents.feed.controller

import com.google.gson.Gson
import com.springboot.riot.api.contents.common.controller.BaseController
import com.springboot.riot.api.contents.common.dto.DataDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.feed.service.FeedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/feed")
class FeedController {
    @Autowired
    lateinit var commonService: CommonService

    @Autowired
    lateinit var feedService: FeedService

    @RequestMapping(value =  ["/list"], method = [RequestMethod.GET])
    fun feedMatchList(request: HttpServletRequest): ResponseEntity<Any> {
        val search = BaseController()
        val params: MatchSearchDto = search.getSearch(request)

        println("--------------------params listSize : "+params.listSize)

        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = commonService.commonMatchList(params)

        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }
}