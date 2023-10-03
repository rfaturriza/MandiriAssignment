package com.rizz.mandiri.assignment.features.movie.data.model.response

import com.google.gson.annotations.SerializedName
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity

data class GenreResponse(
    @SerializedName("genres")
    val gendre: List<Genres>?,
)

data class Genres(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
) {
    fun toEntity(): GenreEntity {
        return GenreEntity(
            id = id,
            name = name
        )
    }
}
