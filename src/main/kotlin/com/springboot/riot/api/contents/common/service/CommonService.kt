package com.springboot.riot.api.contents.common.service

import com.springboot.riot.api.contents.common.dto.ListDto

interface CommonService {

    fun commonMatchList(): ListDto?

}