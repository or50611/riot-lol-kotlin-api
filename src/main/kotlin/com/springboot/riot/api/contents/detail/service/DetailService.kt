package com.springboot.riot.api.contents.detail.service

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.detail.dto.MatchDto
import com.springboot.riot.api.contents.detail.dto.MatchTimelineDto

interface DetailService {

    fun selectMatchTeamInfo(params: MatchSearchDto): MatchDto

    fun selectMatchTeamTimeLine(params: MatchSearchDto): MatchTimelineDto

}