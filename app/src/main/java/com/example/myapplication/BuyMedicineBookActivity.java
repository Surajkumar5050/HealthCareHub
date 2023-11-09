package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edName, edAddress, edContact, edPincode;
    Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edName = findViewById(R.id.textViewFullNameBMB);
        edAddress = findViewById(R.id.textViewAddressBMB);
        edContact = findViewById(R.id.textViewPinCodeBMB);
        edPincode = findViewById(R.id.textViewContactBMB);
        btnBook = findViewById(R.id.buttonBookBMB);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String[] date = new String[]{intent.getStringExtra("date")};
//        String[] time = new String[]{intent.getStringExtra("time")};

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);
//                int intValue = Integer.parseInt(edPincode.getText().toString());
                db.addOrder(username,edName.getText().toString(),edAddress.getText().toString(),edContact.getText().toString(), edPincode.getText().toString(),date.toString(),"",price[1].toString(),"medicine");
                db.removeCart(username,"medicine");
                Toast.makeText(getApplicationContext(),"Your Booking is done successfully",Toast.LENGTH_LONG);
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
            }
        });
    }
}