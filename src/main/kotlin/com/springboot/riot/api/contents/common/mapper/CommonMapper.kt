package com.springboot.riot.api.contents.common.mapper

import com.springboot.riot.api.contents.common.vo.CommonChampionVo
import com.springboot.riot.api.contents.common.vo.CommonItemVo
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CommonMapper {

    fun selectCommonMatchList(): List<CommonMatchVo>

    fun selectCommonItemList(): List<CommonItemVo>

    fun selectCommonChampionList(): List<CommonChampionVo>

}