package com.example.servezy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FirebaseAuth.getInstance().getCurrentUser()== null){
            startActivityForResult(
                    AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .build(),
                    SIGN_IN_REQUEST_CODE
            );
        }
        else{
            Toast.makeText(this,
                    "Welcome" + FirebaseAuth.getInstance()
                        .getCurrentUser()
                        .getDisplayName(),
                    Toast.LENGTH_LONG).show();
            displayChatMessages();
        }


        private void displayChatMessages(){

        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==SIGN_IN_REQUEST_CODE){
                if(resultCode == RESULT_OK){
                    Toast.makeText(this,"Successfully signed in. Welcome!",
                            Toast.LENGTH_LONG).show();
                    displayChatMessages();
                } else {
                    Toast.makeText(this,
                            "We couldn't sign you in. Please try again later",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
        }
        }
        next = findViewById(R.id.welcomeButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignIn();
            }
        });
    }
    public void openSignIn(){
        Intent openMain= new Intent(this, SignIn.class );
        startActivity(openMain);
    }
}