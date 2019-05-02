package com.kscory.weeklybook.model

data class Recommendation(
    val title: String,
    val subTitle: String,
    val content: String,
    val finalization: String,
    val author: String,
    val cardFirstUrl: String,
    val cardSecondUrl: String,
    val cardThirdUrl: String,
    val cardFourthUrl: String,
    val cardFifthUrl: String,
    val cardSixthUrl: String
)