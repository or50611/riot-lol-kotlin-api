package com.springboot.riot.api.contents.detail.impl

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.dto.SummonerMatchDto
import com.springboot.riot.api.contents.detail.dto.*
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
        val matchDto: MatchDto = MatchDto()

        println("---------params : "+params.gameId)


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

        val matchInfoDataList = matchInfoList.flatMap { infoVo ->
            val infoDto = ParticipantDto()

            infoDto.participantId = infoVo.participantId
            infoDto.teamId = infoVo.teamId
            infoDto.championId = infoVo.championId
            infoDto.spell1Id = infoVo.spell1Id
            infoDto.spell2Id = infoVo.spell2Id
            infoDto.platformId = infoVo.currentPlatformId
            infoDto.tier = infoVo.tier
            infoDto.rank = infoVo.rank
            infoDto.accountId = infoVo.accountId
            infoDto.summonerName = infoVo.summonerName
            infoDto.summonerId = infoVo.summonerId
            infoDto.currentPlatformId = infoVo.currentPlatformId
            infoDto.currentAccountId = infoVo.currentAccountId
            infoDto.matchHistoryUri = infoVo.matchHistoryUri
            infoDto.profileIcon = infoVo.profileIcon
            infoDto.win = infoVo.win
            infoDto.item0 = infoVo.item0
            infoDto.item1 = infoVo.item1
            infoDto.item2 = infoVo.item2
            infoDto.item3 = infoVo.item3
            infoDto.item4 = infoVo.item4
            infoDto.item5 = infoVo.item5
            infoDto.item6 = infoVo.item6
            infoDto.kills = infoVo.doubleKills
            infoDto.deaths = infoVo.deaths
            infoDto.assists = infoVo.assists
            infoDto.largestKillingSpree = infoVo.largestKillingSpree
            infoDto.largestMultiKill = infoVo.largestMultiKill
            infoDto.killingSprees = infoVo.killingSprees
            infoDto.longestTimeSpentLiving = infoVo.longestTimeSpentLiving
            infoDto.doubleKills = infoVo.doubleKills
            infoDto.tripleKills = infoVo.tripleKills
            infoDto.quadraKills = infoVo.quadraKills
            infoDto.pentaKills = infoVo.pentaKills
            infoDto.unrealKills = infoVo.unrealKills
            infoDto.totalDamageDealt = infoVo.totalDamageDealt
            infoDto.magicDamageDealt = infoVo.magicDamageDealt
            infoDto.physicalDamageDealt = infoVo.physicalDamageDealt
            infoDto.trueDamageDealt = infoVo.trueDamageDealt
            infoDto.largestCriticalStrike = infoVo.largestCriticalStrike
            infoDto.totalDamageDealtToChampions = infoVo.totalDamageDealtToChampions
            infoDto.magicDamageDealtToChampions = infoVo.magicDamageDealtToChampions
            infoDto.physicalDamageDealtToChampions = infoVo.physicalDamageDealtToChampions
            infoDto.trueDamageDealtToChampions = infoVo.trueDamageDealtToChampions
            infoDto.totalHeal = infoVo.totalHeal
            infoDto.totalUnitsHealed = infoVo.totalUnitsHealed
            infoDto.damageSelfMitigated = infoVo.damageSelfMitigated
            infoDto.damageDealtToObjectives = infoVo.damageDealtToObjectives
            infoDto.damageDealtToTurrets = infoVo.damageDealtToTurrets
            infoDto.visionScore = infoVo.visionScore
            infoDto.timeCcingOthers = infoVo.timeCcingOthers
            infoDto.totalDamageTaken = infoVo.totalDamageTaken
            infoDto.magicDamageTaken = infoVo.magicDamageTaken
            infoDto.physicalDamageTaken = infoVo.physicalDamageTaken
            infoDto.trueDamageTaken = infoVo.trueDamageTaken
            infoDto.goldEarned = infoVo.goldEarned
            infoDto.goldSpent = infoVo.goldSpent
            infoDto.turretKills = infoVo.turretKills
            infoDto.inhibitorKills = infoVo.inhibitorKills
            infoDto.totalMinionsKilled = infoVo.totalMinionsKilled
            infoDto.neutralMinionsKilled = infoVo.neutralMinionsKilled
            infoDto.neutralMinionsKilledTeamJungle = infoVo.neutralMinionsKilledTeamJungle
            infoDto.neutralMinionsKilledEnemyJungle = infoVo.neutralMinionsKilledEnemyJungle
            infoDto.totalTimeCrowdControlDealt = infoVo.totalTimeCrowdControlDealt
            infoDto.champLevel = infoVo.champLevel
            infoDto.visionWardsBoughtIngame = infoVo.visionWardsBoughtIngame
            infoDto.sightWardsBoughtIngame = infoVo.sightWardsBoughtIngame
            infoDto.wardsPlaced = infoVo.wardsPlaced
            infoDto.wardsKilled = infoVo.wardsKilled
            infoDto.firstBloodKill = infoVo.firstBloodKill
            infoDto.firstBloodAssist = infoVo.firstBloodAssist
            infoDto.firstTowerKill = infoVo.firstTowerKill
            infoDto.firstTowerAssist = infoVo.firstTowerAssist
            infoDto.firstInhibitorKill = infoVo.firstInhibitorKill
            infoDto.firstInhibitorAssist = infoVo.firstInhibitorAssist
            infoDto.combatPlayerScore = infoVo.combatPlayerScore
            infoDto.objectivePlayerScore = infoVo.objectivePlayerScore
            infoDto.totalPlayerScore = infoVo.totalPlayerScore
            infoDto.totalScoreRank = infoVo.totalScoreRank
            infoDto.playerScore0 = infoVo.playerScore0
            infoDto.playerScore1 = infoVo.playerScore1
            infoDto.playerScore2 = infoVo.playerScore2
            infoDto.playerScore3 = infoVo.playerScore3
            infoDto.playerScore4 = infoVo.playerScore4
            infoDto.playerScore5 = infoVo.playerScore5
            infoDto.playerScore6 = infoVo.playerScore6
            infoDto.playerScore7 = infoVo.playerScore7
            infoDto.playerScore8 = infoVo.playerScore8
            infoDto.playerScore9 = infoVo.playerScore9
            infoDto.perk0 = infoVo.perk0
            infoDto.perk0Val1 = infoVo.perk0Val1
            infoDto.perk0Val2 = infoVo.perk0Val2
            infoDto.perk0Val3 = infoVo.perk0Val3
            infoDto.perk1 = infoVo.perk1
            infoDto.perk1Val1 = infoVo.perk0Val1
            infoDto.perk1Val2 = infoVo.perk1Val2
            infoDto.perk1Val3 = infoVo.perk1Val3
            infoDto.perk2 = infoVo.perk2
            infoDto.perk2Val1 = infoVo.perk1Val2
            infoDto.perk2Val2 = infoVo.perk1Val2
            infoDto.perk2Val3 = infoVo.perk2Val3
            infoDto.perk3 = infoVo.perk3
            infoDto.perk3Val1 = infoVo.perk1Val3
            infoDto.perk3Val2 = infoVo.perk2Val3
            infoDto.perk3Val3 = infoVo.perk2Val3
            infoDto.perk4 = infoVo.perk4
            infoDto.perk4Val1 = infoVo.perk4Val1
            infoDto.perk4Val2 = infoVo.perk4Val2
            infoDto.perk4Val3 = infoVo.perk4Val3
            infoDto.perk5 = infoVo.perk5
            infoDto.perk5Val1 = infoVo.perk5Val1
            infoDto.perk5Val2 = infoVo.perk5Val2
            infoDto.perk5Val3 = infoVo.perk5Val3
            infoDto.perkPrimaryStyle = infoVo.perkPrimaryStyle
            infoDto.perkSubStyle = infoVo.perkSubStyle
            infoDto.statPerk0 = infoVo.statPerk0
            infoDto.statPerk1 = infoVo.statPerk1
            infoDto.statPerk2 = infoVo.statPerk2
            infoDto.lane = infoVo.lane
            infoDto.laneSeq = infoVo.laneSeq
            
            arrayListOf(infoDto)
        }

        val timelineEventItemDataList = timelineEventItemList.flatMap { itemVo ->
            val itemDto = TimelineEventItemDto()

            itemDto.participantId = itemVo.participantId
            itemDto.parentTimestamp = itemVo.parentTimestamp
            itemDto.timestamp = itemVo.parentTimestamp
            itemDto.type = itemVo.eType
            itemDto.itemId = itemVo.itemId
            itemDto.afterId = itemVo.afterId
            itemDto.beforeId = itemVo.beforeId

            arrayListOf(itemDto)
        }

        val timelineEventSkillDataList = timelineEventSkillList.flatMap { skillVo ->
            val skillDto = TimelineEventSkillDto()

            skillDto.participantId = skillVo.participantId
            skillDto.parentTimestamp = skillVo.parentTimestamp
            skillDto.timestamp = skillVo.parentTimestamp
            skillDto.type = skillVo.eType
            skillDto.skillSlot = skillVo.skillSlot
            skillDto.levelUpType = skillVo.levelUpType

            arrayListOf(skillDto)
        }

        matchDto.teams = matchTeamDataList
        matchDto.participants = matchInfoDataList
        matchDto.itemEvent = timelineEventItemDataList
        matchDto.skillEvent = timelineEventSkillDataList



        return matchDto
    }

    private fun banVoToDto(vo: MatchTeamBanVo) : List<TeamBansDto> {
        val teamBanDto = TeamBansDto()
        teamBanDto.championId = vo.championId
        teamBanDto.pickTurn = vo.pickTurn
        return arrayListOf(teamBanDto)
    }
}