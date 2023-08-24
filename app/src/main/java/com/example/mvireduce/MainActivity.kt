package com.example.mvireduce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mvireduce.Recycler.MyAdapter
import com.example.mvireduce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var currentState: ToDoListViewState = ToDoListViewState(emptyList())
    private val myReducer = ToDoListReducer()

    private val adapter = MyAdapter()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecycler()

        binding.button.setOnClickListener {

            currentState = myReducer.reduce(currentState, ToDoListAction.AddDoneItem("Done"))
            adapter.updateList(currentState.items)

        }
        binding.update.setOnClickListener {
            currentState = myReducer.reduce(currentState, ToDoListAction.AddUnDoneItem("UnDone"))
            adapter.updateList(currentState.items)
        }


    }


    private fun initRecycler() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        adapter.bindAction {
            currentState = myReducer.reduce(currentState, ToDoListAction.ToggleItem(it.id))
            adapter.updateList(currentState.items)
        }


    }


}