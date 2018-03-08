package com.example.diego.reto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button bLogin;
    EditText etUser, etPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = findViewById(R.id.bLogin);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    public void goToMenu(View v)
    {
        loginToFirebase(etUser.getText().toString(), etPassword.getText().toString());
        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(i);
    }

    public void loginToFirebase(String user, String password)
    {
        mAuth.createUserWithEmailAndPassword(user, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login exitoso" , Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Login fail" , Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }

}
