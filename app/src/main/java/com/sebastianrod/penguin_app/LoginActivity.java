package com.sebastianrod.penguin_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import models.ActivitiesMethods;
import models.User;

public class LoginActivity extends AppCompatActivity {

    TextView linkRegister;
    TextInputEditText inputUser, inputPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        linkRegister =findViewById(R.id.link_register);

        inputUser = findViewById(R.id.input_user);
        inputPassword = findViewById(R.id.input_password);

        buttonLogin = findViewById(R.id.login_button);

        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!User.verifyUserExistence()){
                    ActivitiesMethods.showAlert(LoginActivity.this, "Error in log in", "You have not registered");
                } else if (!ActivitiesMethods.verifyCompleteData(inputUser, inputPassword)) {
                    ActivitiesMethods.showAlert(LoginActivity.this, "Error in log in", "You have the enter complete data");
                }
                else if (User.getName().equals(inputUser.getText().toString()) && User.getPassword().equals(inputPassword.getText().toString())){
                    startActivity(new Intent(LoginActivity.this, LoadingActivity.class));
                    finish();
                } else {
                    ActivitiesMethods.showAlert(LoginActivity.this, "Error in log in", "The data is incorrect");

                }
            }
        });

    }
}