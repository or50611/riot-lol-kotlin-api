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

        var map1 = mutableMapOf<String,Any>()


        var map2 = mutableMapOf<String,Any>()
        map2["gameId"] = 123456
        var list1 = mutableListOf<Map<String,Any>>()
        var map3 = mutableMapOf<String,Any>()
        map3["팀아이디"] = "100"
        map3["승리여부"] = true
        list1.add(map3)
        map3 = mutableMapOf<String,Any>()
        map3["팀아이디"] = "200"
        map3["승리여부"] = false
        list1.add(map3)
        map2["team"] = list1

        var list2 = mutableListOf<Map<String,Any>>()
        var map4 = mutableMapOf<String,Any>()
        map4["팀아이디"] = 100
        map4["참가자번호"] = 1
        map4["라인"] = ""
        map4["아이템1"] = ""
        map4["아이템2"] = ""
        map4["아이템3"] = ""
        list2.add(map4)

        map4 = mutableMapOf<String,Any>()
        map4["팀아이디"] = 100
        map4["참가자번호"] = 2
        map4["라인"] = ""
        map4["아이템1"] = ""
        map4["아이템2"] = ""
        map4["아이템3"] = ""
        list2.add(map4)

        map4 = mutableMapOf<String,Any>()
        map4["팀아이디"] = 200
        map4["참가자번호"] = 3
        map4["라인"] = ""
        map4["아이템1"] = ""
        map4["아이템2"] = ""
        map4["아이템3"] = ""
        list2.add(map4)

        map4 = mutableMapOf<String,Any>()
        map4["팀아이디"] = 200
        map4["참가자번호"] = 4
        map4["라인"] = ""
        map4["아이템1"] = ""
        map4["아이템2"] = ""
        map4["아이템3"] = ""
        list2.add(map4)

        map2["player"] = list2

        map1["data"] = map2

        return ResponseEntity(map1, HttpStatus.OK)
    }


}