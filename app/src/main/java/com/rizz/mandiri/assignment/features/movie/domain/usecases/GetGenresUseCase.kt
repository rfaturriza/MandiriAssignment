package com.rizz.mandiri.assignment.features.movie.domain.usecases

import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.core.utils.responseFlow
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetGenresUseCase(
    private val repository: MovieRepository
) {
     operator fun invoke(): Flow<Resource<List<GenreEntity>>> {
        return responseFlow { repository.getMovieGenre() }
    }
}