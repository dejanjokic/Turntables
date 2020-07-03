package net.dejanjokic.turntables.data

object EpisodeUtil {

    private val seasonEpisodeCounts = arrayOf(6, 22, 25, 19, 26, 26, 26, 24, 27)

    fun getRandomSeasonEpisodePair(): Pair<Int, Int> {
        val seasonEpisodePairs = mutableListOf<Pair<Int, Int>>()
        for (i in seasonEpisodeCounts.indices) {
            for (j in 1..seasonEpisodeCounts[i]) {
                seasonEpisodePairs.add(Pair(i+1, j))
            }
        }
        return seasonEpisodePairs.random()
    }
}