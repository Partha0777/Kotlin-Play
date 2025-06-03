package com.curiozing.kotlinplay.cricketPoints

import kotlin.math.roundToInt

fun normalize(value: Double, maxValue: Double): Double {
    return (value / maxValue) * 100
}

fun calculatePoints(criteria: List<Double>, weightage: List<Double>): Double {
    return criteria.zip(weightage).sumOf { (c, w) -> c * w }
}

enum class Role {
    Batsman,
    Bowler,
    AllRounder
}

data class Player(
    var name: String,
    var battingAvg: Double,
    var totalRuns: Double,
    var strikeRate: Double,
    var centuriesAndFifties: Double,
    var bowlingAvg: Double,
    var totalWickets: Double,
    var economyRate: Double,
    var fiveWicketsHauls: Double,
    var isStarPlayer: Boolean,
    var role: Role,
)

fun main() {

    var virat = Player(
        name = "Virat Kohli",
        49.9,
        4042.0,
        137.91,
        38.0,
        51.0,
        4.0,
        8.05,
        0.0,
        true,
        Role.Batsman
    )

    var rohit = Player(
        name = "Rohit Sharma",
        31.09,
        4042.0,
        139.67,
        35.0,
        113.0,
        1.0,
        9.97,
        0.0,
        true,
        Role.Batsman
    )

    var bumrah = Player(
        name = "Jasprit Bumrah",
        2.67,
        8.0,
        57.14,
        0.0,
        18.99,
        79.0,
        6.44,
        0.0,
        true,
        Role.Bowler
    )
    var bumrahIpl = Player(
        name = "Jasprit Bumrah",
        2.67,
        8.0,
        57.14,
        0.0,
        22.52,
        165.0,
        7.3,
        2.0,
        true,
        Role.Bowler
    )

    var ashwin = Player(
        name = "Ravichandran Ashwin",
        26.29,
        184.0,
        115.0,
        0.0,
        23.22,
        72.0,
        6.91,
        0.0,
        false,
        Role.AllRounder
    )

    val player: Player = bumrahIpl

    val battingCriteria = listOf(
        normalize(player.battingAvg, 100.0),  // Batting Average
        // normalize(player.totalRuns, 5000.0),  // Total Runs
        normalize(player.strikeRate.coerceAtMost(200.0), 200.0),  // Strike Rate (Capped at 100)
        normalize(player.centuriesAndFifties, 30.0)  // Centuries and Fifties
    )

    //val battingWeightage = listOf(0.3, 0.3, 0.3, 0.1)
    val battingWeightage = listOf(0.4, 0.4, 0.2)

    var battingPoints = calculatePoints(battingCriteria, battingWeightage)
    if (player.role == Role.Bowler) {
        battingPoints /= 2
    }

    if (player.isStarPlayer && player.role == Role.Batsman) {
        battingPoints += 10
    }
    println(
        "${player.name} T20 Batting Points: ${
            battingPoints.roundToInt().coerceAtMost(99).coerceAtLeast(10)
        }"
    )

    val bowlingCriteria = listOf(
        normalize(100 - player.bowlingAvg, 100.0),  // Bowling Average
        // normalize(player.totalWickets, 200.0),  // Total Wickets
        normalize(36 - player.economyRate, 36.0),  // Economy Rate
        normalize(player.fiveWicketsHauls, 5.0)   // Five-Wicket Hauls
    )


    //val bowlingWeightage = listOf(0.35, 0.2, 0.35, 0.1)
    val bowlingWeightage = listOf(0.4, 0.4, 0.2)

    var bowlingPoints = calculatePoints(bowlingCriteria, bowlingWeightage)
    if (player.role == Role.Batsman) {
        bowlingPoints /= 2
    }
    if (player.isStarPlayer && player.role == Role.Bowler) {
        bowlingPoints += 10
    }

    println(
        "${player.name} T20 Bowling Points: ${
            bowlingPoints.roundToInt().coerceAtMost(99).coerceAtLeast(10)
        }"
    )

}

