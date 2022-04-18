package com.example.bismillah1.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bismillah1.Dasboard.DasboardMHS;
import com.example.bismillah1.R;
import com.example.bismillah1.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginMhs extends AppCompatActivity {

    private FirebaseAuth mAuth;

    ImageView MHSBack;
    EditText EMAILMHS, PASSWORDMHS;
    String EmailMhs, PasswordMhs;
    Button BTNLoginMHS;
    Button BTNRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mhs);
        mAuth = FirebaseAuth.getInstance();

       EMAILMHS = findViewById(R.id.et_email_mhs);
       PASSWORDMHS = findViewById(R.id.et_password_mhs);
       BTNLoginMHS = findViewById(R.id.btn_login_mhs);
       BTNRegister = findViewById(R.id.btn_register);

       BTNLoginMHS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               cekLoginMhs();
           }
       });

        BTNRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginMhs.this, RegisterActivity.class));
            }
        });

       MHSBack = (ImageView)findViewById(R.id.mhs_back);
       MHSBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginMhs.this, LoginActivity.class));
           }
       });
    }

    private void cekLoginMhs() {
        EmailMhs = EMAILMHS.getText().toString();
        PasswordMhs = PASSWORDMHS.getText().toString();

        mAuth.signInWithEmailAndPassword(EmailMhs, PasswordMhs)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginMhs.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginMhs.this, DasboardMHS.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginMhs.this, "KTM atau Password Salah", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}