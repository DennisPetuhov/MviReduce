package com.example.mvireduce.Recycler

import com.example.mvireduce.ToDoItem


fun interface AdapteActions {

    fun onClick(toDoItem: ToDoItem)
}