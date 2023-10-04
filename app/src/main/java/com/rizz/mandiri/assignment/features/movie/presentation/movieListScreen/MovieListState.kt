package com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen

import androidx.paging.PagingData
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import kotlinx.coroutines.flow.Flow

data class MovieListState(
    val genre : GenreEntity? = null,
    val movies : Flow<PagingData<MovieResultEntity>>? = null,
)