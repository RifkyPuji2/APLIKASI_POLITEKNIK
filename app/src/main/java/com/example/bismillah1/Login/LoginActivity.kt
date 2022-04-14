package com.example.bismillah1.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bismillah1.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnMhs : Button
    private lateinit var btnPgw : Button
    private lateinit var btnAdmin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnMhs = btn_mhs
        btnPgw = btn_pgw
        btnAdmin = btn_admin

        btnMhs.setOnClickListener(this)
        btnPgw.setOnClickListener(this)
        btnAdmin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_mhs ->{
                val intentMahasiswa = Intent(this@LoginActivity, LoginMhs::class.java)
                startActivity(intentMahasiswa)
            }
        }
        when(v.id){
            R.id.btn_pgw ->{
                val intentPegawai = Intent(this@LoginActivity, LoginPgw::class.java)
                startActivity(intentPegawai)
            }
        }
        when(v.id){
            R.id.btn_admin ->{
                val intentAdmin = Intent(this@LoginActivity, LoginAdmin::class.java)
                startActivity(intentAdmin)
            }
        }
    }
}