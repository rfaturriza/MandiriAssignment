package com.rizz.mandiri.assignment.features.movie.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rizz.mandiri.assignment.core.repository.BaseRepository
import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.features.movie.data.dataSource.MoviesPagingSource
import com.rizz.mandiri.assignment.features.movie.data.dataSource.ReviewersPagingSource
import com.rizz.mandiri.assignment.features.movie.data.dataSource.remote.MovieApi
import com.rizz.mandiri.assignment.features.movie.data.model.request.MovieQuery
import com.rizz.mandiri.assignment.features.movie.domain.entities.DetailMovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.ReviewResultEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.VideoEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository,
    BaseRepository() {
    override fun getMovieList(query: MovieQuery): Flow<PagingData<MovieResultEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviesPagingSource(
                    api = api,
                    query = query
                )
            }
        ).flow
    }

    override suspend fun getMovieDetail(movieId: Int): Resource<DetailMovieEntity> {
        return when (val res = safeApiCall { api.getDetailMovie(movieId) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override fun getMovieReview(movieId: Int): Flow<PagingData<ReviewResultEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ReviewersPagingSource(
                    api = api,
                    movieId = movieId
                )
            }
        ).flow
    }

    override suspend fun getMovieVideo(movieId: Int): Resource<VideoEntity> {
        return when (val res = safeApiCall { api.getVideos(movieId) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override suspend fun getMovieGenre(): Resource<List<GenreEntity>> {
        return when (val res = safeApiCall { api.getGenres() }) {
            is Resource.Success -> Resource.Success(res.data.gendre?.map { it.toEntity() }
                ?: emptyList())

            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

}