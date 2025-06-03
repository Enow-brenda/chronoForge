package com.example.chronoforge.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chronoforge.R;

public class CustomSettingTabView extends LinearLayout {

    private ImageView iconView;
    private TextView labelView;

    public CustomSettingTabView(Context context) {
        super(context);

    }

    public CustomSettingTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomSettingTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.setting_box, this, true);
        iconView = findViewById(R.id.tab_icon);
        labelView = findViewById(R.id.tab_label);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomSettingTabView);
            int iconRes = a.getResourceId(R.styleable.CustomSettingTabView_tabIcon, -1);
            String label = a.getString(R.styleable.CustomSettingTabView_tabLabel);
            a.recycle();

            if (iconRes != -1) setIcon(iconRes);
            if (label != null) setLabel(label);

        }
    }

    public void setIcon(int resId) {
        iconView.setImageResource(resId);
    }

    public void setLabel(String text) {
        if(text.equals("Log Out")){
            this.findViewById(R.id.box).setBackgroundResource(R.drawable.border_red);
        }

        labelView.setText(text);
    }


}
