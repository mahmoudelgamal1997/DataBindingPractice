package com.example.databindingpractice

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingpractice.Repository.Repository

class MainActivityViewModel() : ViewModel() {

    val repository:Repository= Repository()

    fun getEmploy():LiveData<EmploeeModel>{
       return repository.getEmploees()
    }





}