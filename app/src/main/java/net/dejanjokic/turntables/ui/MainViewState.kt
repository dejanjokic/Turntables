package net.dejanjokic.turntables.ui

import net.dejanjokic.turntables.data.model.Episode

sealed class MainViewState {
    object Empty : MainViewState()
    data class Success(val episode: Episode) : MainViewState()
    data class Error(val message: String) : MainViewState()
    object Loading : MainViewState()
}