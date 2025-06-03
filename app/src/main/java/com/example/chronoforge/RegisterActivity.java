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


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.register);

        LinearLayout inputContainer = findViewById(R.id.inputContainer);//get the container
        List<Inputs> inputs = new ArrayList<>();
        inputs.add(new Inputs(R.drawable.user_icon_active, "Full name", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS));
        inputs.add(new Inputs(R.drawable.envelope_icon, "Email Adress", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS));
        inputs.add(new Inputs(R.drawable.phone_icon, "Phone Number", InputType.TYPE_NUMBER_VARIATION_NORMAL));
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

        TextView openLogin = findViewById(R.id.login);
        openLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}
