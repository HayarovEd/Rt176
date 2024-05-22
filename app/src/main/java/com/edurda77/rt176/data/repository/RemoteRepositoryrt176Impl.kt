package com.edurda77.rt176.data.repository

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import com.backendless.Backendless
import com.edurda77.rt176.data.mapper.convertBasketballToH2hModel
import com.edurda77.rt176.data.mapper.convertFottballToH2hModel
import com.edurda77.rt176.data.mapper.convertHockeyToH2hModel
import com.edurda77.rt176.data.mapper.convertToBasketBallMatches
import com.edurda77.rt176.data.mapper.convertToFootballMatches
import com.edurda77.rt176.data.mapper.convertToHokkeyMatches
import com.edurda77.rt176.data.remote.dto.basketball.BasketBallDto
import com.edurda77.rt176.data.remote.dto.football.FootballDto
import com.edurda77.rt176.data.remote.dto.h2h_basketball.H2hBasketballDto
import com.edurda77.rt176.data.remote.dto.h2h_football.H2hFootballDto
import com.edurda77.rt176.data.remote.dto.h2h_hockey.H2hHockeyDto
import com.edurda77.rt176.data.remote.dto.hokkey.HokkeyDto
import com.edurda77.rt176.domain.model.BasketballMatchRt176
import com.edurda77.rt176.domain.model.FootballMatchRt176
import com.edurda77.rt176.domain.model.H2HModel
import com.edurda77.rt176.domain.model.HockeyMatchRt176
import com.edurda77.rt176.domain.repository.RemoteRepositoryrt176
import com.edurda77.rt176.domain.utils.ANDROID_API_KEY_RT176
import com.edurda77.rt176.domain.utils.APPLICATION_ID_RT176
import com.edurda77.rt176.domain.utils.BACK_URL_RT176
import com.edurda77.rt176.domain.utils.NAME_RT176
import com.edurda77.rt176.domain.utils.OBJECT_ID_KEY_RT176
import com.edurda77.rt176.domain.utils.RAPID_BASKETBALL_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_FOOTBALL_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_HOKKEY_HOST_RT_176
import com.edurda77.rt176.domain.utils.RAPID_TOKEN_RT_176
import com.edurda77.rt176.domain.utils.ResourceRt176
import com.edurda77.rt176.domain.utils.SEnder
import com.edurda77.rt176.domain.utils.SHARED_ACCESS_RT176
import com.edurda77.rt176.domain.utils.SHARED_BEST_SCORE_RT176
import com.edurda77.rt176.domain.utils.SHARED_DATA_RT176
import com.edurda77.rt176.domain.utils.SHARED_NAME_RT176
import com.edurda77.rt176.domain.utils.SHARED_PHONE_RT176
import com.edurda77.rt176.domain.utils.SHARED_URL_RT176
import com.edurda77.rt176.domain.utils.TABLE_NAME_RT176
import com.edurda77.rt176.domain.utils.TIME_ZONE
import com.edurda77.rt176.domain.utils.UNKNOWN_ERROR_RT_176
import com.edurda77.rt176.domain.utils.URL_BASKETBALL_RT_176
import com.edurda77.rt176.domain.utils.URL_FOOTBALL_RT_176
import com.edurda77.rt176.domain.utils.URL_HOKKEY_RT_176
import com.edurda77.rt176.domain.utils.generateRandomColorRt175
import com.yandex.metrica.AppMetricaDeviceIDListener
import com.yandex.metrica.YandexMetrica
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import kotlin.random.Random

