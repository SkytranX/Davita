package com.example.davita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_item.view.*

class DataAdapter(private val list: List<DataObject>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    var onClick : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return DataViewHolder(v)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.load(list[position])
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun load(dataObject: DataObject) {
            itemView.apply {
                tvTitle.text = dataObject.title ?: "Null Title"
                tvSubtitle.text = dataObject.subTitle ?: "Null Subtitle"
                onClick?.let {
                    setOnClickListener(it)
                    tag = dataObject
                }
            }
        }
    }
}
