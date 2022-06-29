package com.springboot.riot.web.Util

class CommonUtill {
    companion object {
        fun converterDuration(second: Int): String? {
            var hour = if((second/3600) < 24 && (second/3600) > 0){(second/3600).toString()+"시간 "} else {""}
            var min = if((second%3600/60) < 60 && (second%3600/60) > 0 ) {(second%3600/60).toString()+"분 "} else {""}
            var se = if((second%3600%60) < 60 && (second%3600%60) > 0){ (second%3600%60).toString()+"초 "} else{""}
            return hour+min+se
        }
    }
}