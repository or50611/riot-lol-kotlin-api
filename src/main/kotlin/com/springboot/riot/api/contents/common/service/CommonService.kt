package com.springboot.riot.api.contents.common.service

import com.springboot.riot.api.contents.common.dto.BaseListDto
import com.springboot.riot.api.contents.common.dto.ListDto
import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.vo.CommonChampionVo
import com.springboot.riot.api.contents.common.vo.CommonItemVo
import com.springboot.riot.api.contents.common.vo.CommonRuneVo
import com.springboot.riot.api.contents.common.vo.CommonSummonerSpellsVo

interface CommonService {

    fun commonMatchList(params: MatchSearchDto?): ListDto?

    fun commonVersionList(): BaseListDto

    fun commonItemList(): BaseListDto

    fun commonChampionList(): BaseListDto

    fun commonSummonerSpellsList(): BaseListDto

    fun commonRuneList(): BaseListDto

    fun commonChampionSpellList(): BaseListDto

}