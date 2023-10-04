package com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen

import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity

sealed interface MovieListEvent {
    data class NavigateToDetail(
        val movie: MovieResultEntity
    ) : MovieListEvent

    data class SetGenre(
        val genre: GenreEntity?
    ) : MovieListEvent

    data object GetMovies : MovieListEvent

    data object NavigateBack : MovieListEvent
}