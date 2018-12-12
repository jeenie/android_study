package net.skhu.e01button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "내로그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate 메소드 시작");

        Button b = (Button)findViewById(R.id.button);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick 메소드 시작");
                EditText e = (EditText)findViewById(R.id.editText);
                CharSequence s = e.getText();
                Log.d(TAG, "EditText에 입력된 문자열 :" + s);
                TextView t = (TextView)findViewById(R.id.textView2);
                t.setText(s);
                Log.d(TAG, "onClick메소드 종료");
            }
        };
        b.setOnClickListener(listenerObj);

        Log.d(TAG, "onCreate 메소드 종료");
    }
}
