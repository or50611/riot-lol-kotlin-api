package com.springboot.riot.api.contents.common.service

import com.springboot.riot.api.contents.common.dto.CommonMatchDto

interface CommonService {

    fun commonMatchList(): List<CommonMatchDto>

}