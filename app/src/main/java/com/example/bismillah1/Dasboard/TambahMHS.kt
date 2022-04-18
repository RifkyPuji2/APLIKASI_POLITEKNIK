package com.example.bismillah1.Dasboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.bismillah1.R
import kotlinx.android.synthetic.main.activity_tambah_mhs.*

class TambahMHS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_mhs)

        val prodiMHS = resources.getStringArray(R.array.prodi_mhs)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_mhs, prodiMHS)
        val autoCompleteTV = ACTVMhs
        autoCompleteTV.setAdapter(arrayAdapter)
    }
}