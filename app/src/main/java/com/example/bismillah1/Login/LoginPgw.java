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

import com.example.bismillah1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPgw extends AppCompatActivity {

    private FirebaseAuth mAuth;

    ImageView PGWBack;
    EditText EMAILPGW, PASSWORDPGW;
    String EmailPgw, PasswordPgw;
    Button BTNLoginPGW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pgw);
        mAuth = FirebaseAuth.getInstance();

        EMAILPGW = findViewById(R.id.et_email_pgw);
        PASSWORDPGW = findViewById(R.id.et_password_pgw);
        BTNLoginPGW = findViewById(R.id.btn_login_pgw);

        PGWBack = (ImageView)findViewById(R.id.pgw_back);
        BTNLoginPGW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLoginPgw();
            }
        });

        PGWBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPgw.this, LoginActivity.class));
            }
        });
    }

    private void cekLoginPgw() {
        EmailPgw = EMAILPGW.getText().toString();
        PasswordPgw =PASSWORDPGW.getText().toString();

        mAuth.signInWithEmailAndPassword(EmailPgw, PasswordPgw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginPgw.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginPgw.this, "NIP atau Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}