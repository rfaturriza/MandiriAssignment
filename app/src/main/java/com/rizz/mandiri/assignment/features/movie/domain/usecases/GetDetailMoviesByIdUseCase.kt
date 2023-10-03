package com.rizz.mandiri.assignment.features.movie.domain.usecases

import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.core.utils.responseFlow
import com.rizz.mandiri.assignment.features.movie.data.model.request.MovieQuery
import com.rizz.mandiri.assignment.features.movie.domain.entities.DetailMovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetDetailMoviesByIdUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(
        movieID: Int
    ): Flow<Resource<DetailMovieEntity>> {
        return responseFlow { repository.getMovieDetail(movieID) }
    }
}