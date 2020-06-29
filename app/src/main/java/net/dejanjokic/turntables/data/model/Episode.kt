package net.dejanjokic.turntables.data.model

import com.squareup.moshi.Json
import net.dejanjokic.turntables.core.Constants
import net.dejanjokic.turntables.core.Constants.API.IMG_BASE_URL

data class Episode(
    @field:Json(name = "air_date") val airDate: String = "",
    @field:Json(name = "episode_number") val episodeNumber:Int = 0,
    @field:Json(name = "season_number") val seasonNumber: Int = 0,
    @field:Json(name = "name") val title: String = "",
    @field:Json(name = "overview") val overview: String = "",
    @field:Json(name = "still_path") val stillPath: String = "",
    @field:Json(name = "vote_average") val voteAverage: Double = 0.0
)

fun Episode.fullPosterPath() = IMG_BASE_URL + stillPath