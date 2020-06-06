package com.example.servezy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class HomeScreenGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_groups);
        s

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
    }
}