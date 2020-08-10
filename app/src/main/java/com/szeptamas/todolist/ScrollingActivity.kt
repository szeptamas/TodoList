package com.szeptamas.todolist

import com.szeptamas.todolist.adapter.TodoAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.szeptamas.todolist.data.Todo
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity(), TodoDialog.TodoHandler {

    lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))

        todoAdapter = TodoAdapter(this)
        recyclerTodo.adapter = todoAdapter

        fab.setOnClickListener {
            TodoDialog().show(supportFragmentManager, "Dialog")
        }
    }

    override fun todoCreated(todo: Todo) {
        todoAdapter.addTodo(todo)
    }

}