package com.sebastianrod.penguin_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import models.ActivitiesMethods;
import models.User;

public class RegisterActivity extends AppCompatActivity {

    TextView linkLogin;
    TextInputEditText inputUser, inputPassword, inputEmail;
    Button buttonRegister;
    ImageView linkBackLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linkLogin = findViewById(R.id.link_login);
        linkBackLogin = findViewById(R.id.back_login);
        buttonRegister = findViewById(R.id.register_button);

        inputUser = findViewById(R.id.input_user);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        linkBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ActivitiesMethods.verifyCompleteData(inputUser, inputEmail, inputPassword)){
                    ActivitiesMethods.showAlert(RegisterActivity.this, "Error in sign in", "You have the enter complete data");

                } else if (!inputEmail.getText().toString().endsWith("@gmail.com")){
                    ActivitiesMethods.showAlert(RegisterActivity.this, "Error in sign in", "The email entered is invalid");
                }
                else{
                    User.setName(inputUser.getText().toString());
                    User.setEmail(inputEmail.getText().toString());
                    User.setPassword(inputPassword.getText().toString());
                    Snackbar sb = Snackbar.make(v, "Registered user successfully. Now log in.",
                            Snackbar.LENGTH_LONG);
                    sb.setDuration(50000);
                    sb.show();
                }
            }
        });



    }


}