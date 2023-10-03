package com.rizz.mandiri.assignment.root

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rizz.mandiri.assignment.core.presentation.BaseScreenWrapper
import com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen.GenreListScreen
import com.rizz.mandiri.assignment.features.movie.presentation.genreListScreen.GenreListViewModel

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
    }
}

sealed class MovieNav(val route: String) {
    data object GenreList : MovieNav("genre_list")
    data object MovieList : MovieNav("movie_list")
    data object MovieDetail : MovieNav("movie_detail")
}