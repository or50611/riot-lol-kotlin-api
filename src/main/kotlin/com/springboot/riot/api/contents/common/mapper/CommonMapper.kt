package com.springboot.riot.api.contents.common.mapper

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.vo.CommonChampionVo
import com.springboot.riot.api.contents.common.vo.CommonItemVo
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import com.springboot.riot.api.contents.common.vo.CommonSummonerSpellsVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CommonMapper {

    fun selectCommonMatchList(params: MatchSearchDto?): List<CommonMatchVo>

    fun selectCommonItemList(): List<CommonItemVo>

    fun selectCommonChampionList(): List<CommonChampionVo>

    fun selectCommonSummonerSpellsList(): List<CommonSummonerSpellsVo>

}