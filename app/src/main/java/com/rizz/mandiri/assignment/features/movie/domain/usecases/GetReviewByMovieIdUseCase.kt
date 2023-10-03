package com.rizz.mandiri.assignment.features.movie.domain.usecases

import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.core.utils.responseFlow
import com.rizz.mandiri.assignment.features.movie.domain.entities.ReviewEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetReviewByMovieIdUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(
        movieID: Int,
        page: Int
    ): Flow<Resource<ReviewEntity>> {
        return responseFlow {
            repository.getMovieReview(
                movieId = movieID,
                page = page
            )
        }
    }
}