package com.springboot.riot.api.contents.common.impl

import com.springboot.riot.api.contents.common.dto.*
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.common.vo.CommonChampionVo
import com.springboot.riot.api.contents.common.vo.CommonItemVo
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import com.springboot.riot.api.contents.common.vo.CommonSummonerSpellsVo
import com.springboot.riot.global.Globals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.net.InetAddress

@Service
class CommonServiceImpl : CommonService {

    @Autowired
    lateinit var commonMapper: CommonMapper

    override fun commonMatchList(): ListDto? {
        var listDto = ListDto()
        var matchDataList = mutableListOf<SummonerMatchDto>()
        var matchData:SummonerMatchDto

        val domain = Globals.getDomain()

        println("------------name : "+ Globals.getDomain())

        val matchList: List<CommonMatchVo> = commonMapper.selectCommonMatchList()
        val itemList: List<CommonItemVo> = commonMapper.selectCommonItemList()
        val championList: List<CommonChampionVo> = commonMapper.selectCommonChampionList()
        val summonerSpellList: List<CommonSummonerSpellsVo> = commonMapper.selectCommonSummonerSpellsList()

        matchList.forEach { match ->
            matchData = SummonerMatchDto()
            matchData.accountId = match.accountId
            matchData.activityNm = match.activityNm
            matchData.activityKorNm = match.activityKorNm
            matchData.teamSeq = match.teamSeq
            matchData.mostLane = match.mostLane
            matchData.userName = match.userName
            matchData.gameId = match.gameId
            matchData.platformId = match.platformId
            matchData.champion = findChampion(championList, match.champion)
            matchData.queue = match.queue
            matchData.season = match.season
            matchData.timeStamp = match.timeStamp
            matchData.lane = match.platformId
            matchData.gameDuration = match.gameDuration
            matchData.enemyChampion = findChampion(championList, match.enemyChampion)
            matchData.spell1 = findSummonerSpell(summonerSpellList, match.spell1Id)
            matchData.spell2 = findSummonerSpell(summonerSpellList, match.spell2Id)
            matchData.teamId = match.teamId
//            matchData.teamNm = match.teamNm
            matchData.participantId = match.participantId
            matchData.win = match.win
            matchData.kills = match.kills
            matchData.deaths = match.deaths
            matchData.assists = match.assists
            matchData.item0 = findItem(itemList, match.item0)
            matchData.item1 = findItem(itemList, match.item1)
            matchData.item2 = findItem(itemList, match.item2)
            matchData.item3 = findItem(itemList, match.item3)
            matchData.item4 = findItem(itemList, match.item4)
            matchData.item5 = findItem(itemList, match.item5)
            matchData.item6 = findItem(itemList, match.item6)

            matchDataList.add(matchData)

        }
        listDto.list = matchDataList
        return listDto

    }

    fun findItem(itemList: List<CommonItemVo>, item: Int): SummonerItemDto? {
        var itemDto: SummonerItemDto? = null
        val findItem = itemList.firstOrNull { item == it.iKey }

        findItem?.let { it ->
            itemDto = SummonerItemDto()
            itemDto?.key = it.iKey
            itemDto?.name = it.iName
            itemDto?.description = it.description
            itemDto?.colloq = it.colloq
            itemDto?.plaintext = it.plaintext
            itemDto?.base = it.base
            itemDto?.purchasable = it.purchasable
            itemDto?.total = it.total
            itemDto?.sell = it.sell
            itemDto?.imageUrl = it.iFull
            return itemDto
        }
        return itemDto
    }

    fun findChampion(itemList: List<CommonChampionVo>, key: Int): SummonerChampionDto? {
        var championDto: SummonerChampionDto? = null
        val findChampion = itemList.firstOrNull { key == it.cKey }

        findChampion?.let { it ->
            championDto = SummonerChampionDto()
            championDto?.key = it.cKey
            championDto?.id = it.id
            championDto?.name = it.cName
            championDto?.title = it.title
            championDto?.blurb = it.blurb
            championDto?.parType = it.parType
            championDto?.imageUrl = it.cFull
            return championDto
        }
        return championDto
    }

    fun findSummonerSpell(spellList: List<CommonSummonerSpellsVo>, key: Int): SummonerSpellDto? {
        var spellDto: SummonerSpellDto? = null
        val findSpell = spellList.firstOrNull { key == it.sKey }

        findSpell?.let { it ->
            spellDto = SummonerSpellDto()
            spellDto?.key = it.sKey
            spellDto?.id = it.id
            spellDto?.name = it.sName
            spellDto?.description = it.description
            spellDto?.imageUrl = it.sFull
            return spellDto
        }
        return spellDto
    }

}