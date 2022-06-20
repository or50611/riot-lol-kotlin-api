package com.springboot.riot.web

import com.springboot.riot.api.contents.common.controller.BaseController
import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest


@Controller
class WebMainController {

    @Autowired
    lateinit var commonService: CommonService

    @Autowired
    lateinit var commonMapper: CommonMapper

    @RequestMapping(value=["/"])
    fun index (request: HttpServletRequest, m: Model):String {
        val search = BaseController()
        request.setAttribute("listSize", 5);
        val params: MatchSearchDto = search.getSearch(request)

        val list = commonService.commonMatchList(params)

        val matchList: List<CommonMatchVo> = commonMapper.selectCommonMatchList(params)
        m.addAttribute("list", list);
        m.addAttribute("matchList", matchList)
        return "index"
    }


    @RequestMapping(value=["/lol"])
    fun indexSub ():String {
        println("-------test")
        return "/lol/index"
    }

}