package com.springboot.riot.api.contents.feed.controller

import com.springboot.riot.api.contents.common.service.CommonService
import com.springboot.riot.api.contents.feed.service.FeedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feed")
class FeedController {
    @Autowired
    lateinit var commonService: CommonService

    @Autowired
    lateinit var feedService: FeedService

    @RequestMapping("/list")
    fun feedMatchList(): String {

        commonService.commonMatchList()


        return ""
    }
}