<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>롤전적</title>
    <link href="/lib/img/favi.ico" rel="shortcut icon" type="image/x-icon">
    <meta charset="UTF-8">
    <!--============================mata===========================================-->
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--============================css===========================================-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="/lib/css/sub.css">
    <link rel="stylesheet" href="/lib/css/common.css">
    <!--============================js===========================================-->
    <script type="text/javascript" src="/lib/vendor/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="/lib/js/index.js"></script>
    <script type="text/javascript" src="/lib/js/include.js"></script>
    <script>
        var depth_on_n = '롤전적 Publish';
        $(function () {
            var m = $('.recordWrap ul li div.record .tgBtn');
            var div = $('.recordWrap ul li div.recordDtl');
            m.each(function () {
                $(this).click(function () {
                    $(this).parent().next().slideToggle(400).parent().siblings()
                        .find('.recordDtl').slideUp(400);
                    $(".recordWrap >ul>li").removeClass('current');
                    $(this).parent().parent().toggleClass('current');
                    $(this).children('img').toggleClass('on').parent().parent()
                        .parent().siblings().children().children().children("img").removeClass('on');

                });
            });
        });

    </script>

</head>
<body>

<section class="recordWrap">
    <ul>
<c:forEach items="${list.list}" var="entity" varStatus="status">
    <c:choose>
        <c:when test="${entity.win}">
            <li class="lightblueBG">
                <!--recorddlist------------------------------------------------>
                <div class="record parent">
                    <button class="tgBtn btnblueBG">
                        <img src="/lib/image/chevron-down.png">
                    </button>
                    <ul class="fst child">
                        <li class="textDtl">
                            <strong class="blue">솔랭</strong>
                                <p>${entity.gameEndTimeConverterString}</p>
<%--                            <div class="dayDtl bubble">--%>
<%--                                2022년 6월 12일 오전 2:00--%>
<%--                            </div>--%>
                        </li>
                        <li>
                            <strong class="blue">승리</strong>
                            <p>${entity.converterDuration}</p>
                        </li>
                    </ul>
                    <ul class="scnd child">
                        <li>
                            <div class="scndTop">
                                <div class="profileBox skyblue">
                                    <a href="#">
                                        <img src="/image/champion/${entity.championUrl}" alt="이미지">
                                        <div class="level">${entity.champLevel}</div>
                                    </a>
                                </div>
                                <div class="items">
                                    <div class="itembox textDtl skyblue">
                                        <img src="/image/summoner_spell/${entity.summoner1Id}" alt="이미지">
                                    </div>
                                    <div class="itembox skyblue">
                                        <img src="/image/summoner_spell/${entity.summoner2Id}" alt="이미지">
                                    </div>
                                    <div class="itembox rune">
                                        <img src="/image/rune/${entity.primaryRuneImage}" alt="이미지">
                                    </div>
                                    <div class="itembox rune">
                                        <img src="/image/rune/${entity.subRuneImage}" alt="이미지">
                                    </div>
                                </div>
                                <div class="rcdnum">
                                    <p>
									<span>${entity.kills}</span> / <strong class="blue">${entity.deaths}</strong> / <span>${entity.assists}</span>
                                    </p>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="items2">
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item0}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item1}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item2}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item3}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item4}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item5}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item6}" alt="이미지">
                                </div>
                            </div>
                            <div class="multikill blueBG">
                                <p>트리플 킬</p>
                            </div>
                        </li>
                    </ul>
                    <ul class="thrd child">
                        <li class="blue">킬관여 50%</li>
                        <li>제어와드 ${entity.visionWardsBoughtInGame}</li>
                        <li>CS 200(5.7)</li>
                        <li>Gold 4</li>
                    </ul>
                        <ul class="foth child">
                            <c:forEach items="${entity.teamListDto}" var="teamList" varStatus="status">
                                <li>
                                    <div class="profilesBox">
                                        <img src="/image/champion/${teamList.summonerChampImageUrl}" alt="이미지">
                                    </div>
                                    <a>
                                        <p>${teamList.summonerName}</p>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
        </c:when>
        <c:otherwise>
                <li class="lightredBG">
                <!--recorddlist------------------------------------------------>
                <div class="record parent">
                    <button class="tgBtn btnredBG">
                        <img src="/lib/image/chevron-down.png">
                    </button>
                    <ul class="fst child">
                        <li class="textDtl">
                            <strong class="red">솔랭</strong>
                                <p>${entity.gameEndTimeConverterString}</p>
