package com.springboot.riot.api.contents.common.impl

import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommonServiceImpl : CommonService {

    @Autowired
    lateinit var commonMapper: CommonMapper

    override fun commonMatchList(): List<CommonMatchVo> {
        var matchList: List<CommonMatchVo> = commonMapper.selectCommonMatchList()

        println(matchList)

        return matchList

    }

}