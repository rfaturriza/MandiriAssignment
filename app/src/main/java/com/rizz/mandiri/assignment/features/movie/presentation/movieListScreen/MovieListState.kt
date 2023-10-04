package com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen

import androidx.paging.PagingData
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import kotlinx.coroutines.flow.Flow

data class MovieListState(
    val page: Int = 1,
    val totalPages: Int? = null,
    val totalResults: Int? = null,
    val genre : GenreEntity? = null,
    val isLoading: Boolean = false,
    val movies : Flow<PagingData<MovieResultEntity>>? = null,
)