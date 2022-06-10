package com.springboot.riot.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@Controller
class PathController{

    @RequestMapping("/{path}")
    fun path(@PathVariable path: String, @RequestParam params: Map<String,String>, request: HttpServletRequest): String {
        return getPath("/$path")
    }

    @RequestMapping("/{path}/{page}")
    fun path(@PathVariable path: String, @PathVariable page: String, @RequestParam params: Map<String,String>, request: HttpServletRequest): String {
        return getPath("/$path/$page")
    }

    @RequestMapping("/{path}/{path2}/{page}")
    fun path2(@PathVariable path: String, @PathVariable path2: String, @PathVariable page: String, @RequestParam params: Map<String,String>, request: HttpServletRequest): String {
        return getPath("/$path/$path2/$page")
    }

    @RequestMapping("/{path}/{path2}/{path3}/{page}")
    fun path3(@PathVariable path: String, @PathVariable path2: String, @PathVariable path3: String, @PathVariable page: String, @RequestParam params: Map<String,String>, request: HttpServletRequest): String {
        return getPath("/$path/$path2/$path3/$page")
    }

    @RequestMapping("/{path}/{path2}/{path3}/{path4}/{page}")
    fun path4(@PathVariable path: String, @PathVariable path2: String, @PathVariable path3: String, @PathVariable path4: String, @PathVariable page: String, @RequestParam params: Map<String,String>, request: HttpServletRequest): String {
        return getPath("/$path/$path2/$path3/$path4/$page")
    }
    private fun getPath(str: String): String {
        return str.replace("/st_exclude/", "/")
    }
}