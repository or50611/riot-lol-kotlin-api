package com.springboot.riot.web.service

import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto

interface WebService {

    fun webCommonMatchList(params: MatchSearchDto?): ListDto?

}