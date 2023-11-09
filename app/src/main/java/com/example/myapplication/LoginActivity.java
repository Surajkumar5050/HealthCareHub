package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Replace this with your actual authentication logic
                if (isValidLogin(username, password)) {
                    // Successful login, redirect to HomeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close LoginActivity to prevent going back
                } else {
                    // Invalid login, show an error message
                    showErrorPopup("Invalid username or password");
                }
            }
        });
    }

    // Replace this method with your actual authentication logic
    private boolean isValidLogin(String username, String password) {
        // For simplicity, check against hardcoded values
        return username.equals("suraj") && password.equals("suraj1234");
    }

    private void showErrorPopup(String message) {
        // Implement a dialog or toast to show the error message
        // For example, you can use AlertDialog or Toast.
    }
}



