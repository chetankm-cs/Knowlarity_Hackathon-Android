package com.api_hackathon.app.views;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.api_hackathon.app.R;
import com.api_hackathon.app.animations.BasicAnimations;

public class MainActivity extends ActionBarActivity {
    private BasicAnimations basicAnimations;
    private Button nikhilButton1,nikhilButton2,nikhilButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicAnimations = new BasicAnimations(this);

        nikhilButton1 = (Button)findViewById(R.id.nikhil_button1);
        nikhilButton1.setOnClickListener(onClickListener);

        nikhilButton2 = (Button)findViewById(R.id.nikhil_button2);
        nikhilButton2.setOnClickListener(onClickListener);

        nikhilButton3 = (Button)findViewById(R.id.nikhil_button3);
        nikhilButton3.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.nikhil_button1:
                {
                    nikhilButton1.startAnimation(basicAnimations.zoomIn);
                    break;
                }
                case R.id.nikhil_button2:
                {
                    nikhilButton2.startAnimation(basicAnimations.fade);
                    break;
                }
                case R.id.nikhil_button3:
                {
                    nikhilButton3.startAnimation(basicAnimations.rotate);
                    break;
                }
            }
        }
    };
}
