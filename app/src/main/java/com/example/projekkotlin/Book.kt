package com.example.projekkotlin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val name: String,
    val penulis: String,
    val description: String,
    val photo: Int,
    val negara: String,
    val bahasa: String,
    val genre: String,
    val penerbit: String,
    val tgl_terbit: String,
    val hlm: String,
    val isbn: String
): Parcelable