<%--                            <div class="dayDtl bubble">--%>
<%--                                2022년 6월 12일 오전 2:00--%>
<%--                            </div>--%>
                        </li>
                        <li>
                            <strong class="red">패배</strong>
                            <p>${entity.converterDuration}</p>
                        </li>
                    </ul>
                    <ul class="scnd child">
                        <li>
                            <div class="scndTop">
                                <div class="profileBox skyblue">
                                    <a href="#">
                                        <img src="/image/champion/${entity.championUrl}" alt="이미지">
                                        <div class="level">${entity.champLevel}</div>
                                    </a>
                                </div>
                                <div class="items">
                                    <div class="itembox textDtl skyblue">
                                        <img src="/image/summoner_spell/${entity.summoner1Id}" alt="이미지">
                                    </div>
                                    <div class="itembox skyblue">
                                        <img src="/image/summoner_spell/${entity.summoner2Id}" alt="이미지">
                                    </div>
                                    <div class="itembox rune">
                                        <img src="/image/rune/${entity.primaryRuneImage}" alt="이미지">
                                    </div>
                                    <div class="itembox rune">
                                        <img src="/image/rune/${entity.subRuneImage}" alt="이미지">
                                    </div>
                                </div>
                                <div class="rcdnum">
                                    <p>
                                        <span>${entity.kills}</span> / <strong class="blue">${entity.deaths}</strong> / <span>${entity.assists}</span>
                                    </p>
                                </div>
                        </li>
                        <li>
                            <div class="items2">
                                <c:forEach var="i" begin="0" end="6">
<%--                                    <img src="/image/item/${entity.itemi}" alt="이미지">--%>
                                </c:forEach>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item0}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item1}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item2}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item3}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item4}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item5}" alt="이미지">
                                </div>
                                <div class="item2box skyblue">
                                    <img src="/image/item/${entity.item6}" alt="이미지">
                                </div>
                            </div>
                            <div class="multikill redBG">
                                <p>트리플 킬</p>
                            </div>
                        </li>
                    </ul>
                    <ul class="thrd child">
                        <li class="red">킬관여 50%</li>
                        <li>제어와드 ${entity.visionWardsBoughtInGame}</li>
                        <li>CS 200(5.7)</li>
                        <li>Gold 4</li>
                    </ul>
                    <ul class="foth child">
                    <c:forEach items="${entity.teamListDto}" var="teamList" varStatus="status">
                        <li>
                            <div class="profilesBox">
                                <img src="/image/champion/${teamList.summonerChampImageUrl}" alt="이미지">
                            </div>
                            <a>
                                <p>${teamList.summonerName}</p>
                            </a>
                        </li>
                    </c:forEach>
                    </ul>
                    </div>
                </li>
        </c:otherwise>
    </c:choose>
</c:forEach>
        <li class="lightblueBG">
            <!--recorddlist------------------------------------------------>
            <div class="record parent">
                <button class="tgBtn btnblueBG">
                    <img src="/lib/image/chevron-down.png">
                </button>
                <ul class="fst child">
                    <li class="textDtl">
                        <strong class="blue">솔랭</strong>
                        <p>
                            11시간 전
                        </p>
                        <div class="dayDtl bubble">
                            2022년 6월 12일 오전 2:00
                        </div>
                    </li>
                    <li>
                        <strong class="blue">승리</strong>
                        <p>22분 0초</p>
                    </li>
                </ul>
                <ul class="scnd child">
                    <li>
                        <div class="scndTop">
                            <div class="profileBox skyblue">
                                <a href="#">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                    <div class="level">
                                        18
                                    </div>
                                </a>
                            </div>
                            <div class="items">
                                <div class="itembox textDtl skyblue">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox skyblue">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox rune">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox rune">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                            </div>
                            <div class="rcdnum">
                                <p>
									<span>
										10
									</span>
                                    /
                                    <strong class="blue">
                                        10
                                    </strong>
                                    /
                                    <span>
										10
									</span>
                                </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="items2">
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box skyblue">
                            </div>
                            <div class="item2box skyblue">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                        </div>
                        <div class="multikill blueBG">
                            <p>트리플 킬</p>
                        </div>
                    </li>
                </ul>
                <ul class="thrd child">
                    <li class="blue">킬관여 50%</li>
                    <li>제어와드 9</li>
                    <li>CS 200(5.7)</li>
                    <li>Gold 4</li>
                </ul>
                <ul class="foth child">
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                </ul>
            </div>
            <!--recordDtl------------------------------------------------>
