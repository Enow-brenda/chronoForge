package com.example.chronoforge.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chronoforge.AddActivity;
import com.example.chronoforge.CommunityActivity;
import com.example.chronoforge.HomeActivity;
import com.example.chronoforge.R;
import com.example.chronoforge.SettingActivity;
import com.example.chronoforge.StatisticsActivity;

public class BottomNavBar extends LinearLayout {
    private int activeTabId;

    public BottomNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BottomNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.bottom_nav, this, true);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BottomNavBar);
            activeTabId = a.getResourceId(R.styleable.BottomNavBar_activeTabId, -1);
            a.recycle();
        }

        highlightActiveTab();
        setupListeners();
    }

    private void highlightActiveTab() {
        LinearLayout home = findViewById(R.id.nav_home);
        LinearLayout community = findViewById(R.id.nav_community);
        LinearLayout settings = findViewById(R.id.nav_settings);
        LinearLayout stats = findViewById(R.id.nav_stats);

        int primaryColor = Color.parseColor("#946F33");
        int inactiveColor = Color.parseColor("#4B4945");

        if (activeTabId == R.id.nav_home) {
            ((ImageView) findViewById(R.id.icon_home)).setImageResource(R.drawable.home_active);
            ((TextView) home.getChildAt(1)).setTextColor(primaryColor);
            ((TextView) home.getChildAt(1)).setTypeface(null, Typeface.BOLD);;
        } else {
            ((ImageView) findViewById(R.id.icon_home)).setImageResource(R.drawable.home_inactive);
            ((TextView) home.getChildAt(1)).setTextColor(inactiveColor);
            ((TextView) home.getChildAt(1)).setTypeface(null, Typeface.NORMAL);
        }

        if (activeTabId == R.id.nav_community) {
            ((ImageView) findViewById(R.id.icon_community)).setImageResource(R.drawable.community_a);
            ((TextView) community.getChildAt(1)).setTextColor(primaryColor);
            ((TextView) community.getChildAt(1)).setTypeface(null, Typeface.BOLD);;
        } else {
            ((ImageView) findViewById(R.id.icon_community)).setImageResource(R.drawable.community_ia);
            ((TextView) community.getChildAt(1)).setTextColor(inactiveColor);
            ((TextView) community.getChildAt(1)).setTypeface(null, Typeface.NORMAL);;
        }
        if (activeTabId == R.id.nav_stats) {
            ((ImageView) findViewById(R.id.icon_stats)).setImageResource(R.drawable.statistics_active);
            ((TextView) stats.getChildAt(1)).setTextColor(primaryColor);
            ((TextView) stats.getChildAt(1)).setTypeface(null, Typeface.BOLD);;
        } else {
            ((ImageView) findViewById(R.id.icon_stats)).setImageResource(R.drawable.statistics_inactive);
            ((TextView) stats.getChildAt(1)).setTextColor(inactiveColor);
            ((TextView) stats.getChildAt(1)).setTypeface(null, Typeface.NORMAL);;

        }
        if (activeTabId == R.id.nav_settings) {
            ((ImageView) findViewById(R.id.icon_setting)).setImageResource(R.drawable.setting_a);
            ((TextView) settings.getChildAt(1)).setTextColor(primaryColor);
            ((TextView) settings.getChildAt(1)).setTypeface(null, Typeface.BOLD);;
        } else {
            ((ImageView) findViewById(R.id.icon_setting)).setImageResource(R.drawable.setting_ia);
            ((TextView) settings.getChildAt(1)).setTextColor(inactiveColor);
            ((TextView) settings.getChildAt(1)).setTypeface(null, Typeface.NORMAL);;
        }
    }

    private void setupListeners() {
        findViewById(R.id.nav_home).setOnClickListener(v -> {
            Context ctx = getContext();
            if (ctx instanceof Activity && activeTabId != R.id.nav_home) {
                ctx.startActivity(new Intent(ctx, HomeActivity.class));
            }
        });

        findViewById(R.id.nav_community).setOnClickListener(v -> {
            Context ctx = getContext();
            if (ctx instanceof Activity && activeTabId != R.id.nav_community) {
                ctx.startActivity(new Intent(ctx, CommunityActivity.class));
            }
        });
        findViewById(R.id.nav_settings).setOnClickListener(v -> {
            Context ctx = getContext();
            if (ctx instanceof Activity && activeTabId != R.id.nav_settings) {
                ctx.startActivity(new Intent(ctx, SettingActivity.class));
            }
        });
        findViewById(R.id.nav_stats).setOnClickListener(v -> {
            Context ctx = getContext();
            if (ctx instanceof Activity && activeTabId != R.id.nav_stats) {
                ctx.startActivity(new Intent(ctx, StatisticsActivity.class));
            }
        });
        findViewById(R.id.add_button).setOnClickListener(v -> {
            Context ctx = getContext();
            if (ctx instanceof Activity && activeTabId != R.id.add_button) {
                ctx.startActivity(new Intent(ctx, AddActivity.class));
            }
        });

        // Add more listeners if more tabs are defined
    }
}
