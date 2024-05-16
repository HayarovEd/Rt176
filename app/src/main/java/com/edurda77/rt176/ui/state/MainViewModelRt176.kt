package com.edurda77.rt176.ui.state

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.rt176.domain.repository.RemoteRepositoryrt176
import com.edurda77.rt176.domain.utils.ResourceRt176
import com.edurda77.rt176.domain.utils.formattedDateRt176
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModelRt176 @Inject constructor(
    private val remoteRepositoryRt176: RemoteRepositoryrt176
) : ViewModel() {
    private var _state = MutableStateFlow(MainStateRt176())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            if (remoteRepositoryRt176.isInternetConnectedrt176()) {
                async { getFootballDataRt171() }.onAwait
                async { getBasketballDataRt171() }.onAwait
                async { getHockeyDataRt171() }.onAwait
                val savedUrl = remoteRepositoryRt176.getSharedUrlrt176()
                if (savedUrl.isNullOrBlank()) {
                    getUrlRt176()
                } else {
                    _state.value.copy(
                        destinationUrl = savedUrl
                    )
                        .fusUpdateStateUIRt171()
                }
                _state.value.copy(
                    applicationStRt176 = ApplicationStRt176.StartRt176(),
                    name = remoteRepositoryRt176.getNamert176() ?: "",
                    phone = remoteRepositoryRt176.getPhonert176() ?: ""
                )
                    .fusUpdateStateUIRt171()
            } else {
                _state.value.copy(
                    isLoadingUrl = false,
                    applicationStRt176 = ApplicationStRt176.StartRt176()
                )
                    .fusUpdateStateUIRt171()
            }
        }
    }

    private suspend fun getFootballDataRt171() {
        when (val result =
            remoteRepositoryRt176.getFootballData(
               timeStamp = _state.value.selectedDate.formattedDateRt176()
            )) {
            is ResourceRt176.ErrorRt176 -> {
                Log.d("MainViewModelRt171", "error football -${result.message}")
                _state.value.copy(
                    isLoading = false,
                    message = "Проверьте интернет соединение"
                )
                    .fusUpdateStateUIRt171()
            }

            is ResourceRt176.SuccessRt176 -> {
                Log.d("MainViewModelRt171", "football -${result.dvt}")
                _state.value.copy(
                    isLoading = false,
                    message = "",
                    allFootball = result.dvt?: emptyList()
                )
                    .fusUpdateStateUIRt171()
                if (!result.dvt?.filter { it.isPlay }.isNullOrEmpty()) {
                    _state.value.copy(
                        liveFootballData = result.dvt?.filter { it.isPlay }?: emptyList()
                    )
                        .fusUpdateStateUIRt171()
                }
            }
        }
    }

    private suspend fun getBasketballDataRt171() {
        when (val result =
            remoteRepositoryRt176.getBasketballData(
                timeStamp = _state.value.selectedDate.formattedDateRt176()
            )) {
            is ResourceRt176.ErrorRt176 -> {
                Log.d("MainViewModelRt171", "error basketball -${result.message}")
                _state.value.copy(
                    isLoading = false,
                    message = "Проверьте интернет соединение"
                )
                    .fusUpdateStateUIRt171()
            }

            is ResourceRt176.SuccessRt176 -> {
                Log.d("MainViewModelRt171", "basketball -${result.dvt}")
                _state.value.copy(
                    isLoading = false,
                    message = "",
                    allBasketball = result.dvt?: emptyList()
                )
                    .fusUpdateStateUIRt171()
                if (!result.dvt?.filter { it.isPlay }.isNullOrEmpty()) {
                    _state.value.copy(
                        liveBasketballData = result.dvt?.filter { it.isPlay }?: emptyList()
                    )
                        .fusUpdateStateUIRt171()
                }
            }
        }
    }

    private suspend fun getHockeyDataRt171() {
        when (val result =
            remoteRepositoryRt176.getHockeyData(
                timeStamp = _state.value.selectedDate.formattedDateRt176()
            )) {
            is ResourceRt176.ErrorRt176 -> {
                Log.d("MainViewModelRt171", "error hockey -${result.message}")
                _state.value.copy(
                    isLoading = false,
                    message = "Проверьте интернет соединение"
                )
                    .fusUpdateStateUIRt171()
            }

            is ResourceRt176.SuccessRt176 -> {
                Log.d("MainViewModelRt171", "hockey -${result.dvt}")
                _state.value.copy(
                    isLoading = false,
                    message = "",
                    allHockey = result.dvt?: emptyList()
                )
                    .fusUpdateStateUIRt171()
                if (!result.dvt?.filter { it.isPlay }.isNullOrEmpty()) {
                    _state.value.copy(
                        liveHockeyData = result.dvt?.filter { it.isPlay }?: emptyList()
                    )
                        .fusUpdateStateUIRt171()
                }
            }
        }
    }


    fun onEventRt171(mainEvent: ApplicationEventRt176) {
        when (mainEvent) {
            is ApplicationEventRt176.OnSetApplicationStateRt176 -> {
                _state.value.copy(
                    applicationStRt176 = mainEvent.applicationStRt176
                )
                    .fusUpdateStateUIRt171()
            }
            is ApplicationEventRt176.OnSetSelectedDateRt176 -> {
                _state.value.copy(
                    selectedDate = mainEvent.selectedDate
                )
                    .fusUpdateStateUIRt171()
                viewModelScope.launch {
                    async { getFootballDataRt171() }.onAwait
                    async { getBasketballDataRt171() }.onAwait
                    async { getHockeyDataRt171() }.onAwait
                }
            }
            is ApplicationEventRt176.OnUpdateProfileRt176 -> TODO()
        }
    }




    private suspend fun getUrlRt176() {
        remoteRepositoryRt176.getUrlrt176()
        remoteRepositoryRt176.remoteData.collect { result ->
            when (result) {
                is ResourceRt176.ErrorRt176 -> {
                    Log.d("MainViewModelRt145", "url error -${result.message}")
                    _state.value.copy(
                        isLoadingUrl = false,
                        applicationStRt176 = ApplicationStRt176.StartRt176()
                    )
                        .fusUpdateStateUIRt171()

                }

                is ResourceRt176.SuccessRt176 -> {
                    if (result.dvt != null) {
                        if (result.dvt.isNotBlank()) {
                            _state.value.copy(
                                isLoadingUrl = false,
                                destinationUrl = result.dvt,
                                applicationStRt176 = ApplicationStRt176.StartRt176()
                            )
                                .fusUpdateStateUIRt171()
                            Log.d(
                                "MainViewModelRt171",
                                "url SUCCESS -${_state.value.destinationUrl}"
                            )
                            remoteRepositoryRt176.setSharedUrlrt176(_state.value.destinationUrl)
                        }
                    }
                }
            }
        }
    }

    private fun MainStateRt176.fusUpdateStateUIRt171() {
        println("setSharedUrlRt14fyuiuirt145uf544")
        println("setSharedUrlRt14fyutttytiuirt145uf544")
        _state.update {
            this
        }
    }
}