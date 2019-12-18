package com.developer.kotlinrecylerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_card_item.view.*
import jp.wasabeef.picasso.transformations.CropCircleTransformation



class FamousAdapter(val famouses : MutableList<Famous>) : RecyclerView.Adapter<FamousAdapter.FamousViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamousViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_card_item,parent,false)
        return FamousViewHolder(v)

    }

    override fun getItemCount(): Int {
        return famouses.size
    }
    fun add(item:Famous, position:Int) {
        famouses.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(item:Famous) {
        val position = famouses.indexOf(item)
        famouses.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onBindViewHolder(holder: FamousViewHolder, position: Int) {
        val famous = famouses[position]
        holder.itemView.textView.text = famous.name

        Picasso.get()
            .load(famous.photourl)
            .transform(CropCircleTransformation())
            .into(holder.itemView.imageView)

        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context,"${famous.name} is the best actor in the world.",
            Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnLongClickListener {
            remove(famous)
            return@setOnLongClickListener true
        }
    }


    class FamousViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}