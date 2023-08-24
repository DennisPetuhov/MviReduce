package com.example.mvireduce.Recycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvireduce.ToDoItem
import com.example.mvireduce.databinding.MyLayoutBinding

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private var myList: List<ToDoItem> = mutableListOf() // ?=null
    private var action: AdapteActions? = null


    fun bindAction(action: AdapteActions) {

        this.action = action
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = MyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val toDoItem: ToDoItem = myList[position]
        holder.binding.textView2.text = toDoItem.id.toString()
        holder.binding.textView3.text = toDoItem.text
        holder.binding.textView4.text = toDoItem.done.toString()
//        holder.itemView.setOnLongClickListener {
//            actions?.let {
//                it.onLongClick(toDoItem.original_title.toString())
//                Toast.makeText(holder.itemView.context, "${toDoItem.id}", Toast.LENGTH_LONG).show()
//
//            }
//            true
//        }
        holder.itemView.setOnClickListener {

            action?.onClick(toDoItem)


        }
    }

    override fun getItemCount(): Int {
        return myList.size

    }

    fun updateList(list: List<ToDoItem>) {
        val diffCallBack = MovieDiffUtill(myList, list)
        val difference = DiffUtil.calculateDiff(diffCallBack, true)
        myList = list
        difference.dispatchUpdatesTo(this)
        //        movieList.clear()
//        movieList.addAll(list)
//        notifyDataSetChanged()


    }


}