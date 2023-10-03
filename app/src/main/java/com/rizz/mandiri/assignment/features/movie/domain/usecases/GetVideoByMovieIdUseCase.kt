package com.rizz.mandiri.assignment.features.movie.domain.usecases

import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.core.utils.responseFlow
import com.rizz.mandiri.assignment.features.movie.domain.entities.VideoEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetVideoByMovieIdUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(
        movieID: Int
    ): Flow<Resource<VideoEntity>> {
        return responseFlow { repository.getMovieVideo(movieID) }
    }
}