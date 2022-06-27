package com.springboot.riot.web.mapper

import com.springboot.riot.api.contents.common.dto.MatchSearchDto
import com.springboot.riot.api.contents.common.vo.CommonMatchVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface WebMapper {

    fun selectWebMatchList(params: MatchSearchDto?): List<CommonMatchVo>

}