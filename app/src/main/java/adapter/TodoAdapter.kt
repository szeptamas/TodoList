package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.szeptamas.todolist.R
import data.Todo
import kotlinx.android.synthetic.main.todo_row.view.*

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    var todoItems = mutableListOf<Todo>(
        Todo("2020.01.01", false, "Mosogatni"),
        Todo("2020.02.02", false, "Takarítani"),
        Todo("2020.03.03", false, "Kifesteni a házat")
    )

    val context : Context
    constructor(context: Context) : super() {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val todoView = LayoutInflater.from(context).inflate(R.layout.todo_row, parent, false)
        return ViewHolder(todoView)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var todoItem = todoItems[position]

        holder.tvDate.text = todoItem.createDate
        holder.cbDone.isChecked = todoItem.done
        holder.cbDone.text = todoItem.todoText
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDate = itemView.tvDate
        var cbDone = itemView.cbDone
    }
}