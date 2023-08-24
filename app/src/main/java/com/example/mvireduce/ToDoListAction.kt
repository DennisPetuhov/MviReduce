package com.example.mvireduce

sealed class ToDoListAction {
    object LoadData : ToDoListAction()
    data class ToggleItem(val id: Int) : ToDoListAction()
    data class  AddDoneItem(val text: String ):ToDoListAction()
    data class  AddUnDoneItem(val text: String ):ToDoListAction()
}