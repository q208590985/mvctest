package com.jet.mvctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(v -> validateCredentials());

        controller = new LoginController(this, new LoginInteractor());
    }

    private void validateCredentials() {
        controller.validateCredentials(username.getText().toString(), password.getText().toString());
    }

    @Override
    protected void onDestroy() {
        controller.onDestroy();
        super.onDestroy();
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    public void navigateToHome() {

        Toast.makeText(this, R.string.log_in_succeed, Toast.LENGTH_LONG).show();
    }
}
