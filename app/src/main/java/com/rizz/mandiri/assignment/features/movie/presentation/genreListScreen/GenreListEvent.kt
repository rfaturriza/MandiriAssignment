package com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen

import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity

sealed interface GenreListEvent {
    data class NavigateToMovieList(
        val genre: GenreEntity
    ) : GenreListEvent
    data object GetGenres : GenreListEvent
}