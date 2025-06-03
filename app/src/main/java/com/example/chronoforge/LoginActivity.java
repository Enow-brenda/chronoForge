package com.example.chronoforge;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chronoforge.models.Inputs;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        LinearLayout inputContainer = findViewById(R.id.inputContainer);//get the container
        List<Inputs> inputs = new ArrayList<>();
        inputs.add(new Inputs(R.drawable.envelope_icon, "Email Adress", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS));
        inputs.add(new Inputs(R.drawable.password_icon, "Password", InputType.TYPE_TEXT_VARIATION_PASSWORD));

        for (Inputs input : inputs) {
            View inputView = getLayoutInflater().inflate(R.layout.auth_inputs, inputContainer, false);

            ImageView icon = inputView.findViewById(R.id.input_icon);
            EditText editText = inputView.findViewById(R.id.input_box);

            icon.setImageResource(input.iconResId);
            editText.setHint(input.hintText);
            editText.setInputType(input.inputType);

            inputContainer.addView(inputView);
        }

        TextView openRegister = findViewById(R.id.create);
        TextView openLogin = findViewById(R.id.goto_home);
        openRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        openLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}
