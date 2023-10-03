package com.rizz.mandiri.assignment.features.movie.data.dataSource.remote

import com.rizz.mandiri.assignment.features.movie.data.model.response.DetailMovieResponse
import com.rizz.mandiri.assignment.features.movie.data.model.response.GenreResponse
import com.rizz.mandiri.assignment.features.movie.data.model.response.MovieResponse
import com.rizz.mandiri.assignment.features.movie.data.model.response.ReviewMovieResponse
import com.rizz.mandiri.assignment.features.movie.data.model.response.VideoMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface MovieApi {
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("language") language: String = "en"
    ): retrofit2.Response<GenreResponse>

    @GET("discover/movie")
    suspend fun getMovies(
        @QueryMap query: Map<String, String>
    ): retrofit2.Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ): retrofit2.Response<DetailMovieResponse>

    @GET("movie/{movie_id}/videos")
    suspend fun getVideos(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ): retrofit2.Response<VideoMovieResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviews(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): retrofit2.Response<ReviewMovieResponse>

}