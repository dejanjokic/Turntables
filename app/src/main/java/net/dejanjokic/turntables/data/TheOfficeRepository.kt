package net.dejanjokic.turntables.data

import net.dejanjokic.turntables.data.remote.ApiService
import javax.inject.Inject

class TheOfficeRepository @Inject constructor(private val api: ApiService) {

    suspend fun getRandomEpisode(season: Int, episode: Int) =
        api.getRandomEpisode(season = season, episode = episode)
}