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

public class LoginAdmin extends AppCompatActivity {

    private FirebaseAuth mAuth;

    ImageView ADMINBack;
    EditText EMAILADMIN, PASSWORDADMIN;
    String EmailAdmin, PasswordAdmin;
    Button BTNLoginADMIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        mAuth = FirebaseAuth.getInstance();

        EMAILADMIN = findViewById(R.id.et_email_admin);
        PASSWORDADMIN = findViewById(R.id.et_password_admin);
        BTNLoginADMIN = findViewById(R.id.btn_login_admin);

        BTNLoginADMIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLoginAdmin();
            }
        });

        ADMINBack = (ImageView)findViewById(R.id.admin_back);
        ADMINBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAdmin.this, LoginActivity.class));
            }
        });

    }

    private void cekLoginAdmin() {
        EmailAdmin = EMAILADMIN.getText().toString();
        PasswordAdmin = PASSWORDADMIN.getText().toString();

        mAuth.signInWithEmailAndPassword(EmailAdmin, PasswordAdmin)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginAdmin.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginAdmin.this, "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}