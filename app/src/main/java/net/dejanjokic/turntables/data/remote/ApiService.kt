package net.dejanjokic.turntables.data.remote

import net.dejanjokic.turntables.core.Constants.API.THE_OFFICE_ID
import net.dejanjokic.turntables.data.model.Episode
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    suspend fun getRandomEpisode(
        @Path("tv_id") id: Int = THE_OFFICE_ID,
        @Path("season_number") season: Int,
        @Path("episode_number") episode: Int
    ): Episode
}