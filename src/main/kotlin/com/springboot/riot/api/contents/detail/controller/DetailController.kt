package com.springboot.riot.api.contents.detail.controller

import com.google.gson.Gson
import com.springboot.riot.api.contents.common.controller.BaseController
import com.springboot.riot.api.contents.common.dto.DataDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.detail.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/lol/detail")
class DetailController {

    @Autowired
    lateinit var detailService: DetailService

    @RequestMapping(value =  ["/v1/match/team"], method = [RequestMethod.GET])
    fun matchV1Info(request: HttpServletRequest): ResponseEntity<Any> {
        val search = BaseController()
        val params: MatchSearchDto = search.getSearch(request)

        val gson = Gson()
        val data: DataDto = DataDto()
        var result: String? = null

        val list = detailService.selectMatchTeamInfo(params)

        data.data = list
        result = gson.toJson(data)

        return ResponseEntity(result, HttpStatus.OK)
    }


}