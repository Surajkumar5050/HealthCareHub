package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView buttonLabTest = findViewById(R.id.buttonLabTest);
        ImageView buttonBuyMedicine = findViewById(R.id.buttonBuyMedicine);
        ImageView buttonFindDoctor = findViewById(R.id.buttonFindDoctor);
        ImageView buttonHealthArticles = findViewById(R.id.buttonHealthArticles);
        ImageView buttonOrderDetails = findViewById(R.id.buttonOrderDetails);
        ImageView buttonLogout = findViewById(R.id.buttonLogout);

        buttonLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LabTestActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonBuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("BUY MEDICINE clicked");
                Intent intent = new Intent(HomeActivity.this, BuyMedicineActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("FIND DOCTOR clicked");
                Intent intent = new Intent(HomeActivity.this, FindDoctorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonHealthArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("HEALTH ARTICLES clicked");
                Intent intent = new Intent(HomeActivity.this, HealthArticlesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("ORDER DETAILS clicked");
                Intent intent = new Intent(HomeActivity.this, OrderDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("back to login page");
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Order Details");
                Intent intent = new Intent(HomeActivity.this, OrderDetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonBuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Order Details");
                Intent intent = new Intent(HomeActivity.this, BuyMedicineActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


