package com.example.tweetsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.models.TweetsListItem
import com.example.tweetsapp.repositoryImpl.TweetsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val tweetsRepoImpl: TweetsRepositoryImpl) :
    ViewModel() {

    val tweets: StateFlow<List<TweetsListItem>>
        get() = tweetsRepoImpl.tweets

    init {
        viewModelScope.launch {
            tweetsRepoImpl.getTweets(category = "Android")
        }
    }

}