package com.example.mvireduce

class ToDoListReducer() {

    fun reduce(
        toDoListViewState: ToDoListViewState,
        toDoListAction: ToDoListAction
    ): ToDoListViewState {

        return when (toDoListAction) {
            is ToDoListAction.LoadData -> {
                toDoListViewState

            }

            is ToDoListAction.ToggleItem -> {
                val updated = toDoListViewState.items.map {
                  if  (it.id == toDoListAction.id ){
                      it.copy(done = !it.done )

                  } else {it}


                }
                toDoListViewState.copy(items = updated)

            }

            is ToDoListAction.AddDoneItem -> {
                val newItem = ToDoItem(
                    id = toDoListViewState.items.size + 1,
                    text = toDoListAction.text,
                    done = true
                )
                val updatedItems = toDoListViewState.items + newItem
                toDoListViewState.copy(items = updatedItems)
            }

            is ToDoListAction.AddUnDoneItem -> {
                val newItem = ToDoItem(
                    id = toDoListViewState.items.size + 1,
                    text = toDoListAction.text,
                    done = false
                )
                val updatedItems = toDoListViewState.items + newItem
                toDoListViewState.copy(items = updatedItems)
            }
        }

    }
}