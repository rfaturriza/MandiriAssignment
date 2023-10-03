package com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen

import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity

sealed interface GenreEvent {
    data class NavigateToMovieList(
        val genre: GenreEntity
    ) : GenreEvent
    data object GetGenres : GenreEvent
}