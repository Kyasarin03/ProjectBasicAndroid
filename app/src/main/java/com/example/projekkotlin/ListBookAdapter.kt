package com.example.projekkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListBookAdapter(
    private val listBook: ArrayList<Book>,
//    private val onClick: (com.example.projekkotlin.Book) -> Unit
) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>()  {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val binding: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_books, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]
        val (name, penulis, description, photo) = listBook[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvPenulis.text = penulis
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listBook[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listBook[holder.adapterPosition])
            val intent = Intent(holder.itemView.context, DetailsBook::class.java)
            intent.putExtra("key_book", listBook[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Book)
    }

    override fun getItemCount(): Int = listBook.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPenulis: TextView = itemView.findViewById(R.id.tv_item_penulis)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}