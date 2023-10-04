package com.rizz.mandiri.assignment.features.movie.domain.repositories

import androidx.paging.PagingData
import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.features.movie.data.model.request.MovieQuery
import com.rizz.mandiri.assignment.features.movie.domain.entities.DetailMovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.ReviewEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.VideoEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
     fun getMovieList(query: MovieQuery): Flow<PagingData<MovieResultEntity>>
    suspend fun getMovieDetail(movieId: Int): Resource<DetailMovieEntity>
    suspend fun getMovieReview(movieId: Int, page: Int): Resource<ReviewEntity>
    suspend fun getMovieVideo(movieId: Int): Resource<VideoEntity>
    suspend fun getMovieGenre(): Resource<List<GenreEntity>>
}