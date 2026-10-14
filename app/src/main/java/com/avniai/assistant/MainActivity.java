package com.avniai.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(28, 28, 28, 28);
        root.setBackgroundColor(Color.rgb(5, 9, 20));

        TextView title = new TextView(this);
        title.setText("AVNI AI");
        title.setTextSize(36);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(Color.rgb(0, 207, 255));
        title.setGravity(Gravity.CENTER);

        TextView subtitle = new TextView(this);
        subtitle.setText("Your Voice. Your World.");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.WHITE);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 12, 0, 24);

        TextView status = new TextView(this);
        status.setText("Avni is getting ready...");
        status.setTextSize(15);
        status.setTextColor(Color.LTGRAY);
        status.setGravity(Gravity.CENTER);

        root.addView(title);
        root.addView(subtitle);
        root.addView(status);

        setContentView(root);
    }
}
