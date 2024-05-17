package com.example.bteccampusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;
    private Button submitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load view
        setContentView(R.layout.activity_login);
        // setContentView(R.layout.activity_table_login);
        // xy ly dang nhap
        login();
    }

    private void login(){
        // di tim cac doi tuong ngoai layout view
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        submitLogin = findViewById(R.id.submitLogin);
        // bat su kien khi nguoi dung bam bang nhap
        submitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay du lieu ma nguoi dung nhap vao EditTex username va password
                String username = mUsername.getText().toString().trim();// lay dc username
                String password = mPassword.getText().toString().trim();// lay dc password
                // kiem tra nguoi dung nhap du lieu chua ?
                // username
                if(TextUtils.isEmpty(username)){
                    mUsername.setError("Username cannot be empty");
                    return;
                }
                //password
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password cannot be empty");
                    return;
                }

                if(username.equals("trieunt6") && password.equals("12345")){
                    // cho vao trang Main activity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    // thong bao loi
                    mUsername.setError("Username Or Password Invalid");
                }
            }
        });
    }
}
