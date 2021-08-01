package com.mindorks.framework.chess_timer.dto.statistics.response

import com.google.gson.annotations.SerializedName
import com.mindorks.framework.chess_timer.dto.base.response.BaseResponseDTO

data class DetailedStatisticsResponseDTO(
    @SerializedName("id")
    override val id: Long,
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
): BaseResponseDTO