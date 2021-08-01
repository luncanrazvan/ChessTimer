package com.mindorks.framework.chess_timer.api

import com.mindorks.framework.chess_timer.dto.statistics.request.DetailedStatisticsRequestDTO
import com.mindorks.framework.chess_timer.dto.statistics.response.DetailedStatisticsResponseDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST
    fun addStatisticsAsync(@Body detailedStatisticsRequestDTO: DetailedStatisticsRequestDTO) : Deferred<DetailedStatisticsResponseDTO>
}