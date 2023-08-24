package com.example.mvireduce.Recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.mvireduce.ToDoItem


class MovieDiffUtill(private val oldList:List<ToDoItem>, private val newList:List<ToDoItem>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
     return   oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}