package com.springboot.riot.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class WebMainController {

    @RequestMapping(value=["/"])
    fun index ():String {
        return "index"
    }

}