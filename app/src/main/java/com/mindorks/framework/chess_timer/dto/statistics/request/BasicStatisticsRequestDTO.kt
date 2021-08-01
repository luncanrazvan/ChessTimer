package com.mindorks.framework.chess_timer.dto.statistics.request

import com.google.gson.annotations.SerializedName
import com.mindorks.framework.chess_timer.dto.base.request.BaseRequestDTO

data class BasicStatisticsRequestDTO (
    @SerializedName("firstName")
    override val playerOneName: String,
    @SerializedName("lastName")
    override val playerTwoName: String,
    @SerializedName("time")
    val time: Long
): BaseRequestDTO