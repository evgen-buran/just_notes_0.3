package com.example.justnotes03.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justnotes03.R
import com.example.justnotes03.room.AppNote


class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private var listNotes: List<AppNote> = emptyList()

    class MainHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvItemTitleNote)
        val tvText: TextView = view.findViewById(R.id.tvItemTextNotes)
    }


    //определить разметку для элемента списка, именно он передается в ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MainHolder(view)

    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    // связывание вьюшек холдера-итема с полями AppNotes
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.tvTitle.text = listNotes[position].titleNote
        holder.tvText.text = listNotes[position].textNote
    }


    //назначение слушателя клика на item
    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{MainFragment.click(listNotes.get(holder.adapterPosition))}
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun setList(list: List<AppNote>) {
        listNotes = list
        notifyDataSetChanged()
    }
}
