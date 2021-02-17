package com.springboot.riot.api.contents.common.service

import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto

interface CommonService {

    fun commonMatchList(params: MatchSearchDto?): ListDto?

}