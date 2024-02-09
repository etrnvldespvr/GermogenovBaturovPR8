package com.example.germogenauthorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLocked;
    private TextView attempts;
    private TextView numberOfAttempts;
    int numberOfRemainingLoginAttempts = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.loginEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        login = (Button) findViewById(R.id.loginBtn);
        loginLocked = (TextView) findViewById(R.id.lockedTv);
        attempts = (TextView) findViewById(R.id.attemptsTv);
        numberOfAttempts = (TextView) findViewById(R.id.attemptsNumber);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

        login.setOnClickListener(this::Login);
    }

    public void Login(View view) {
        if (username.getText().toString().equals("admin") &&
        password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, Second.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;

            attempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

            if (numberOfRemainingLoginAttempts == 0) {
                login.setEnabled(false);
                loginLocked.setVisibility(View.VISIBLE);
                loginLocked.setBackgroundColor(Color.RED);
                attempts.setVisibility(View.INVISIBLE);
                numberOfAttempts.setVisibility(View.INVISIBLE);
            }
        }
    }
}