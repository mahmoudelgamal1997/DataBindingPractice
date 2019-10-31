package com.example.databindingpractice.Repository

import android.telecom.Call
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.databindingpractice.Data
import com.example.databindingpractice.EmploeeModel
import com.example.databindingpractice.api.APIService
import com.example.databindingpractice.api.RetrofitClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Repository (){

    val _employeesData=MutableLiveData<EmploeeModel>()
    val employeesData:LiveData<EmploeeModel>
    get()=_employeesData

    val apiService: APIService=RetrofitClient.getClient()

    fun getEmploees():LiveData<EmploeeModel> {


        apiService.getEmployees().enqueue( object :Callback<EmploeeModel> {

            override fun onResponse(call: retrofit2.Call<EmploeeModel>, response: Response<EmploeeModel>) {


                if (response.isSuccessful) {
                    _employeesData.postValue(response.body())

                }else{


                    Log.e("TAGData",response.message())
                }
            }

            override fun onFailure(call: retrofit2.Call<EmploeeModel>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })

        return employeesData
    }

}