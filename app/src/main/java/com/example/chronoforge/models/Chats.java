package com.example.chronoforge.models;

public class Chats {
    public String lastMessage;
    public String time;
    public int unread;
    public String username;

    public Chats(String username,String lastMessage,String time,int unread){
        this.unread = unread;
        this.lastMessage=lastMessage;
        this.username=username;
        this.time = time;
    }



}
