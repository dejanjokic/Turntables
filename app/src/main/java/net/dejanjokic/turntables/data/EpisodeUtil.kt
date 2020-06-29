package net.dejanjokic.turntables.data

object EpisodeUtil {

    private val seasonEpisodeCounts = arrayOf(6, 22, 25, 19, 26, 26, 26, 24, 27)

    fun getRandomSeasonEpisodePair(): Pair<Int, Int> {
        val season = (1..9).random()
        val count = seasonEpisodeCounts[season-1]
        val episode = (1..count).random()
        return Pair(season, episode)
    }
}