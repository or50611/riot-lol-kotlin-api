package com.springboot.riot.web.impl

import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.global.Globals
import com.springboot.riot.web.Util.CommonUtill
import com.springboot.riot.web.dto.WebSummonerMatchDto
import com.springboot.riot.web.mapper.WebMapper
import com.springboot.riot.web.service.WebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.roundToInt

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
        val matchDataList = mutableListOf<WebSummonerMatchDto>()
        var matchData: WebSummonerMatchDto
        val matchList: List<WebSummonerMatchDto> = webMapper.selectWebMatchList(params)

        matchList.forEach { match ->
            matchData = WebSummonerMatchDto()
            matchData = match
            matchData.converterDuration = CommonUtill.converterDuration(match.gameDuration)
            matchData.teamListDto = webMapper.selectTeamMatchList(match.gameId)
            matchData.gameEndTimeConverterString = CommonUtill.toRelativeTimeString(match.gameEndTimestamp)
            matchDataList.add(matchData)
        }
//        listDto.nextCursor = matchList.lastOrNull()?.nextCursor ?: 0
        listDto.list = matchDataList
        return listDto

    }
}