<%--            <div class="recordDtl">--%>
<%--                <div class="recordDtlWrap">--%>
<%--                    <ul class="recordDtl_Tab">--%>
<%--                        <li>--%>
<%--                            <button>종합</button>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <button>팀분석</button>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <button>빌드</button>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <button>ETC</button>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                    <div class="recordDtl_fstWrap">--%>

<%--                        <div class="recordDtl_fstTop">--%>
<%--                            <ul>--%>
<%--                                <li>--%>
<%--                                    <h6 class="blue">승</h6>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
<%--                            <div class="graphWrap">--%>
<%--                                <div class="graph">--%>
<%--                                    <span class="title">TOTALL KILL</span>--%>
<%--                                    <span class="data_l_ltr">40</span>--%>
<%--                                    <span class="data_r_ltr">60</span>--%>
<%--                                    <div class="killData_l_stick blueBG"></div>--%>
<%--                                    <div class="killData_r_stick redBG"></div>--%>
<%--                                </div>--%>
<%--                                <div class="graph">--%>
<%--                                    <span class="title">TOTALL GOLD</span>--%>
<%--                                    <span class="data_l_ltr">80,000</span>--%>
<%--                                    <span class="data_r_ltr">69,999</span>--%>
<%--                                    <div class="goldData_l_stick blueBG"></div>--%>
<%--                                    <div class="goldData_r_stick redBG"></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <ul>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <img src="/lib/image/icon-baron.svg">--%>
<%--                                    <span>11</span>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <h6 class="red">패</h6>--%>
<%--                                </li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                        <div class="recordDtl_fstBT">--%>

<%--                            <table class="BTTop">--%>
<%--                                <colgroup>--%>
<%--                                    <col width="10%">--%>
<%--                                    <col width="4%">--%>
<%--                                    <col width="8%">--%>
<%--                                    <col width="3%">--%>
<%--                                    <col width="*">--%>
<%--                                    <col width="3%">--%>
<%--                                    <col width="8%">--%>
<%--                                    <col width="4%">--%>
<%--                                    <col width="10%">--%>
<%--                                </colgroup>--%>
<%--                                <tr>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											아이템--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											KDA/CS--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											딜량--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											인분--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											라인전--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											인분--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											딜량--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											KDA/CS--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                    <th>--%>
<%--										<span>--%>
<%--											아이템--%>
<%--										</span>--%>
<%--                                    </th>--%>
<%--                                </tr>--%>
<%--                            </table>--%>

