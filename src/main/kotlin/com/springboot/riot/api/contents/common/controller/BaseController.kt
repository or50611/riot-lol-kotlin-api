package com.springboot.riot.api.contents.common.controller

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import org.springframework.web.bind.ServletRequestUtils
import javax.servlet.http.HttpServletRequest

class BaseController {

    fun getSearch(request: HttpServletRequest): MatchSearchDto {
        var search: MatchSearchDto = MatchSearchDto()

        search.listSize = ServletRequestUtils.getIntParameter(request,"listSize",20)
        search.nextCursor = ServletRequestUtils.getLongParameter(request,"nextCursor",0)

        return search
    }

}