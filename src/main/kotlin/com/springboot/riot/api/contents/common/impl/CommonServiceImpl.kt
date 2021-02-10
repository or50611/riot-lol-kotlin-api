package com.springboot.riot.api.contents.common.impl

import com.springboot.riot.api.contents.common.dto.SummonerItemDto
import com.springboot.riot.api.contents.common.dto.SummonerMatchDto
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.common.vo.CommonChampionVo
import com.springboot.riot.api.contents.common.vo.CommonItemVo
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
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

    override fun commonMatchList(): MutableList<SummonerMatchDto> {
        var matchDataList = mutableListOf<SummonerMatchDto>()
        var matchData:SummonerMatchDto

        println("------------name : "+ Globals.getDomain())

        val matchList: List<CommonMatchVo> = commonMapper.selectCommonMatchList()

        val itemList: List<CommonItemVo> = commonMapper.selectCommonItemList()

        val championList: List<CommonChampionVo> = commonMapper.selectCommonChampionList()

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
            matchData.item0 = findItem(itemList, match.item0)
            matchData.item1 = findItem(itemList, match.item1)
            matchData.item2 = findItem(itemList, match.item2)
            matchData.item3 = findItem(itemList, match.item3)
            matchData.item4 = findItem(itemList, match.item4)
            matchData.item5 = findItem(itemList, match.item5)
            matchData.item6 = findItem(itemList, match.item6)

            matchDataList.add(matchData)

        }

        println(matchList)

        return matchDataList

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

}