<%--                            <ul class="BTbt">--%>
<%--                                <li>--%>
<%--                                    <div class="vsDtlWrap lftDtlWrap">--%>
<%--                                        <div class="itemWrap">--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="kdaCsWrap">--%>
<%--                                            <p>2 /<span class="blue"> 1 </span>/ 5</p>--%>
<%--                                            <strong>7.00</strong>--%>
<%--                                            <p>150(5.8)</p>--%>
<%--                                        </div>--%>
<%--                                        <div class="amountWrap">--%>
<%--                                            <p>13,0000</p>--%>
<%--                                            <div class="stickgraph">--%>
<%--                                                <div class="AmountData_l_stick blueBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="rankWrap">--%>
<%--                                            <p class="rank">ACE</p>--%>
<%--                                            <strong>1.5</strong>--%>
<%--                                        </div>--%>
<%--                                        <div class="profileWrap">--%>
<%--                                            <div class="profileBox skyblue">--%>
<%--                                                <a href="#">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                    <div class="level">--%>
<%--                                                        18--%>
<%--                                                    </div>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
<%--                                            <div class="items">--%>
<%--                                                <div class="itembox textDtl skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="vsWrap">--%>
<%--                                        <div class="positionWrap">--%>
<%--                                            <img src="/lib/image/icon-position-top.svg">--%>
<%--                                        </div>--%>
<%--                                        <div class="graphWrap">--%>
<%--                                            <div class="graph">--%>
<%--                                                <div class="killData_l_stick blueBG"></div>--%>
<%--                                                <div class="killData_r_stick redBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <p class="dataNumWrap">--%>
<%--                                            <span>1.52</span>--%>
<%--                                            :--%>
<%--                                            <span>1.25</span>--%>
<%--                                        </p>--%>
<%--                                    </div>--%>
<%--                                    <div class="vsDtlWrap ritDtlWrap">--%>
<%--                                        <div class="profileWrap">--%>
<%--                                            <div class="profileBox skyblue">--%>
<%--                                                <a href="#">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                    <div class="level">--%>
<%--                                                        18--%>
<%--                                                    </div>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
<%--                                            <div class="items">--%>
<%--                                                <div class="itembox textDtl skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="rankWrap">--%>
<%--                                            <p class="rank">ACE</p>--%>
<%--                                            <strong>1.5</strong>--%>
<%--                                        </div>--%>
<%--                                        <div class="amountWrap">--%>
<%--                                            <p>13,0000</p>--%>
<%--                                            <div class="stickgraph">--%>
<%--                                                <div class="AmountData_l_stick redBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="kdaCsWrap">--%>
<%--                                            <p>2 /<span class="red"> 1 </span>/ 5</p>--%>
<%--                                            <strong>7.00</strong>--%>
<%--                                            <p>150(5.8)</p>--%>
<%--                                        </div>--%>
<%--                                        <div class="itemWrap">--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </li>--%>
<%--                                <li>--%>
<%--                                    <div class="vsDtlWrap lftDtlWrap">--%>
<%--                                        <div class="itemWrap">--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="kdaCsWrap">--%>
<%--                                            <p>2 /<span class="blue"> 1 </span>/ 5</p>--%>
<%--                                            <strong>7.00</strong>--%>
<%--                                            <p>150(5.8)</p>--%>
<%--                                        </div>--%>
<%--                                        <div class="amountWrap">--%>
<%--                                            <p>13,0000</p>--%>
<%--                                            <div class="stickgraph">--%>
<%--                                                <div class="AmountData_l_stick blueBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="rankWrap">--%>
<%--                                            <p class="rank">ACE</p>--%>
<%--                                            <strong>1.5</strong>--%>
<%--                                        </div>--%>
<%--                                        <div class="profileWrap">--%>
<%--                                            <div class="profileBox skyblue">--%>
<%--                                                <a href="#">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                    <div class="level">--%>
<%--                                                        18--%>
<%--                                                    </div>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
<%--                                            <div class="items">--%>
<%--                                                <div class="itembox textDtl skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="vsWrap">--%>
<%--                                        <div class="positionWrap">--%>
<%--                                            <img src="/lib/image/icon-position-top.svg">--%>
<%--                                        </div>--%>
<%--                                        <div class="graphWrap">--%>
<%--                                            <div class="graph">--%>
<%--                                                <div class="killData_l_stick blueBG"></div>--%>
<%--                                                <div class="killData_r_stick redBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <p class="dataNumWrap">--%>
<%--                                            <span>1.52</span>--%>
<%--                                            :--%>
<%--                                            <span>1.25</span>--%>
<%--                                        </p>--%>
<%--                                    </div>--%>
<%--                                    <div class="vsDtlWrap ritDtlWrap">--%>
<%--                                        <div class="profileWrap">--%>
<%--                                            <div class="profileBox skyblue">--%>
<%--                                                <a href="#">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                    <div class="level">--%>
<%--                                                        18--%>
<%--                                                    </div>--%>
<%--                                                </a>--%>
<%--                                            </div>--%>
<%--                                            <div class="items">--%>
<%--                                                <div class="itembox textDtl skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox skyblue">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                                <div class="itembox rune">--%>
<%--                                                    <img src="/lib/image/Zoe.webp" alt="이미지">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="rankWrap">--%>
<%--                                            <p class="rank">ACE</p>--%>
<%--                                            <strong>1.5</strong>--%>
<%--                                        </div>--%>
<%--                                        <div class="amountWrap">--%>
<%--                                            <p>13,0000</p>--%>
<%--                                            <div class="stickgraph">--%>
<%--                                                <div class="AmountData_l_stick redBG"></div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="kdaCsWrap">--%>
<%--                                            <p>2 /<span class="red"> 1 </span>/ 5</p>--%>
<%--                                            <strong>7.00</strong>--%>
<%--                                            <p>150(5.8)</p>--%>
<%--                                        </div>--%>
<%--                                        <div class="itemWrap">--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                            <div class="Dtl_itembox skyblue">--%>
<%--                                                <img src="/lib/image/Zoe.webp">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </li>--%>
<%--                            </ul>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </li>


        <li class="lightredBG">
            <!--recorddlist------------------------------------------------>
            <div class="record parent">
                <button class="tgBtn btnredBG">
                    <img src="/lib/image/chevron-down.png">
                </button>
                <ul class="fst child">
                    <li class="textDtl">
                        <strong class="red">솔랭</strong>
                        <p>
                            11시간 전
                        </p>
                        <div class="dayDtl bubble">
                            2022년 6월 12일 오전 2:00
                        </div>
                    </li>
                    <li>
                        <strong class="red">패배</strong>
                        <p>22분 0초</p>
                    </li>
                </ul>
                <ul class="scnd child">
                    <li>
                        <div class="scndTop">
                            <div class="profileBox skyblue">
                                <a href="#">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                    <div class="level">
                                        18
                                    </div>
                                </a>
                            </div>
                            <div class="items">
                                <div class="itembox textDtl skyblue">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox skyblue">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox rune">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                                <div class="itembox rune">
                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                </div>
                            </div>
                            <div class="rcdnum">
                                <p>
												<span>
													10
												</span>
                                    /
                                    <strong class="red">
                                        10
                                    </strong>
                                    /
                                    <span>
													10
												</span>
                                </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="items2">
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                            <div class="item2box lightred">
                            </div>
                            <div class="item2box lightred">
                                <img src="/lib/image/Zoe.webp" alt="이미지">
                            </div>
                        </div>
                        <div class="multikill redBG">
                            <p>트리플 킬</p>
                        </div>
                    </li>
                </ul>
                <ul class="thrd child">
                    <li class="red">킬관여 50%</li>
                    <li>제어와드 9</li>
                    <li>CS 200(5.7)</li>
                    <li>Gold 4</li>
                </ul>
                <ul class="foth child">
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                    <li>
                        <div class="profilesBox">
                            <img src="/lib/image/Zoe.webp" alt="이미지">
                        </div>
                        <a>
                            <p>긴아이디일때글자수는?</p>
                        </a>
                    </li>
                </ul>
            </div>




            <!--recordDtl------------------------------------------------>
            <div class="recordDtl">
                <div class="recordDtlWrap">
                    <ul class="recordDtl_Tab">
                        <li>
                            <button>종합</button>
                        </li>
                        <li>
                            <button>팀분석</button>
                        </li>
                        <li>
                            <button>빌드</button>
                        </li>
                        <li>
                            <button>ETC</button>
                        </li>
                    </ul>
                    <div class="recordDtl_fstWrap">

                        <div class="recordDtl_fstTop">
                            <ul>
                                <li>
                                    <h6 class="blue">승</h6>
                                </li>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                            </ul>
                            <div class="graphWrap">
                                <div class="graph">
                                    <span class="title">TOTALL KILL</span>
                                    <span class="data_l_ltr">40</span>
                                    <span class="data_r_ltr">60</span>
                                    <div class="killData_l_stick blueBG"></div>
                                    <div class="killData_r_stick redBG"></div>
                                </div>
                                <div class="graph">
                                    <span class="title">TOTALL GOLD</span>
                                    <span class="data_l_ltr">80,000</span>
                                    <span class="data_r_ltr">69,999</span>
                                    <div class="goldData_l_stick blueBG"></div>
                                    <div class="goldData_r_stick redBG"></div>
                                </div>
                            </div>
                            <ul>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                                <li>
                                    <img src="/lib/image/icon-baron.svg">
                                    <span>11</span>
                                </li>
                                <li>
                                    <h6 class="red">패</h6>
                                </li>
                            </ul>
                        </div>
                        <div class="recordDtl_fstBT">

                            <table class="BTTop">
                                <colgroup>
                                    <col width="10%">
                                    <col width="4%">
                                    <col width="8%">
                                    <col width="3%">
                                    <col width="*">
                                    <col width="3%">
                                    <col width="8%">
                                    <col width="4%">
                                    <col width="10%">
                                </colgroup>
                                <tr>
                                    <th>
													<span>
														아이템
													</span>
                                    </th>
                                    <th>
													<span>
														KDA/CS
													</span>
                                    </th>
                                    <th>
													<span>
														딜량
													</span>
                                    </th>
                                    <th>
													<span>
														인분
													</span>
                                    </th>
                                    <th>
													<span>
														라인전
													</span>
                                    </th>
                                    <th>
													<span>
														인분
													</span>
                                    </th>
                                    <th>
													<span>
														딜량
													</span>
                                    </th>
                                    <th>
													<span>
														KDA/CS
													</span>
                                    </th>
                                    <th>
													<span>
														아이템
													</span>
                                    </th>
                                </tr>
                            </table>

                            <ul class="BTbt">
                                <li>
                                    <div class="vsDtlWrap lftDtlWrap">
                                        <div class="itemWrap">
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox lightred">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                        </div>
                                        <div class="kdaCsWrap">
                                            <p>2 /<span class="red"> 1 </span>/ 5</p>
                                            <strong>7.00</strong>
                                            <p>150(5.8)</p>
                                        </div>
                                        <div class="amountWrap">
                                            <p>13,0000</p>
                                            <div class="stickgraph">
                                                <div class="AmountData_l_stick blueBG"></div>
                                            </div>
                                        </div>
                                        <div class="rankWrap">
                                            <p class="rank">ACE</p>
                                            <strong>1.5</strong>
                                        </div>
                                        <div class="profileWrap">
                                            <div class="profileBox skyblue">
                                                <a href="#">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                    <div class="level">
                                                        18
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="items">
                                                <div class="itembox textDtl skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="vsWrap">
                                        <div class="positionWrap">
                                            <img src="/lib/image/icon-position-top.svg">
                                        </div>
                                        <div class="graphWrap">
                                            <div class="graph">
                                                <div class="killData_l_stick blueBG"></div>
                                                <div class="killData_r_stick redBG"></div>
                                            </div>
                                        </div>
                                        <p class="dataNumWrap">
                                            <span>1.52</span>
                                            :
                                            <span>1.25</span>
                                        </p>
                                    </div>
                                    <div class="vsDtlWrap ritDtlWrap">
                                        <div class="profileWrap">
                                            <div class="profileBox skyblue">
                                                <a href="#">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                    <div class="level">
                                                        18
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="items">
                                                <div class="itembox textDtl skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="rankWrap">
                                            <p class="rank">ACE</p>
                                            <strong>1.5</strong>
                                        </div>
                                        <div class="amountWrap">
                                            <p>13,0000</p>
                                            <div class="stickgraph">
                                                <div class="AmountData_l_stick redBG"></div>
                                            </div>
                                        </div>
                                        <div class="kdaCsWrap">
                                            <p>2 /<span class="red"> 1 </span>/ 5</p>
                                            <strong>7.00</strong>
                                            <p>150(5.8)</p>
                                        </div>
                                        <div class="itemWrap">
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="vsDtlWrap lftDtlWrap">
                                        <div class="itemWrap">
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                        </div>
                                        <div class="kdaCsWrap">
                                            <p>2 /<span class="blue"> 1 </span>/ 5</p>
                                            <strong>7.00</strong>
                                            <p>150(5.8)</p>
                                        </div>
                                        <div class="amountWrap">
                                            <p>13,0000</p>
                                            <div class="stickgraph">
                                                <div class="AmountData_l_stick blueBG"></div>
                                            </div>
                                        </div>
                                        <div class="rankWrap">
                                            <p class="rank">ACE</p>
                                            <strong>1.5</strong>
                                        </div>
                                        <div class="profileWrap">
                                            <div class="profileBox skyblue">
                                                <a href="#">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                    <div class="level">
                                                        18
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="items">
                                                <div class="itembox textDtl skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="vsWrap">
                                        <div class="positionWrap">
                                            <img src="/lib/image/icon-position-top.svg">
                                        </div>
                                        <div class="graphWrap">
                                            <div class="graph">
                                                <div class="killData_l_stick blueBG"></div>
                                                <div class="killData_r_stick redBG"></div>
                                            </div>
                                        </div>
                                        <p class="dataNumWrap">
                                            <span>1.52</span>
                                            :
                                            <span>1.25</span>
                                        </p>
                                    </div>
                                    <div class="vsDtlWrap ritDtlWrap">
                                        <div class="profileWrap">
                                            <div class="profileBox skyblue">
                                                <a href="#">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                    <div class="level">
                                                        18
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="items">
                                                <div class="itembox textDtl skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox skyblue">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                                <div class="itembox rune">
                                                    <img src="/lib/image/Zoe.webp" alt="이미지">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="rankWrap">
                                            <p class="rank">ACE</p>
                                            <strong>1.5</strong>
                                        </div>
                                        <div class="amountWrap">
                                            <p>13,0000</p>
                                            <div class="stickgraph">
                                                <div class="AmountData_l_stick redBG"></div>
                                            </div>
                                        </div>
                                        <div class="kdaCsWrap">
                                            <p>2 /<span class="red"> 1 </span>/ 5</p>
                                            <strong>7.00</strong>
                                            <p>150(5.8)</p>
                                        </div>
                                        <div class="itemWrap">
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                            <div class="Dtl_itembox skyblue">
                                                <img src="/lib/image/Zoe.webp">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</section>

</body>
</html>