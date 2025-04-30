package com.example.tweetsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.repositoryImpl.TweetsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tweetsRepoImpl: TweetsRepositoryImpl) :
    ViewModel() {

    val categories: StateFlow<List<String>>
        get() = tweetsRepoImpl.categories

    init {
        viewModelScope.launch {
            tweetsRepoImpl.getCategories()
        }
    }

}