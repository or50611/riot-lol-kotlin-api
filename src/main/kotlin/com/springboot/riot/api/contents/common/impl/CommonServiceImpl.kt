package com.springboot.riot.api.contents.common.impl

import com.springboot.riot.api.contents.common.dto.*
import com.springboot.riot.api.contents.common.mapper.CommonMapper
import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.common.vo.*
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

    val fileChampion = Globals.FILE_CHAMPION_PATH
    val fileItem = Globals.FILE_ITEM_PATH
    val fileSummonerSpell = Globals.FILE_SUMMONER_SPELL_PATH
    val fileRune = Globals.FILE_RUNE_PATH
    val fileChampionSpell = Globals.FILE_CHAMPION_SPELL_PATH

    override fun commonMatchList(params: MatchSearchDto?): ListDto? {
        val listDto = ListDto()
        val matchDataList = mutableListOf<SummonerMatchDto>()
        var matchData:SummonerMatchDto

        val matchList: List<CommonMatchVo> = commonMapper.selectCommonMatchList(params)

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

    override fun commonVersionList(): BaseListDto {
        val listDto = BaseListDto()
        listDto.list = commonMapper.selectCommonVersionList()
        return listDto
    }

    override fun commonItemList(): BaseListDto {
        val listDto = BaseListDto()
        val itemListDto = mutableListOf<SummonerItemDto>()
        var itemDto: SummonerItemDto

        val itemList: List<CommonItemVo> = commonMapper.selectCommonItemList()

        itemList.forEach {
            itemDto = SummonerItemDto()
            itemDto.key = it.iKey
            itemDto.name = it.iName
            itemDto.description = it.description
            itemDto.colloq = it.colloq
            itemDto.plaintext = it.plaintext
            itemDto.base = it.base
            itemDto.purchasable = it.purchasable
            itemDto.total = it.total
            itemDto.sell = it.sell
            itemDto.imageUrl = Globals.getDomain()+fileItem+it.iFull
            itemListDto.add(itemDto)
        }

        listDto.list = itemListDto
        return listDto
    }

    override fun commonChampionList(): BaseListDto {
        val listDto = BaseListDto()
        val championListDto = mutableListOf<SummonerChampionDto>()
        var championDto: SummonerChampionDto

        val championList: List<CommonChampionVo> = commonMapper.selectCommonChampionList()

        championList.forEach {
            championDto = SummonerChampionDto()
            championDto.key = it.cKey
            championDto.id = it.id
            championDto.name = it.cName
            championDto.title = it.title
            championDto.blurb = it.blurb
            championDto.parType = it.parType
            championDto.imageUrl = Globals.getDomain()+fileChampion+it.cFull
            championListDto.add(championDto)
        }

        listDto.list = championListDto
        return listDto
    }

    override fun commonSummonerSpellsList(): BaseListDto {
        val listDto = BaseListDto()
        val spellListDto = mutableListOf<SummonerSpellDto>()
        var spellDto: SummonerSpellDto

        val spellList: List<CommonSummonerSpellsVo> = commonMapper.selectCommonSummonerSpellsList()

        spellList.forEach {
            spellDto = SummonerSpellDto()
            spellDto.key = it.sKey
            spellDto.id = it.id
            spellDto.name = it.sName
            spellDto.description = it.description
            spellDto.imageUrl = Globals.getDomain()+fileSummonerSpell+it.sFull
            spellListDto.add(spellDto)
        }

        listDto.list = spellListDto
        return listDto
    }

    override fun commonRuneList(): BaseListDto {
        val listDto = BaseListDto()
        val runeListDto = mutableListOf<SummonerRuneDto>()
        var runeDto: SummonerRuneDto

        val runeList: List<CommonRuneVo> = commonMapper.selectCommonRuneList()

        runeList.forEach {
            runeDto = SummonerRuneDto()
            runeDto.id = it.id
            runeDto.parentId = it.parentId
            runeDto.key = it.rKey
            runeDto.imageUrl = Globals.getDomain()+fileRune+it.fileNm
            runeDto.name = it.rName
            runeDto.shortDesc = it.shortDesc
            runeDto.longDesc = it.longDesc
            runeListDto.add(runeDto)
        }

        listDto.list = runeListDto
        return listDto
    }

    override fun commonChampionSpellList(): BaseListDto {
        val listDto = BaseListDto()
        val spellListDto = mutableListOf<ChampionSpellDto>()
        var spellDto: ChampionSpellDto
        val spellList: List<CommonChampionSpellVo> = commonMapper.selectCommonChampionSpellList()

        spellList.forEach {
            spellDto = ChampionSpellDto()
            spellDto.key = it.cKey
            spellDto.skillSlot = it.skillSlot
            spellDto.id = it.id
            spellDto.name = it.sName
            spellDto.description = it.description
            spellDto.tooltip = it.tooltip
            spellDto.maxRank = it.maxRank
            spellDto.cooldownBurn = it.cooldownBurn
            spellDto.costBurn = it.costBurn
            spellDto.costYype = it.costYype
            spellDto.maxAmmo = it.maxAmmo
            spellDto.rangeBurn = it.rangeBurn
            spellDto.resource = it.resource
            spellDto.imageUrl = Globals.getDomain()+fileChampionSpell+it.sFull

            spellListDto.add(spellDto)
        }

        listDto.list = spellListDto
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
            itemDto?.imageUrl = Globals.getDomain()+fileItem+it.iFull
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
            championDto?.imageUrl = Globals.getDomain()+fileChampion+it.cFull
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
            spellDto?.imageUrl = Globals.getDomain()+fileSummonerSpell+it.sFull
            return spellDto
        }
        return spellDto
    }

}