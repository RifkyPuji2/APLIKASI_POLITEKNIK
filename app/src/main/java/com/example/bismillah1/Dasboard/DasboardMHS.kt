package com.example.bismillah1.Dasboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bismillah1.Login.LoginMhs
import com.example.bismillah1.R
import kotlinx.android.synthetic.main.activity_dasboard_mhs.*

class DasboardMHS : AppCompatActivity(), View.OnClickListener {

    private lateinit var TambahCvMhs : CardView
    private lateinit var LihatCvMhs : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasboard_mhs)

        TambahCvMhs = cvTambahMhs
        LihatCvMhs = cvLihatMhs

        TambahCvMhs.setOnClickListener(this)
        LihatCvMhs.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.cvTambahMhs ->{
                val intenttambahmhs = Intent(this@DasboardMHS, TambahMHS::class.java)
                startActivity(intenttambahmhs)
            }
        }
    }
}