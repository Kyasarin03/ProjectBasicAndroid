package com.example.projekkotlin

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
//    View.OnClickListener {
    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listBookAdapter = ListBookAdapter(list)
        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                val intent = Intent(this@MainActivity, DetailsBook::class.java)
                intent.putExtra("BOOK_EXTRA", data)
                startActivity(intent)
            }
        })

        rvBooks = findViewById(R.id.rv_books)
        rvBooks.setHasFixedSize(true)

        list.addAll(getListBooks())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutPage::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun getListBooks(): ArrayList<Book> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPenulis = resources.getStringArray(R.array.data_penulis)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataNegara = resources.getStringArray(R.array.data_negara)
        val dataBahasa = resources.getStringArray(R.array.data_bahasa)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataPenerbit = resources.getStringArray(R.array.data_penerbit)
        val dataTglTerbit = resources.getStringArray(R.array.data_tgl_terbit)
        val dataHlm = resources.getStringArray(R.array.data_hlm)
        val dataIsbn = resources.getStringArray(R.array.data_isbn)

        val listBook = ArrayList<Book>()
        for (i in dataName.indices) {
            val book = Book(dataName[i], dataPenulis[i], dataDescription[i], dataPhoto.getResourceId(i, -1),
                dataNegara[i], dataBahasa[i], dataGenre[i], dataPenerbit[i], dataTglTerbit[i],
            dataHlm[i], dataIsbn[i])
            listBook.add(book)
        }
        return listBook
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvBooks.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvBooks.layoutManager = LinearLayoutManager(this)
        }
        val listBookAdapter = ListBookAdapter(list)
        rvBooks.adapter = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : ListBookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedBook(data)
            }
        })
    }

    private fun showSelectedBook(book: Book) {
        Toast.makeText(this, "Kamu memilih " + book.name, Toast.LENGTH_SHORT).show()
    }

}