class RemoteRepositoryrt176Impl @Inject constructor(
    private val application: Application,
    private val httpClient: HttpClient
) : RemoteRepositoryrt176 {
    private val sharedPrefRt176 =
        application.getSharedPreferences(SHARED_DATA_RT176, Context.MODE_PRIVATE)

    override val remoteData =
        MutableStateFlow<ResourceRt176<String>>(ResourceRt176.SuccessRt176(bnm = null))

    override suspend fun getFootballDataRt176(
        timeStampRt176ft: String
    ): ResourceRt176<List<FootballMatchRt176>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "fixtures"
                false -> "fixtures"
            }

            val result = httpClient.get(URL_FOOTBALL_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", timeStampRt176ft)
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
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> e.printStackTrace()
                false -> e.printStackTrace()
            }
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getBasketballDataRt176(
        timeStampRt176bsk: String,
    ): ResourceRt176<List<BasketballMatchRt176>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "games"
                false -> "games"
            }
            val result = httpClient.get(URL_BASKETBALL_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", timeStampRt176bsk)
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
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getHockeyDataRt176(
        timeStampRt176hc: String
    ): ResourceRt176<List<HockeyMatchRt176>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "games"
                false -> "games"
            }
            val result = httpClient.get(URL_HOKKEY_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("date", timeStampRt176hc)
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
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getFootballH2HData(
        idHome: Int,
        idAway: Int
    ): ResourceRt176<List<H2HModel>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "fixtures/headtohead"
                false -> "fixtures/headtohead"
            }
            val result = httpClient.get(URL_FOOTBALL_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("h2h", "$idHome-$idAway")
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_FOOTBALL_HOST_RT_176)
                }
            }
                .call
                .body<H2hFootballDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertFottballToH2hModel().takeLast(5)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getBasketballH2hData(
        idHome: Int,
        idAway: Int
    ): ResourceRt176<List<H2HModel>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "games"
                false -> "games"
            }
            val result = httpClient.get(URL_BASKETBALL_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("h2h", "$idHome-$idAway")
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_BASKETBALL_HOST_RT_176)
                }
            }
                .call
                .body<H2hBasketballDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertBasketballToH2hModel().takeLast(5)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override suspend fun getHockeyH2HData(
        idHome: Int,
        idAway: Int
    ): ResourceRt176<List<H2HModel>> {
        return try {
            val nextVkr = Random.nextBoolean()
            val a = when (nextVkr) {
                true -> "games/h2h"
                false -> "games/h2h"
            }
            val result = httpClient.get(URL_HOKKEY_RT_176 + a) {
                contentType(ContentType.Application.Json)
                url {
                    parameter("h2h", "$idHome-$idAway")
                    parameter("timezone", TIME_ZONE)
                    header("x-rapidapi-key", RAPID_TOKEN_RT_176)
                    header("x-rapidapi-host", RAPID_HOKKEY_HOST_RT_176)
                }
            }
                .call
                .body<H2hHockeyDto>()
            ResourceRt176.SuccessRt176(
                bnm = result.convertHockeyToH2hModel().takeLast(5)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }


    override suspend fun getSharedUrlrt176(): String? {
        val nextVkr = Random.nextBoolean()
         when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        return sharedPrefRt176.getString(SHARED_URL_RT176, "")
    }

    override suspend fun setSharedUrlrt176(date: String) {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        sharedPrefRt176.edit().putString(SHARED_URL_RT176, date).apply()
    }

    override suspend fun getNamert176(): String? {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        return sharedPrefRt176.getString(SHARED_NAME_RT176, "")
    }

    override suspend fun setNamert176(date: String) {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        sharedPrefRt176.edit().putString(SHARED_NAME_RT176, date).apply()
    }

    override suspend fun getPhonert176(): String? {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        return sharedPrefRt176.getString(SHARED_PHONE_RT176, "")
    }

    override suspend fun setPhonert176(date: String) {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        sharedPrefRt176.edit().putString(SHARED_PHONE_RT176, date).apply()
    }

    override suspend fun getBestScorert176(): Int {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        return sharedPrefRt176.getInt(SHARED_BEST_SCORE_RT176, 0)
    }

    override suspend fun setBestScorert176(date: Int) {
        val fg = Random.nextInt(0, 20)
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        sharedPrefRt176.edit().putInt(SHARED_BEST_SCORE_RT176, date).apply()
    }

    override suspend fun getStateEnterRt176():Boolean {
        return sharedPrefRt176.getBoolean(SHARED_ACCESS_RT176, true)
    }

    override suspend fun setStateEnterrt176(date: Boolean) {
        val nextVkr = Random.nextBoolean()
        when (nextVkr) {
            true -> "games/h2h"
            false -> "games/h2h"
        }
        sharedPrefRt176.edit().putBoolean(SHARED_ACCESS_RT176, date).apply()
    }

    override suspend fun isInternetConnectedrt176(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(network) ?: return false
            val nextVkr = Random.nextBoolean()
            when (nextVkr) {
                true -> "h"
                false -> "gamesh"
            }
            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo ?: return false
            activeNetworkInfo.isConnected
        }
    }

    override suspend fun getUrlrt176() {
        try {
            withContext(Dispatchers.IO)
            {
                YandexMetrica.requestAppMetricaDeviceID(object :
                    AppMetricaDeviceIDListener {
                    override fun onLoaded(p0: String?) {
                        try {
                            val lasr = generateRandomColorRt175()
                            val sdffv  = getBeck()
                            val b = if (lasr<1000)  3 else 5
                            if (sdffv != null) {
                                try {
                                    remoteData.value = SEnder(
                                        dfhj = p0,
                                        sdffv = sdffv
                                    )
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    remoteData.value =
                                        ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
                                }
                            } else {
                                remoteData.value = ResourceRt176.ErrorRt176("empty data")
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                            remoteData.value =
                                ResourceRt176.ErrorRt176(e.message ?: "Backendless error")
                        }
                    }

                    override fun onError(p0: AppMetricaDeviceIDListener.Reason) {
                    }
                })
            }
        } catch (e: Exception) {
            e.printStackTrace()
            remoteData.value = ResourceRt176.ErrorRt176(e.message ?: UNKNOWN_ERROR_RT_176)
        }
    }

    override fun isVpnActiveRt176(): Boolean {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // For Android Q (API level 29) and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val activeNetwork: Network? = connectivityManager.activeNetwork
            val networkCapabilities: NetworkCapabilities? =
                connectivityManager.getNetworkCapabilities(activeNetwork)
            return networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_VPN) == true
        } else {
            // For Android P (API level 28) and below
            @Suppress("DEPRECATION")
            val networks = connectivityManager.allNetworks
            networks.forEach { network ->
                val networkCapabilities: NetworkCapabilities? =
                    connectivityManager.getNetworkCapabilities(network)
                if (networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_VPN) == true) {
                    return true
                }
            }
        }

        return false
    }

    private fun getBeck():String? {
        Backendless.setUrl(BACK_URL_RT176)
        Backendless.initApp(
            application,
            APPLICATION_ID_RT176,
            ANDROID_API_KEY_RT176
        )
        return Backendless.Data.of(TABLE_NAME_RT176)
            .findById(OBJECT_ID_KEY_RT176)[NAME_RT176]?.toString()
    }
}