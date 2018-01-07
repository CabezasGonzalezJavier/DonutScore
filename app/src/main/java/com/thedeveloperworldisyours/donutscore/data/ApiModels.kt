package com.thedeveloperworldisyours.donutscore.data

/**
 * Created by javiergonzalezcabezas on 6/1/18.
 */
class CoachingSummary(

        var activeTodo: Boolean? = null,
        var activeChat: Boolean? = null,
        var numberOfTodoItems: Int? = null,
        var numberOfCompletedTodoItems: Int? = null,
        var selected: Boolean? = null
)

class CreditReportInfo(

        var score: Int? = null,
        var scoreBand: Int? = null,
        var clientRef: String? = null,
        var status: String? = null,
        var maxScoreValue: Int? = null,
        var minScoreValue: Int? = null,
        var monthsSinceLastDefaulted: Int? = null,
        var hasEverDefaulted: Boolean? = null,
        var monthsSinceLastDelinquent: Int? = null,
        var hasEverBeenDelinquent: Boolean? = null,
        var percentageCreditUsed: Int? = null,
        var percentageCreditUsedDirectionFlag: Int? = null,
        var changedScore: Int? = null,
        var currentShortTermDebt: Int? = null,
        var currentShortTermNonPromotionalDebt: Int? = null,
        var currentShortTermCreditLimit: Int? = null,
        var currentShortTermCreditUtilisation: Int? = null,
        var changeInShortTermDebt: Int? = null,
        var currentLongTermDebt: Int? = null,
        var currentLongTermNonPromotionalDebt: Int? = null,
        var currentLongTermCreditLimit: Any? = null,
        var currentLongTermCreditUtilisation: Any? = null,
        var changeInLongTermDebt: Int? = null,
        var numPositiveScoreFactors: Int? = null,
        var numNegativeScoreFactors: Int? = null,
        var equifaxScoreBand: Int? = null,
        var equifaxScoreBandDescription: String? = null,
        var daysUntilNextReport: Int? = null
)

class Example(
        var accountIDVStatus: String? = null,
        var creditReportInfo: CreditReportInfo? = null,
        var dashboardStatus: String? = null,
        var personaType: String? = null,
        var coachingSummary: CoachingSummary? = null,
        var augmentedCreditScore: Any? = null
)