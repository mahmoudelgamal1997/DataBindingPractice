package com.example.databindingpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.databindingpractice.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val viewmodel by lazy { ViewModelProviders.of(this).get(MainActivityViewModel::class.java)  }

   lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



       val binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

     //   binding.lifecycleOwner = this





        // bind RecyclerView
        recyclerView = binding.viewEmployees
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)

        getAllEmploy()

    }


    fun getAllEmploy(){
        viewmodel.getEmploy().observe(this, Observer{



            recyclerView.adapter = RecyclerAdapter(it.data)

        })
    }

}
