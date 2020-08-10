package com.szeptamas.todolist

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.szeptamas.todolist.data.Todo
import kotlinx.android.synthetic.main.todo_dialog.view.*
import java.lang.RuntimeException
import java.util.*

class TodoDialog : DialogFragment() {

    interface TodoHandler {
        fun todoCreated(todo: Todo)
    }

    lateinit var todoHandler: TodoHandler

    lateinit var etTodoText: EditText
    lateinit var cbTodoDone: CheckBox

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is TodoHandler) {
            todoHandler = context
        } else {
            throw RuntimeException("The activity is not implementing the TodoHandler interface.")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        dialogBuilder.setTitle("Todo dialog")
        val dialogView = requireActivity().layoutInflater.inflate(R.layout.todo_dialog, null)

        etTodoText = dialogView.etTodotext
        cbTodoDone = dialogView.cbTodoDone

        dialogBuilder.setView(dialogView)

        dialogBuilder.setPositiveButton("OK") {
            dialog, which ->

            todoHandler.todoCreated(
                Todo(
                    Date(System.currentTimeMillis()).toString(),
                    cbTodoDone.isChecked,
                    etTodoText.text.toString()
                )
            )
        }
        dialogBuilder.setNegativeButton("Cancel") {
            dialog, which ->
        }

        return dialogBuilder.create()
    }


}