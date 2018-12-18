package net.skhu.e05drawable;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView);
        AnimationDrawable animation = (AnimationDrawable)imageView1.getDrawable();
        if (hasFocus)
            animation.start();
        else
            animation.stop();
    }
}

