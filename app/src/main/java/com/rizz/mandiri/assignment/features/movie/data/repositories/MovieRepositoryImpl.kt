package com.rizz.mandiri.assignment.features.movie.data.repositories

import com.rizz.mandiri.assignment.core.repository.BaseRepository
import com.rizz.mandiri.assignment.core.utils.Resource
import com.rizz.mandiri.assignment.features.movie.data.dataSource.remote.MovieApi
import com.rizz.mandiri.assignment.features.movie.data.model.request.MovieQuery
import com.rizz.mandiri.assignment.features.movie.data.model.response.GenreResponse
import com.rizz.mandiri.assignment.features.movie.domain.entities.DetailMovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.MovieEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.ReviewEntity
import com.rizz.mandiri.assignment.features.movie.domain.entities.VideoEntity
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository,
    BaseRepository() {
    override suspend fun getMovieList(query: MovieQuery): Resource<MovieEntity> {
        return when (val res = safeApiCall { api.getMovies(query.toMap()) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Resource<DetailMovieEntity> {
        return when (val res = safeApiCall { api.getDetailMovie(movieId) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override suspend fun getMovieReview(movieId: Int, page: Int): Resource<ReviewEntity> {
        return when (val res = safeApiCall { api.getReviews(movieId, page = page) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override suspend fun getMovieVideo(movieId: Int): Resource<VideoEntity> {
        return when (val res = safeApiCall { api.getVideos(movieId) }) {
            is Resource.Success -> Resource.Success(res.data.toEntity())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

    override suspend fun getMovieGenre(): Resource<List<GenreEntity>> {
//        return safeApiCall { api.getGenres() }
        return when (val res = safeApiCall { api.getGenres() }) {
            is Resource.Success -> Resource.Success(res.data.gendre?.map { it.toEntity() } ?: emptyList())
            is Resource.Error -> Resource.Error(res.message)
            is Resource.Loading -> Resource.Loading
        }
    }

}