package com.example.chronoforge.models;

public class Task {
    public String name;
    public String image;
    public String time;
    public String status;

    public Task(String image, String time, String status,String name) {
        this.image = image;
        this.time = time;
        this.status = status;
        this.name = name;
    }
}
