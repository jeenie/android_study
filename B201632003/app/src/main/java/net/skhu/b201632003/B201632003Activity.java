package net.skhu.b201632003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class B201632003Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b201632003);

        Button b = (Button)findViewById(R.id.button);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText)findViewById(R.id.editText1);
                CharSequence s1 = e1.getText();
                EditText e2 = (EditText)findViewById(R.id.editText2);
                CharSequence s2 = e2.getText();
                e1.setText("");
                e2.setText(s1);
            }
        };
        b.setOnClickListener(listenerObj);
    }
}
