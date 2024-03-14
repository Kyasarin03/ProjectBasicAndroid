package com.example.projekkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_book)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvPenulis: TextView = findViewById(R.id.tv_item_penulis)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvNegara: TextView = findViewById(R.id.tv_item_negara)
        val tvBahasa: TextView = findViewById(R.id.tv_item_bahasa)
        val tvGenre: TextView = findViewById(R.id.tv_item_genre)
        val tvPenerbit: TextView = findViewById(R.id.tv_item_penerbit)
        val tvTglTerbit: TextView = findViewById(R.id.tv_item_tgl_terbit)
        val tvHlm: TextView = findViewById(R.id.tv_item_hlm)
        val tvIsbn: TextView = findViewById(R.id.tv_item_isbn)

        val book = if (Build.VERSION.SDK_INT >= 33) {
            val EXTRA_BOOK = "key_book"
            intent.getParcelableExtra<Book>(EXTRA_BOOK, Book::class.java)
        } else {
            val EXTRA_BOOK = "key_book"
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>(EXTRA_BOOK)
        }

        imgPhoto.setImageResource(book!!.photo)
        tvName.text = book!!.name
        tvPenulis.text = book!!.penulis
        tvDescription.text = book!!.description
        tvNegara.text = book!!.negara
        tvBahasa.text = book!!.bahasa
        tvGenre.text = book!!.genre
        tvPenerbit.text = book!!.penerbit
        tvTglTerbit.text = book!!.tgl_terbit
        tvHlm.text = book!!.hlm
        tvIsbn.text = book!!.isbn
    }
}