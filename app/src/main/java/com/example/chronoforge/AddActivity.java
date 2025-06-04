package com.example.chronoforge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.add_page);
        View input1 = findViewById(R.id.message);
        TextView label1 = input1.findViewById(R.id.mascot_message);
        label1.setText("You're setting the stage for success! \uD83C\uDFAF Name your project, then break it down into tasks—one step at a time, we’ll get it done together! ✅✨");
        RelativeLayout openFormButton = findViewById(R.id.relativeLayout);
        openFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

    }
}
