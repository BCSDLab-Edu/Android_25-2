package com.example.android_25_2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(val items: MutableList<ListItem>) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.text_name)
        val rootView: ConstraintLayout = itemView.findViewById(R.id.root_view)

        fun addText(item: ListItem) {
            nameText.text = item.name


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        viewHolder.nameText.text = items[position].name
        viewHolder.rootView.setOnClickListener {
            AlertDialog.Builder(viewHolder.rootView.context)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.dialog_positive_message) { dialog, _ ->
                        items.removeAt(position)
                        notifyItemRemoved(position)
                    dialog.dismiss()
                }
                .setNegativeButton(R.string.dialog_negative_message, null)
                .show()
        }
    }

    override fun getItemCount() = items.size
}

