package com.rizz.mandiri.assignment.features.movie.presentation.movieDetailScreen

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rizz.mandiri.assignment.core.presentation.UiEvent
import com.rizz.mandiri.assignment.core.utils.Resource.Error
import com.rizz.mandiri.assignment.core.utils.Resource.Loading
import com.rizz.mandiri.assignment.core.utils.Resource.Success
import com.rizz.mandiri.assignment.core.viewModel.BaseViewModel
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetDetailMoviesByIdUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetReviewByMovieIdUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetVideoByMovieIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val getDetailMovie: GetDetailMoviesByIdUseCase,
    private val getReviewers: GetReviewByMovieIdUseCase,
    private val getTrailers: GetVideoByMovieIdUseCase,
) : BaseViewModel<DetailMovieState, DetailMovieEvent>() {
    override fun defaultState(): DetailMovieState = DetailMovieState()

    override fun onEvent(event: DetailMovieEvent) {
        when (event) {
            is DetailMovieEvent.SetMovie -> onSetMovie(event.movie)
            is DetailMovieEvent.GetDetailMovie -> onGetDetailMovie()
            is DetailMovieEvent.GetReviewers -> onGetReviewers()
            is DetailMovieEvent.GetTrailers -> onGetTrailers()

            is DetailMovieEvent.NavigateBack -> sendEvent(
                UiEvent.NavigateBack
            )

            is DetailMovieEvent.CloseDialog -> commit {
                copy(
                    isDialogOpen  = false
                )
            }
            is DetailMovieEvent.OpenDialog -> commit {
                copy(
                    isDialogOpen  = true
                )
            }
        }
    }

    private fun onSetMovie(movie: MovieResultEntity?) = commit {
        copy(movie = movie)
    }

    private fun onGetReviewers() = asyncWithState {
        val reviews = movie?.id?.let { getReviewers(it) }?.cachedIn(viewModelScope)
        commit {
            copy(
                reviewers = reviews
            )
        }
    }

    private fun onGetTrailers() = asyncWithState {
        movie?.id?.let { getTrailers(it) }?.collect {result ->
            when (result) {
                is Loading -> commit {
                    copy(
                        isFetchingTrailers = true
                    )
                }

                is Success -> {
                    commit {
                        copy(
                            trailers = result.data.results.filter {
                                it.site == "YouTube" && it.type == "Trailer"
                            },
                            isFetchingTrailers = false
                        )
                    }
                    Timber.d("onGetTrailers: ${result.data}")
                }

                is Error -> {
                    commit {
                        copy(
                            trailers = null,
                            isFetchingTrailers = false
                        )
                    }
                    sendEvent(UiEvent.ShowSnackBar(result.message))
                    Timber.d("onGetTrailers Error: ${result.message}")
                }
            }

        }
    }

    private fun onGetDetailMovie() = asyncWithState {
        movie?.id?.let { getDetailMovie(it) }?.collect { result ->
            when (result) {
                is Loading -> commit {
                    copy(
                        isFetchingDetail = true
                    )
                }

                is Success -> {
                    commit {
                        copy(
                            detailMovie = result.data,
                            isFetchingDetail = false
                        )
                    }
                    Timber.d("onGetDetailMovie: ${result.data}")
                }

                is Error -> {
                    commit {
                        copy(
                            detailMovie = null,
                            isFetchingDetail = false
                        )
                    }
                    sendEvent(UiEvent.ShowSnackBar(result.message))
                    Timber.d("onGetDetailMovie Error: ${result.message}")
                }
            }

        }
    }

}