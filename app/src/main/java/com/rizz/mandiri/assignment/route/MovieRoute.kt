package com.rizz.mandiri.assignment.route

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rizz.mandiri.assignment.core.presentation.BaseScreenWrapper
import com.rizz.mandiri.assignment.core.utils.Constants.Companion.BUNDLE_ARG_KEY
import com.rizz.mandiri.assignment.features.movie.domain.entities.GenreEntity
import com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen.GenreListScreen
import com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen.GenreListViewModel
import com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen.MovieListEvent
import com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen.MovieListScreen
import com.rizz.mandiri.assignment.features.movie.presentation.movieListScreen.MovieListViewModel

fun NavGraphBuilder.movieNavigation(
    navController: NavHostController,
) {
    navigation(
        route = Graph.MOVIE,
        startDestination = MovieNav.GenreList.route
    ) {
        composable(route = MovieNav.GenreList.route) {
            val viewModel = hiltViewModel<GenreListViewModel>()
            val state by viewModel.state.collectAsState()
            BaseScreenWrapper(navController = navController, viewModel = viewModel) {
                GenreListScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                )
            }
        }
        composable(route = MovieNav.MovieList.route) {
            val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
            val data = savedStateHandle?.get<GenreEntity>(BUNDLE_ARG_KEY)
            val viewModel = hiltViewModel<MovieListViewModel>()
            val state by viewModel.state.collectAsState()
            viewModel.onEvent(MovieListEvent.SetGenre(data))
            BaseScreenWrapper(navController = navController, viewModel = viewModel) {
                MovieListScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                )
            }
        }
        composable(route = MovieNav.MovieDetail.route) {
            // TODO: Change to MovieDetailViewModel
            val viewModel = hiltViewModel<MovieListViewModel>()
            val state by viewModel.state.collectAsState()
            BaseScreenWrapper(navController = navController, viewModel = viewModel) {
                Box() {
                    // TODO: Add Movie Detail Screen
                }
            }
        }
    }
}

sealed class MovieNav(val route: String) {
    data object GenreList : MovieNav("genre_list")
    data object MovieList : MovieNav("movie_list")
    data object MovieDetail : MovieNav("movie_detail")
}