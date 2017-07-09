package com.baway.slidingmenudemo;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

public class MainActivity extends SlidingActivity {
    private HorizontalScrollView scrollView;
    private LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMenu();
        initScroll();
    }

    private void initScroll() {
        scrollView = (HorizontalScrollView) findViewById(R.id.slidin);
        linearLayout = (LinearLayout) findViewById(R.id.linear);

        for (int i = 0; i < 20; i++) {
            View view1 = View.inflate(this, R.layout.scr, null);

            ImageView imag = (ImageView) view1.findViewById(R.id.imageview);
            imag.setImageResource(R.mipmap.ic_launcher);
            TextView textview = (TextView) view1.findViewById(R.id.tv);
            textview.setText("i-" + i);
            linearLayout.addView(view1);
        }
    }

    private void initMenu() {
        View view = View.inflate(this, R.layout.left_item, null);
        setBehindContentView(view);
        final SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowDrawable(R.mipmap.ic_launcher);
        menu.setFadeDegree(0.35f);
        view.findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "dasds", Toast.LENGTH_SHORT).show();
                if (menu.isMenuShowing()) {
                    menu.toggle();
                }
            }
        });

    }
}
