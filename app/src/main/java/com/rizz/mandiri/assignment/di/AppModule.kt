package com.rizz.mandiri.assignment.di

import com.rizz.mandiri.assignment.core.http.AuthInterceptor
import com.rizz.mandiri.assignment.core.http.OkHttpClientFactory
import com.rizz.mandiri.assignment.core.utils.Constants.Companion.BASE_URL
import com.rizz.mandiri.assignment.features.movie.data.dataSource.remote.MovieApi
import com.rizz.mandiri.assignment.features.movie.data.repositories.MovieRepositoryImpl
import com.rizz.mandiri.assignment.features.movie.domain.repositories.MovieRepository
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetDetailMoviesByIdUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetGenresUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetMoviesUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetReviewByMovieIdUseCase
import com.rizz.mandiri.assignment.features.movie.domain.usecases.GetVideoByMovieIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClientFactory.create(
            interceptors = arrayOf(
                AuthInterceptor()
            ),
        )
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieAPI(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetGenresUseCase(repository: MovieRepository): GetGenresUseCase {
        return GetGenresUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetDetailMovieUseCase(repository: MovieRepository): GetDetailMoviesByIdUseCase {
        return GetDetailMoviesByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetReviewsUseCase(repository: MovieRepository): GetReviewByMovieIdUseCase {
        return GetReviewByMovieIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetVideosUseCase(repository: MovieRepository): GetVideoByMovieIdUseCase {
        return GetVideoByMovieIdUseCase(repository)
    }

}