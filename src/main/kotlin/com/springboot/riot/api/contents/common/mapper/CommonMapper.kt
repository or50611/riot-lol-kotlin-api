package com.springboot.riot.api.contents.common.mapper

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.vo.*
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CommonMapper {

    fun selectCommonMatchList(params: MatchSearchDto?): List<CommonMatchVo>

    fun selectCommonVersionList(): List<CommonVersionVo>

    fun selectCommonItemList(): List<CommonItemVo>

    fun selectCommonChampionList(): List<CommonChampionVo>

    fun selectCommonSummonerSpellsList(): List<CommonSummonerSpellsVo>

    fun selectCommonRuneList(): List<CommonRuneVo>

    fun selectCommonChampionSpellList(): List<CommonChampionSpellVo>

}