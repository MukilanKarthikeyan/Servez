package com.example.servezy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class ProfileActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private ImageView profile_image;
    private TextView name;
    private TextView email;
    private TextView id;
    private Button sign_out_btn;

    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_image = findViewById(R.id.profile_image);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        sign_out_btn = findViewById(R.id.sign_out_btn);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this , this)
            .addApi(Auth.GOOGLE_SIGN_IN_API , gso).build();
        sign_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if(status.isSuccess()){
                            gotoMainActivity();
                        }
                    }
                });
            }
        });
    }

    private void gotoMainActivity() {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}