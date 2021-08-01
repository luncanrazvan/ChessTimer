package com.mindorks.framework.chess_timer.dto.statistics.request

import com.google.gson.annotations.SerializedName
import com.mindorks.framework.chess_timer.dto.base.request.BaseRequestDTO

data class DetailedStatisticsRequestDTO(
    @SerializedName("firstName")
    override val playerOneName: String,
    @SerializedName("lastName")
    override val playerTwoName: String,
    @SerializedName("time")
    val time: Long,
    @SerializedName("numberOfClicks")
    val numberOfClicks: Int,
    @SerializedName("maxTimeThinkingPlayerOne")
    val maxTimeWaitingPlayerOne: Long,
    @SerializedName("maxTimeThinkingPlayerTwo")
    val maxTimeThinkingPlayerTwo: Long,
    @SerializedName("minTimeThinkingPlayerOne")
    val minTimeThinkingPlayerOne: Long,
    @SerializedName("minTimeThinkingPlayerTwo")
    val minTimeThinkingPlayerTwo: Long
): BaseRequestDTO