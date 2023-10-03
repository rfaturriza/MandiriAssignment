package com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen

import com.rizz.mandiri.assignment.core.presentation.UiEvent
import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.core.viewModel.BaseViewModel
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetGenresUseCase
import com.rizz.mandiri.assignment.root.MovieNav
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GenreListViewModel @Inject constructor(
    private val getGenres: GetGenresUseCase,
) : BaseViewModel<GenreState, GenreEvent>() {
    override fun defaultState(): GenreState = GenreState()

    override fun onEvent(event: GenreEvent) {
        when (event) {
            is GenreEvent.GetGenres -> onGetGenres()
            is GenreEvent.NavigateToMovieList -> sendEvent(
                UiEvent.Navigate(MovieNav.MovieList.route, event.genre)
            )
        }
    }

    private fun onGetGenres() = asyncWithState {
        getGenres().collect {
            when (it) {
                is Resource.Loading -> sendEvent(UiEvent.ShowLoading())

                is Resource.Success -> {
                    commit {
                        copy(
                            genresResult = Pair(true, it.data)
                        )
                    }
                    sendEvent(UiEvent.Success)
                    Timber.d("onGetGenres: ${it.data}")
                }

                is Resource.Error -> {
                    commit {
                        copy(
                            genresResult = Pair(false, null)
                        )
                    }
                    sendEvent(UiEvent.ShowSnackBar(it.message))
                    Timber.d("onGetGenres Error: ${it.message}")
                }
            }
        }
    }

}