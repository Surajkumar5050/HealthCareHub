package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // Initialize the buttons by their IDs
        ImageView buttonDoctor1 = findViewById(R.id.imageView1);
        ImageView buttonDoctor2 = findViewById(R.id.imageView2);
        ImageView buttonDoctor3 = findViewById(R.id.imageView3);
        ImageView buttonDoctor4 = findViewById(R.id.imageView4);
        ImageView buttonDoctor5 = findViewById(R.id.imageView5);
        ImageView backButton = findViewById(R.id.imageView6);

        // Set click listeners for each button
        buttonDoctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorDetails("Family Physician");
            }
        });

        buttonDoctor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorDetails("Dietician");
            }
        });

        buttonDoctor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorDetails("Dentist");
            }
        });

        buttonDoctor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorDetails("Surgeon");
            }
        });

        buttonDoctor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctorDetails("Cardiologist");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

    private void openDoctorDetails(String title) {
        Intent intent = new Intent(this, ActivityDoctorDetails.class);
        intent.putExtra("Title", title);
        startActivity(intent);
    }
}
