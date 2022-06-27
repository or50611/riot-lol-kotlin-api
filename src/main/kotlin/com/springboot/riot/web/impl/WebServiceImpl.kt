package com.springboot.riot.web.impl

import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.dto.SummonerMatchDto
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import com.springboot.riot.global.Globals
import com.springboot.riot.web.mapper.WebMapper
import com.springboot.riot.web.service.WebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebServiceImpl : WebService {

    @Autowired
    lateinit var webMapper: WebMapper

    val fileChampion = Globals.FILE_CHAMPION_PATH
    val fileItem = Globals.FILE_ITEM_PATH
    val fileSummonerSpell = Globals.FILE_SUMMONER_SPELL_PATH
    val fileRune = Globals.FILE_RUNE_PATH
    val fileChampionSpell = Globals.FILE_CHAMPION_SPELL_PATH
    val fileRankedPosition = Globals.FILE_RANKED_POSITION_PATH


    override fun webCommonMatchList(params: MatchSearchDto?): ListDto? {
        val listDto = ListDto()
        val matchDataList = mutableListOf<SummonerMatchDto>()
        var matchData: SummonerMatchDto

        val matchList: List<CommonMatchVo> = webMapper.selectWebMatchList(params)

        matchList.forEach { match ->
            matchData = SummonerMatchDto()
            matchData.accountId = match.accountId
            matchData.activityNm = match.activityNm
            matchData.activityKorNm = match.activityKorNm
            matchData.classification = match.classification
            matchData.classificationNm = match.classificationNm
            matchData.teamSeq = match.teamSeq
            matchData.teamNm = match.teamNm
            matchData.teamKorNm = match.teamKorNm
            matchData.mostLane = match.mostLane
            matchData.mostLaneNm = match.mostLaneNm
            matchData.userName = match.userName
            matchData.tier = match.tier
            matchData.rank = match.rank
            matchData.positionImageUrl = Globals.getDomain()+fileRankedPosition+match.fileNm
            matchData.gameId = match.gameId
            matchData.platformId = match.platformId
            matchData.champion = match.champion
            matchData.queue = match.queue
            matchData.queueNm = Globals.queue(match.queue)
            matchData.season = match.season
            matchData.timeStamp = match.timeStamp
            matchData.lane = match.lane
            matchData.gameDuration = match.gameDuration
            matchData.enemyChampion = match.enemyChampion
            matchData.spell1 = match.spell1Id
            matchData.spell2 = match.spell2Id
            matchData.perkPrimaryStyle = match.perkPrimaryStyle
            matchData.perkSubStyle = match.perkSubStyle
            matchData.teamId = match.teamId
            matchData.participantId = match.participantId
            matchData.win = match.win
            matchData.kills = match.kills
            matchData.deaths = match.deaths
            matchData.assists = match.assists
            matchData.item0 = match.item0
            matchData.item1 = match.item1
            matchData.item2 = match.item2
            matchData.item3 = match.item3
            matchData.item4 = match.item4
            matchData.item5 = match.item5
            matchData.item6 = match.item6

            matchDataList.add(matchData)
        }

        listDto.nextCursor = matchList.lastOrNull()?.nextCursor ?: 0

        listDto.list = matchDataList
        return listDto

    }


}