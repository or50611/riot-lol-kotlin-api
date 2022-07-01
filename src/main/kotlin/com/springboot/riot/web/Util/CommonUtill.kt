package com.springboot.riot.web.Util

import kotlin.math.roundToInt

class CommonUtill {
    companion object {
        fun converterDuration(second: Int): String? {
            var hour = if((second/3600) < 24 && (second/3600) > 0){(second/3600).toString()+"시간 "} else {""}
            var min = if((second%3600/60) < 60 && (second%3600/60) > 0 ) {(second%3600/60).toString()+"분 "} else {""}
            var se = if((second%3600%60) < 60 && (second%3600%60) > 0){ (second%3600%60).toString()+"초 "} else{""}
            return hour+min+se
        }


        fun Int.timeStampToString(): String {
            val min = this/60
            val sec = this - min * 60
            return "$min : $sec"
        }

        fun toRelativeTimeString(unixTime: Long): String? {
            if (unixTime < 0) return "알수없음"
            var date = System.currentTimeMillis()  - unixTime
            if (date < 1) return "지금"
            if (date < 60) {
                return "$date 초전"
            } else if (date < 60 * 60) {
                date /= 60
                return "$date 분전"
            } else if (date < 60 * 60 * 24) {
                date /= 60 * 60.toLong()
                return "$date 시간전"
            } else if (date < 60 * 60 * 24 * 7) {
                date = (date + 60 * 60 * 24 / 2) / (60 * 60 * 24) // effective rounding
                return "$date 일전"
            } else if (date < 60 * 60 * 24 * 30) {
                date = (date + 60 * 60 * 24 * 7 / 2) / (60 * 60 * 24 * 7) // effective rounding
                return "$date 주전"
            } else if (date < 60 * 60 * 24 * 365) {
                date = (date + 60 * 60 * 24 * 30 / 2) / (60 * 60 * 24 * 30) // effective rounding
                return "$date 달전"
            } else if (date < 60 * 60 * 24 * 365 * 10) {
                date = (date + 60 * 60 * 24 * 365 / 2) / (60 * 60 * 24 * 365) // effective rounding
                return "$date 년전"
            } else {
                return "알수없음"
            }
        }



    }

}