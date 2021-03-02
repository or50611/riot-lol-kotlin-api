package com.springboot.riot.api.contents.detail.impl

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.dto.SummonerMatchDto
import com.springboot.riot.api.contents.detail.dto.MatchDto
import com.springboot.riot.api.contents.detail.dto.TeamBansDto
import com.springboot.riot.api.contents.detail.dto.TeamStatsDto
import com.springboot.riot.api.contents.detail.mapper.DetailMapper
import com.springboot.riot.api.contents.detail.service.DetailService
import com.springboot.riot.api.contents.detail.vo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetailServiceImpl: DetailService {

    @Autowired
    lateinit var detailMapper: DetailMapper

    override fun selectMatchTeamInfo(params: MatchSearchDto): MatchDto {
        var matchDto: MatchDto = MatchDto()


        val matchBasic: MatchBasicVo = detailMapper.selectMatchBasic(params)
        val matchTeamList: List<MatchTeamVo> = detailMapper.selectMatchTeam(params)
        val matchTeamBanList: List<MatchTeamBanVo> = detailMapper.selectMatchTeamBan(params)
        val matchInfoList: List<MatchParticipantInfoVo> = detailMapper.selectMatchParticipantInfo(params)
        val timelineEventItemList: List<TimelineEventItemVo> = detailMapper.selectMatchTimelineEventItem(params)
        val timelineEventSkillList: List<TimelineEventSkillVo> = detailMapper.selectMatchTimelineEventSkill(params)

        matchDto.gameId = matchBasic.gameId
        matchDto.platformId = matchBasic.platformId
        matchDto.gameCreation = matchBasic.gameCreation
        matchDto.gameDuration = matchBasic.gameDuration
        matchDto.queueId = matchBasic.queueId
        matchDto.mapId = matchBasic.mapId
        matchDto.seasonId = matchBasic.seasonId
        matchDto.gameVersion = matchBasic.gameVersion
        matchDto.gameMode = matchBasic.gameMode
        matchDto.gameType = matchBasic.gameType


        val matchTeamDataList = matchTeamList.flatMap { teamVo ->
            val teamDto = TeamStatsDto()
            teamDto.teamId = teamVo.teamId
            teamDto.win = teamVo.win
            teamDto.firstBlood = teamVo.firstBlood
            teamDto.firstTower = teamVo.firstTower
            teamDto.firstInhibitor = teamVo.firstInhibitor
            teamDto.firstBaron = teamVo.firstBaron
            teamDto.firstDragon = teamVo.firstDragon
            teamDto.firstRiftHerald = teamVo.firstRiftHerald
            teamDto.towerKills = teamVo.towerKills
            teamDto.inhibitorKills = teamVo.inhibitorKills
            teamDto.baronKills = teamVo.baronKills
            teamDto.vilemawKills = teamVo.vilemawKills
            teamDto.riftHeraldKills = teamVo.riftHeraldKills
            teamDto.dominionVictoryScore = teamVo.dominionVictoryScore

            teamDto.bans = matchTeamBanList.filter { it.teamId == teamVo.teamId }.flatMap(::banVoToDto)


            arrayListOf(teamDto)
        }



        return matchDto
    }

    private fun banVoToDto(vo: MatchTeamBanVo) : List<TeamBansDto> {
        val teamBanDto = TeamBansDto()
        teamBanDto.championId = vo.championId
        teamBanDto.pickTurn = vo.pickTurn
        return arrayListOf(teamBanDto)
    }
}