package net.dejanjokic.turntables.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import coil.api.load
import dagger.hilt.android.AndroidEntryPoint
import net.dejanjokic.turntables.R
import net.dejanjokic.turntables.data.EpisodeUtil
import net.dejanjokic.turntables.data.model.fullPosterPath
import net.dejanjokic.turntables.databinding.ActivityMainBinding
import net.dejanjokic.turntables.ui.MainViewState.*
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.fab.setOnClickListener {
            val seasonEpisode = EpisodeUtil.getRandomSeasonEpisodePair()
            viewModel.getRandomEpisode(seasonEpisode.first, seasonEpisode.second)
        }

        viewModel.viewState.observe(this, Observer { state ->
            when (state) {
                is Empty -> {
                    viewBinding.apply {
                        contentMain.isVisible = true
                        progressBar.isVisible = false
                        textViewStatus.isVisible = true

                        textViewStatus.text = getString(R.string.empty_message)
                    }
                }
                is Success -> {
                    viewBinding.apply {
                        contentMain.isVisible = true
                        progressBar.isVisible = false
                        textViewStatus.isVisible = false

                        val episode = state.episode
                        Timber.d(episode.fullPosterPath())
                        imageViewEpisodePoster.load(episode.fullPosterPath()) {
                            crossfade(true)
                            placeholder(R.drawable.ic_help)
                        }
                        textViewEpisodeTitle.text = getString(R.string.episode_number_title,
                            episode.seasonNumber, episode.episodeNumber, episode.title
                        )
                        textViewEpisodeOverview.text = episode.overview
                    }
                }
                is Error -> {
                    viewBinding.apply {
                        contentMain.isVisible = true
                        progressBar.isVisible = false
                        textViewStatus.isVisible = true

                        textViewStatus.text = state.message
                    }
                }
                is Loading -> {
                    viewBinding.apply {
                        contentMain.isVisible = false
                        progressBar.isVisible = true
                        textViewStatus.isVisible = false
                    }
                }
            }
        })
    }
}