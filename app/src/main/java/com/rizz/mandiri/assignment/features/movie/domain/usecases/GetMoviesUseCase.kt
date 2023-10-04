package com.rizz.mandiri.assignment.features.movie.domain.usecases

import androidx.paging.PagingData
import com.rizz.mandiri.assignment.features.movie.data.model.request.MovieQuery
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(
        query: MovieQuery
    ): Flow<PagingData<MovieResultEntity>> {
        return repository.getMovieList(query)
    }
}