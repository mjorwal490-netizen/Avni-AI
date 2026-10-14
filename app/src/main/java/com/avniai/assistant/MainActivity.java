package com.avniai.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    int bg = Color.rgb(5, 9, 22);
    int cyan = Color.rgb(0, 220, 255);
    TextView status;

    GradientDrawable shape(int color, int radius, int stroke) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(radius);
        if (stroke > 0) d.setStroke(2, cyan);
        return d;
    }

    TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setTypeface(Typeface.DEFAULT, bold ? Typeface.BOLD : Typeface.NORMAL);
        return t;
    }

    Button makeButton(String label) {
        Button b = new Button(this);
        b.setText(label);
        b.setTextColor(Color.WHITE);
        b.setTextSize(14);
        b.setAllCaps(false);
        b.setBackground(shape(Color.rgb(15, 29, 49), 28, 1));
        return b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(24, 30, 24, 24);
        root.setBackground(new GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            new int[]{Color.rgb(8, 19, 42), bg, Color.rgb(12, 8, 30)}
        ));

        TextView brand = text("A V N I", 30, cyan, true);
        brand.setLetterSpacing(0.18f);
        root.addView(brand);

        TextView tagline = text("YOUR PERSONAL AI ASSISTANT", 11,
                Color.rgb(165, 190, 220), false);
        tagline.setPadding(0, 6, 0, 32);
        root.addView(tagline);

        TextView orb = text("A", 66, Color.WHITE, true);
        orb.setBackground(shape(Color.rgb(13, 48, 78), 200, 1));
        LinearLayout.LayoutParams orbParams =
                new LinearLayout.LayoutParams(190, 190);
        orbParams.gravity = Gravity.CENTER;
        orbParams.setMargins(0, 12, 0, 25);
        root.addView(orb, orbParams);

        TextView name = text("Hello, I'm Avni", 25, Color.WHITE, true);
        root.addView(name);

        TextView desc = text(
                "Your voice. Your world.\\nReady when you are.",
                15, Color.rgb(174, 190, 214), false);
        desc.setPadding(0, 10, 0, 24);
        root.addView(desc);

        status = text("●  AVNI IS READY", 13, cyan, true);
        status.setPadding(0, 8, 0, 22);
        root.addView(status);

        Button talk = makeButton("🎙  Start Voice Assistant");
        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 58);
        buttonParams.setMargins(0, 0, 0, 14);
        root.addView(talk, buttonParams);

        talk.setOnClickListener(v ->
                status.setText("Voice input will be connected next"));

        Button settings = makeButton("⚙  Assistant Settings");
        root.addView(settings, buttonParams);
        settings.setOnClickListener(v ->
                status.setText("Settings module is coming next"));

        TextView footer = text("POWERED BY AI  •  BUILT FOR ANDROID",
                10, Color.rgb(105, 135, 165), false);
        footer.setPadding(0, 30, 0, 0);
        root.addView(footer);

        setContentView(root);
    }
}
