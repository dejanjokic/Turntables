package net.dejanjokic.turntables.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.dejanjokic.turntables.data.TheOfficeRepository
import timber.log.Timber

class MainViewModel @ViewModelInject constructor(private val repository: TheOfficeRepository) : ViewModel() {

    val viewState = MutableLiveData<MainViewState>()

    init {
        Timber.d("State: Empty")
        viewState.postValue(MainViewState.Empty)
    }

    fun getRandomEpisode(season: Int, episode: Int) {
        Timber.d("State: Loading")
        viewState.postValue(MainViewState.Loading)
        viewModelScope.launch {
            try {
                val episodeResponse = repository.getRandomEpisode(season, episode)
                viewState.postValue(MainViewState.Success(episodeResponse))
                Timber.d("State: Success")
            } catch (e: Exception) {
                Timber.d("State: Error")
                viewState.postValue(MainViewState.Error(e.localizedMessage ?: "An error has occurred"))
            }
        }
    }
}