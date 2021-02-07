package com.springboot.riot.api.contents.common.impl

import com.springboot.riot.api.contents.common.dto.CommonMatchDto
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommonServiceImpl : CommonService {

    @Autowired
    lateinit var commonMapper: CommonMapper

    override fun commonMatchList() {
        println("------------------CommonServiceAbst.commonMatchList")
        var matchList: List<CommonMatchDto> = commonMapper.selectCommonMatchList()

        println(matchList)

    }

}