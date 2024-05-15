package com.edurda77.rt176.data.repository

import android.app.Application
import android.content.Context
import com.edurda77.rt176.data.mapper.convertToBasketBallMatches
import com.edurda77.rt176.data.mapper.convertToFootballMatches
import com.edurda77.rt176.data.mapper.convertToHokkeyMatches
import com.edurda77.rt176.data.remote.dto.basketball.BasketBallDto
import com.edurda77.rt176.data.remote.dto.football.FootballDto
import com.edurda77.rt176.data.remote.dto.hokkey.HokkeyDto
import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.HokkeyMatchRt176
import com.edurda77.rt176.domain.repository.RemoteRepositoryrt176
import com.edurda77.rt176.domain.utils.RAPID_BASKETBALL_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_FOOTBALL_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_HOKKEY_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_TOKEN_RT_176
import com.edurda77.rt176.domain.utils.ResourceRt176
import com.edurda77.rt176.domain.utils.SHARED_DATA_RT176
import com.edurda77.rt176.domain.utils.TIME_ZONE
import com.edurda77.rt176.domain.utils.UNKNOWN_ERROR_RT_176
import com.edurda77.rt176.domain.utils.URL_BASKETBALL_RT_145
import com.edurda77.rt176.domain.utils.URL_FOOTBALL_RT_145
import com.edurda77.rt176.domain.utils.URL_HOKKEY_RT_145
import com.edurda77.rt176.domain.utils.formattedDateRt176
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Date
import javax.inject.Inject
import kotlin.random.Random

class RemoteRepositoryrt176Impl @Inject constructor(
    private val application: Application,
    private val httpClient: HttpClient
): RemoteRepositoryrt176 {
    private val sharedPrefRt171 =
        application.getSharedPreferences(SHARED_DATA_RT176, Context.MODE_PRIVATE)

    override val remoteData =
        MutableStateFlow<ResourceRt176<String>>(ResourceRt176.SuccessRt176(bnm = null))

    override suspend fun getFootballData(
        timeStamp: Date
    ): ResourceRt176<List<FootballMatchRt176>> {
        return try {
            val fg = Random.nextDouble(0.0, 20.0)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            val formattedDate = formattedDateRt176(timeStamp)
            val result = httpClient.get(URL_FOOTBALL_RT_145 + "fixtures") {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", formattedDate)
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_FOOTBALL_HOST_RT_176)
                }
            }
                .call
                .body<FootballDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertToFootballMatches()
            )
        } catch (e: Exception) {
            val fg = Random.nextInt(0, 20)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getBasketballData(
        timeStamp: Date,
    ): ResourceRt176<List<BasketballMatchRt176>> {
        return try {
            val fg = Random.nextDouble(0.0, 20.0)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            val formattedDate = formattedDateRt176(timeStamp)
            val result = httpClient.get(URL_BASKETBALL_RT_145+ "games") {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", formattedDate)
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_BASKETBALL_HOST_RT_176)
                }
            }
                .call
                .body<BasketBallDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertToBasketBallMatches()
            )
        } catch (e: Exception) {
            val fg = Random.nextInt(0, 20)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getHockeyData(
        timeStamp: Date
    ): ResourceRt176<List<HokkeyMatchRt176>> {
        return try {
            val fg = Random.nextDouble(0.0, 20.0)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            val formattedDate = formattedDateRt176(timeStamp)
            val result = httpClient.get(URL_HOKKEY_RT_145+ "games") {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", formattedDate)
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_HOKKEY_HOST_RT_176)
                }
            }
                .call
                .body<HokkeyDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertToHokkeyMatches()
            )
        } catch (e: Exception) {
            val fg = Random.nextInt(0, 20)
            val vbn = 8
            val sd = if (fg > vbn) fg else vbn
            println(sd)
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun isInternetConnectedrt176(): Boolean {
        TODO("Not yet implemented")
    }
}