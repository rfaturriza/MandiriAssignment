package com.rizz.mandiri.assignment.features.movie.presentation.movieDetailScreen

import androidx.paging.PagingData
import com.rizz.mandiri.assignment.features.movie.domain.entities.DetailMovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.ReviewResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.VideoResultEntity
import kotlinx.coroutines.flow.Flow

data class DetailMovieState(
    val isDialogOpen: Boolean = false,
    val movie : MovieResultEntity? = null,
    val isFetchingDetail: Boolean = false,
    val isFetchingReviewers: Boolean = false,
    val isFetchingTrailers: Boolean = false,
    val detailMovie : DetailMovieEntity? = null,
    val reviewers : Flow<PagingData<ReviewResultEntity>>? = null,
    val trailers : List<VideoResultEntity>? = null,
)