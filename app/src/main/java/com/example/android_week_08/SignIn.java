package com.example.android_week_08;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "UserAuth";
    private FirebaseAuth mAuth;
    private EditText textEmail, textPassword;
    private Button btnSigin;
// Initialize Firebase Auth

//    public SignIn(FirebaseAuth mAuth) {
//        this.mAuth = mAuth;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_sign_in);
        btnSigin= findViewById(R.id.btnSinginIn);
        textEmail= findViewById(R.id.editTextSignEmail);
        textPassword= findViewById(R.id.editTextSignEmail);
        
        btnSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAccunt();
            }
        });
    }

    private void loginAccunt() {
       String email=  textEmail.getText().toString();
        String password=  textPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

                    private void updateUI(FirebaseUser user) {
                    }

                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
}
