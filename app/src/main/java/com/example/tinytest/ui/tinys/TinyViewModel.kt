package com.example.tinytest.ui.tinys

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinytest.model.TinyRepository
import com.example.tinytest.model.response.Tiny
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TinyViewModel (private val repository: TinyRepository = TinyRepository()) : ViewModel(){

        val tin : MutableState<List<Tiny>> = mutableStateOf(emptyList())

        init{
            viewModelScope.launch(Dispatchers.IO) {
                tin.value = getMeals()
            }
        }

        private suspend fun getMeals(): List<Tiny>{

            return repository.getTiny()
        }
    }
