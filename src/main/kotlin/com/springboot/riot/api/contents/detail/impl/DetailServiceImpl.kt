package com.springboot.riot.api.contents.detail.impl

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.detail.dto.MatchDto
import com.springboot.riot.api.contents.detail.mapper.DetailMapper
import com.springboot.riot.api.contents.detail.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetailServiceImpl: DetailService {

    @Autowired
    lateinit var detailMapper: DetailMapper

    override fun selectMatchTeamInfo(params: MatchSearchDto): MatchDto {
        var matchDto: MatchDto = MatchDto()

        return matchDto
    }
}