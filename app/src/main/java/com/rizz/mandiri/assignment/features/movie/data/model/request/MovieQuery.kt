package com.rizz.mandiri.assignment.features.movie.data.model.request

import com.google.gson.annotations.SerializedName

data class MovieQuery(
    @SerializedName("include_adult")
    val includeAdult: Boolean = false,
    @SerializedName("include_video")
    val includeVideo: Boolean = true,
    @SerializedName("language")
    val language: String = "en",
    @SerializedName("page")
    val page: Int = 1,
    @SerializedName("primary_release_year")
    val primaryReleaseYear: Int? = null,
    @SerializedName("primary_release_date.gte")
    val primaryReleaseDateGte: String? = null,
    @SerializedName("primary_release_date.lte")
    val primaryReleaseDateLte: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("release_date.gte")
    val releaseDateGte: String? = null,
    @SerializedName("release_date.lte")
    val releaseDateLte: String? = null,
    @SerializedName("sort_by")
    val sortBy: String = "popularity.desc",
    @SerializedName("vote_average.gte")
    val voteAverageGte: Double? = null,
    @SerializedName("vote_average.lte")
    val voteAverageLte: Double? = null,
    @SerializedName("vote_count.gte")
    val voteCountGte: Int? = null,
    @SerializedName("vote_count.lte")
    val voteCountLte: Int? = null,
    @SerializedName("watch_region")
    val watchRegion: String? = null,
    @SerializedName("with_cast")
    val withCast: String? = null,
    @SerializedName("with_companies")
    val withCompanies: String? = null,
    @SerializedName("with_crew")
    val withCrew: String? = null,
    @SerializedName("with_genres")
    val withGenres: String? = null,
    @SerializedName("with_keywords")
    val withKeywords: String? = null,
    @SerializedName("with_origin_country")
    val withOriginCountry: String? = null,
    @SerializedName("with_original_language")
    val withOriginalLanguage: String? = null,
    @SerializedName("with_people")
    val withPeople: String? = null,
    @SerializedName("with_release_type")
    val withReleaseType: Int? = null,
    @SerializedName("with_runtime.gte")
    val withRuntimeGte: Int? = null,
    @SerializedName("with_runtime.lte")
    val withRuntimeLte: Int? = null,
    @SerializedName("with_watch_monetization_types")
    val withWatchMonetizationTypes: String? = null,
    @SerializedName("with_watch_providers")
    val withWatchProviders: String? = null,
    @SerializedName("without_companies")
    val withoutCompanies: String? = null,
    @SerializedName("without_genres")
    val withoutGenres: String? = null,
    @SerializedName("without_keywords")
    val withoutKeywords: String? = null,
    @SerializedName("without_watch_providers")
    val withoutWatchProviders: String? = null,
    @SerializedName("year")
    val year: Int? = null,
) {
    fun toMap(): Map<String, String> {
        return mapOf(
            "include_adult" to includeAdult.toString(),
            "include_video" to includeVideo.toString(),
            "language" to language,
            "page" to page.toString(),
            "primary_release_year" to primaryReleaseYear.toString(),
            "primary_release_date.gte" to primaryReleaseDateGte.toString(),
            "primary_release_date.lte" to primaryReleaseDateLte.toString(),
            "region" to region.toString(),
            "release_date.gte" to releaseDateGte.toString(),
            "release_date.lte" to releaseDateLte.toString(),
            "sort_by" to sortBy,
            "vote_average.gte" to voteAverageGte.toString(),
            "vote_average.lte" to voteAverageLte.toString(),
            "vote_count.gte" to voteCountGte.toString(),
            "vote_count.lte" to voteCountLte.toString(),
            "watch_region" to watchRegion.toString(),
            "with_cast" to withCast.toString(),
            "with_companies" to withCompanies.toString(),
            "with_crew" to withCrew.toString(),
            "with_genres" to withGenres.toString(),
            "with_keywords" to withKeywords.toString(),
            "with_origin_country" to withOriginCountry.toString(),
            "with_original_language" to withOriginalLanguage.toString(),
            "with_people" to withPeople.toString(),
            "with_release_type" to withReleaseType.toString(),
            "with_runtime.gte" to withRuntimeGte.toString(),
            "with_runtime.lte" to withRuntimeLte.toString(),
            "with_watch_monetization_types" to withWatchMonetizationTypes.toString(),
            "with_watch_providers" to withWatchProviders.toString(),
            "without_companies" to withoutCompanies.toString(),
            "without_genres" to withoutGenres.toString(),
            "without_keywords" to withoutKeywords.toString(),
            "without_watch_providers" to withoutWatchProviders.toString(),
            "year" to year.toString(),
        )
    }
}
