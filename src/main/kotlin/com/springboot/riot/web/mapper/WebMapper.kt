package com.springboot.riot.web.mapper

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.web.dto.TeamListDto
import com.springboot.riot.web.dto.WebSummonerMatchDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface WebMapper {

    fun selectWebMatchList(params: MatchSearchDto?): List<WebSummonerMatchDto>
    fun selectTeamMatchList(gameId: Long): List<TeamListDto>
}