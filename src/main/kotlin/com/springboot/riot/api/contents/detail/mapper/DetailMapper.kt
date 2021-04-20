package com.springboot.riot.api.contents.detail.mapper

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.detail.vo.*
import org.apache.ibatis.annotations.Mapper

@Mapper
interface DetailMapper {

    fun selectMatchBasic(params: MatchSearchDto): MatchBasicVo

    fun selectMatchTeam(params: MatchSearchDto): List<MatchTeamVo>

    fun selectMatchTeamBan(params: MatchSearchDto): List<MatchTeamBanVo>

    fun selectMatchParticipantInfo(params: MatchSearchDto): List<MatchParticipantInfoVo>

    fun selectMatchTimelineEventItem(params: MatchSearchDto): List<TimelineEventItemVo>

    fun selectMatchTimelineEventSkill(params: MatchSearchDto): List<TimelineEventSkillVo>

    fun selectMatchTimelineEventMonster(params: MatchSearchDto): List<TimelineEventMonsterVo>

    fun selectMatchTimelineEventBuilding(params: MatchSearchDto): List<TimelineEventBuildingVo>

}