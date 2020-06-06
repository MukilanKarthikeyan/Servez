package com.example.servezy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
    private Button signed_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signed_in = findViewById(R.id.sign_in);
        signed_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextToCalender();
            }
        });
    }
    public void nextToCalender(){
        Intent nextCal= new Intent(this, Calendar.class );
        startActivity(nextCal);
    }
}
