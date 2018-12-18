package net.skhu.e05drawable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                if (button.getId() == R.id.btnFrameAnimation)
                    startActivity(new Intent(MainActivity.this,  FrameAnimationActivity.class));
                else if (button.getId() == R.id.btnBackgroundDrawable)
                    startActivity(new Intent(MainActivity.this,  BackgroundDrawableActivity.class));
                else if (button.getId() == R.id.btnListViewAnimation)
                    startActivity(new Intent(MainActivity.this,  ListViewAnimationActivity.class));
            }
        };
        findViewById(R.id.btnFrameAnimation).setOnClickListener(myOnClickListener);
        findViewById(R.id.btnBackgroundDrawable).setOnClickListener(myOnClickListener);
        findViewById(R.id.btnListViewAnimation).setOnClickListener(myOnClickListener);
    }
}

