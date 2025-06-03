package com.example.chronoforge;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chronoforge.models.Chats;
import com.example.chronoforge.models.Chats;
import com.example.chronoforge.models.Task;
import com.example.chronoforge.models.User;

import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.community);
        View input1 = findViewById(R.id.message);
        TextView label1 = input1.findViewById(R.id.mascot_message);

        //geting the tabs
        View Tab = findViewById(R.id.tab);
        LinearLayout chatTab = Tab.findViewById(R.id.tabChats);
        LinearLayout userTab = Tab.findViewById(R.id.tabUsers);




        label1.setText("“It's me again \uD83D\uDC4B Connect with other forgers and have fun”");

        List<Chats> chats = new ArrayList<>();
        chats.add(new Chats("Mummy Louis2","Hope you saw my call","Today",0));
        chats.add(new Chats("Mummy Louis","Hope you saw my call","Yesterday",2));
        chats.add(new Chats("Mummy Louis","Hope you saw my call","Today",0));
        chats.add(new Chats("Mummy Louis","Hope you saw my call","Yesterday",2));
        chats.add(new Chats("Mummy Louis","Hope you saw my call","Today",0));
        chats.add(new Chats("Mummy Louis","Hope you saw my call","Yesterday",2));

        List<User> users = new ArrayList<>();
        users.add(new User("Brenda Eweh","Busy"));
        users.add(new User("Mikey Paul","Online"));

        chatTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab("chats");
                renderchats(chats);
            }
        });
        userTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTab("users");
                renderUsers(users);
            }
        });

        renderchats(chats);

    }

    private void renderchats(List<Chats> chats) {
        LinearLayout Chat_List = findViewById(R.id.chat_list);
        Chat_List.removeAllViews();
        for(Chats chat: chats){
            View myChat = getLayoutInflater().inflate(R.layout.chat_box, Chat_List, false);

            TextView name = myChat.findViewById(R.id.user_name);
            TextView time = myChat.findViewById(R.id.time);
            TextView unread = myChat.findViewById(R.id.unread);
            TextView lastMessage = myChat.findViewById(R.id.last_message);

            name.setText(chat.username);
            time.setText(chat.time);
            lastMessage.setText(chat.lastMessage);

            if(chat.unread==0){
                unread.setVisibility(View.GONE);
            } else{
                time.setTextColor(Color.parseColor("#946F33"));
                unread.setText(String.valueOf(chat.unread));
            }

            Chat_List.addView(myChat);
        }
    }

    private void changeTab(String tab){
        String primary = "#946F33";
        String inactive = "#4B4945";
        View Tab = findViewById(R.id.tab);
        LinearLayout chatTab = Tab.findViewById(R.id.tabChats);
        LinearLayout userTab = Tab.findViewById(R.id.tabUsers);

        TextView userText = userTab.findViewById(R.id.textUsers);
        TextView chatText = chatTab.findViewById(R.id.textChats);

        ImageView userImage = userTab.findViewById(R.id.users_icon);
        ImageView chatImage = chatTab.findViewById(R.id.chat_icon);
        if(tab.equals("users")){


            userText.setTextColor(Color.parseColor(primary));
            chatText.setTextColor(Color.parseColor(inactive));

            userTab.setBackgroundResource(R.drawable.tab_active_background);
            chatTab.setBackground(null);


            userImage.setImageResource(R.drawable.user_icon_active);
            chatImage.setImageResource(R.drawable.chat_inactive);
        }else{

            chatText.setTextColor(Color.parseColor(primary));
            userText.setTextColor(Color.parseColor(inactive));

            chatTab.setBackgroundResource(R.drawable.tab_active_background);
            userTab.setBackground(null);

            userImage.setImageResource(R.drawable.user_inactive);
            chatImage.setImageResource(R.drawable.chat_active);
        }
    }
    private void renderUsers(List<User> users) {

        LinearLayout User_List = findViewById(R.id.chat_list);
        User_List.removeAllViews();
        for(User user: users){
            View myUser = getLayoutInflater().inflate(R.layout.users_box,User_List, false);

            TextView name = myUser.findViewById(R.id.user_name);
            TextView status = myUser.findViewById(R.id.status);


            name.setText(user.username);
            status.setText(user.status);


            User_List.addView(myUser);
        }
    }
}
