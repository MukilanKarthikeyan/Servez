package com.example.servezy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.welcomeButton);
        next.setOnClickListener(new View.OnClickListener())
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
        {
            @Override
            public void onClick(View v) {
                openMainMenu();

            }
        });
    }
    public void openMainMenu(){
        Intent openMain= new Intent(this, Calander.class );
        startActivity(openMain);
    }
}
