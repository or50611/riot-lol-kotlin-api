package com.springboot.riot.api.contents.common.mapper

import com.springboot.riot.api.contents.common.dto.CommonMatchDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CommonMapper {

    fun selectCommonMatchList(): List<CommonMatchDto>

}