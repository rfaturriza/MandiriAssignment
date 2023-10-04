package com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen

import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity

data class GenreListState(
    val isLoading: Boolean = false,
    val genresResult: Pair<Boolean, List<GenreEntity>?> = Pair(false, emptyList())
)