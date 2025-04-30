package com.example.tweetsapp.repositoryImpl

import com.example.tweetsapp.data.repository.TweetsRepository
import com.example.tweetsapp.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepositoryImpl @Inject constructor(private val tweetsRepository: TweetsRepository) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())

    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())

    val tweets: StateFlow<List<TweetsListItem>>
        get() = _tweets

    suspend fun getCategories() {
        val response = tweetsRepository.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()?.distinct()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetsRepository.getTweets(category)
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}