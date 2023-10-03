package com.rizz.mandiri.assignment.features.movie.domain.entities

data class MovieEntity(
    val page: Int?,
    val results: List<MovieResultEntity>,
    val totalPages: Int?,
    val totalResults: Int?
)

data class MovieResultEntity(
    val id: Int?,
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)
