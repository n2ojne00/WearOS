package com.example.mykotlinwearos.presentation.practiceData

data class DailySteps(
    val week: Int = 0,
    val stepCount: Int = 0
)

val stepData = listOf(
    DailySteps(week = 48, stepCount = 5738),
    DailySteps(week = 49, stepCount = 5836),
    DailySteps(week = 50, stepCount = 6373),
    DailySteps(week = 51, stepCount = 7443),
    DailySteps(week = 52, stepCount = 5392),
    DailySteps(week = 1, stepCount = 6322),
    DailySteps(week = 2, stepCount = 6859),
    DailySteps(week = 3, stepCount = 6789),
    DailySteps(week = 4, stepCount = 7402),
    DailySteps(week = 5, stepCount = 5694),
    DailySteps(week = 6, stepCount = 0),
    DailySteps(week = 7, stepCount = 12039),
    DailySteps(week = 8, stepCount = 5694),
)