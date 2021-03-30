package com.springboot.riot.api.contents.detail.dto

data class ParticipantDto(
    var participantId: Int = 0,
    var teamId: Int = 0,
    var championId: Int = 0,
    var spell1Id: Int = 0,
    var spell2Id: Int = 0,
    var platformId: String? = null,
    var tier: String? = null,
    var rank: String? = null,
    var accountId: String? = null,
    var summonerName: String? = null,
    var summonerId: String? = null,
    var currentPlatformId: String? = null,
    var currentAccountId: String? = null,
    var matchHistoryUri: String? = null,
    var profileIcon: Int = 0,
    var win: Boolean = false,
    var item0: Int = 0,
    var item1: Int = 0,
    var item2: Int = 0,
    var item3: Int = 0,
    var item4: Int = 0,
    var item5: Int = 0,
    var item6: Int = 0,
    var kills: Int = 0,
    var deaths: Int = 0,
    var assists: Int = 0,
    var largestKillingSpree: Int = 0,
    var largestMultiKill: Int = 0,
    var killingSprees: Int = 0,
    var longestTimeSpentLiving: Int = 0,
    var doubleKills: Int = 0,
    var tripleKills: Int = 0,
    var quadraKills: Int = 0,
    var pentaKills: Int = 0,
    var unrealKills: Int = 0,
    var totalDamageDealt: Int = 0,
    var magicDamageDealt: Int = 0,
    var physicalDamageDealt: Int = 0,
    var trueDamageDealt: Int = 0,
    var largestCriticalStrike: Int = 0,
    var totalDamageDealtToChampions: Int = 0,
    var magicDamageDealtToChampions: Int = 0,
    var physicalDamageDealtToChampions: Int = 0,
    var trueDamageDealtToChampions: Int = 0,
    var totalHeal: Int = 0,
    var totalUnitsHealed: Int = 0,
    var damageSelfMitigated: Int = 0,
    var damageDealtToObjectives: Int = 0,
    var damageDealtToTurrets: Int = 0,
    var visionScore: Int = 0,
    var timeCcingOthers: Int = 0,
    var totalDamageTaken: Int = 0,
    var magicDamageTaken: Int = 0,
    var physicalDamageTaken: Int = 0,
    var trueDamageTaken: Int = 0,
    var goldEarned: Int = 0,
    var goldSpent: Int = 0,
    var turretKills: Int = 0,
    var inhibitorKills: Int = 0,
    var totalMinionsKilled: Int = 0,
    var neutralMinionsKilled: Int = 0,
    var neutralMinionsKilledTeamJungle: Int = 0,
    var neutralMinionsKilledEnemyJungle: Int = 0,
    var totalTimeCrowdControlDealt: Int = 0,
    var champLevel: Int = 0,
    var visionWardsBoughtIngame: Int = 0,
    var sightWardsBoughtIngame: Int = 0,
    var wardsPlaced: Int = 0,
    var wardsKilled: Int = 0,
    var firstBloodKill: Int = 0,
    var firstBloodAssist: Int = 0,
    var firstTowerKill: Int = 0,
    var firstTowerAssist: Int = 0,
    var firstInhibitorKill: Int = 0,
    var firstInhibitorAssist: Int = 0,
    var combatPlayerScore: Int = 0,
    var objectivePlayerScore: Int = 0,
    var totalPlayerScore: Int = 0,
    var totalScoreRank: Int = 0,
    var playerScore0: Int = 0,
    var playerScore1: Int = 0,
    var playerScore2: Int = 0,
    var playerScore3: Int = 0,
    var playerScore4: Int = 0,
    var playerScore5: Int = 0,
    var playerScore6: Int = 0,
    var playerScore7: Int = 0,
    var playerScore8: Int = 0,
    var playerScore9: Int = 0,
    var perk0: Int = 0,
    var perk0Val1: Int = 0,
    var perk0Val2: Int = 0,
    var perk0Val3: Int = 0,
    var perk1: Int = 0,
    var perk1Val1: Int = 0,
    var perk1Val2: Int = 0,
    var perk1Val3: Int = 0,
    var perk2: Int = 0,
    var perk2Val1: Int = 0,
    var perk2Val2: Int = 0,
    var perk2Val3: Int = 0,
    var perk3: Int = 0,
    var perk3Val1: Int = 0,
    var perk3Val2: Int = 0,
    var perk3Val3: Int = 0,
    var perk4: Int = 0,
    var perk4Val1: Int = 0,
    var perk4Val2: Int = 0,
    var perk4Val3: Int = 0,
    var perk5: Int = 0,
    var perk5Val1: Int = 0,
    var perk5Val2: Int = 0,
    var perk5Val3: Int = 0,
    var perkPrimaryStyle: Int = 0,
    var perkSubStyle: Int = 0,
    var statPerk0: Int = 0,
    var statPerk1: Int = 0,
    var statPerk2: Int = 0,
    var lane: String? = null,
    var laneSeq: Int = 0,
)
