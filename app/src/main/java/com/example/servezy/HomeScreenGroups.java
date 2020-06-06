package com.example.servezy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

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

        FloatingActionButton send = (FloatingActionButton)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText)findViewById(R.id.input);

                FirebaseDatabase.getInstance().getReference().push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance().getCurrentUser().getDisplayName()));
                input.setText("");
            }
        });

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