package com.example.chronoforge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.graphics.Color;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.chronoforge.models.Task;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    void renderTasks(List<Task> tasks){
        LinearLayout Task_List = findViewById(R.id.task_list);
        Task_List.removeAllViews();
        for(Task task: tasks){
            View todayTasks = getLayoutInflater().inflate(R.layout.home_task, Task_List, false);

            TextView name = todayTasks.findViewById(R.id.task_name);
            TextView time = todayTasks.findViewById(R.id.task_time);

            ImageView status = todayTasks.findViewById(R.id.status);
            CheckBox checkBox = todayTasks.findViewById(R.id.completed);

            name.setText(task.name);

            if(task.status.equals("Ongoing")){
                status.setImageResource(R.drawable.processing);
                time.setText(task.status);
                time.setTextColor(Color.parseColor("#D44444"));
            } else if (task.status.equals("Completed")) {
                time.setText(task.status);
                status.setVisibility(View.GONE);
                checkBox.setChecked(true);
                time.setTextColor(Color.parseColor("#339442"));
            }else{
                time.setText(task.status);
                time.setTextColor(Color.parseColor("#94338E"));
            }


            Task_List.addView(todayTasks);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        View input1 = findViewById(R.id.message);
        TextView label1 = input1.findViewById(R.id.mascot_message);

        ImageView imageView = findViewById(R.id.user_pic);
        Glide.with(this)
                .load("https://wallpaperaccess.com/full/11925634.jpg")
                .circleCrop()
                .into(imageView);


        label1.setText("“Hey there \uD83D\uDC4B Ready to tick off some tasks and feel awesome?”");

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(null,"Just Now","Pending","Make the Dashboard Page"));
        tasks.add(new Task(null," 5pm","Completed","Redesign the login"));
        tasks.add(new Task(null,"Just Now","Pending","Make the Dashboard Page"));
        tasks.add(new Task(null,"Just Now","Completed","Redesign the login"));
        tasks.add(new Task(null,"Just Now","Ongoing","Make the Dashboard Page"));
        tasks.add(new Task(null,"Just Now","Completed","Redesign the login"));
        tasks.add(new Task(null,"Just Now","Pending","Make the Dashboard Page"));
        tasks.add(new Task(null,"Just Now","Completed","Redesign the login"));

        renderTasks(tasks);

    }
}
