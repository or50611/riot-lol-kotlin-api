package com.springboot.riot.api.contents.common.service

import com.springboot.riot.api.contents.common.vo.CommonMatchVo

interface CommonService {

    fun commonMatchList(): List<CommonMatchVo>

}