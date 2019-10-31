package com.example.databindingpractice

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import com.example.databindingpractice.databinding.RecyclerviewFrameBinding


class RecyclerAdapter (val data:List<Data>): RecyclerView.Adapter<RecyclerAdapter.EmployeeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding:RecyclerviewFrameBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.recyclerview_frame,parent
            ,false)

        return EmployeeViewHolder(binding)
    }



    override fun getItemCount(): Int {
    return data.size
    }


    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {


        holder.bind(data[position])

    }



    class EmployeeViewHolder(private val binding : RecyclerviewFrameBinding) :
        RecyclerView.ViewHolder(binding.getRoot())
     {

         fun bind(data: Any) {
             binding.setVariable(BR.employee, data)
             binding.executePendingBindings()
         }

     }
}

