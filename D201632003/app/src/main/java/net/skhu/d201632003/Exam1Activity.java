package net.skhu.d201632003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner1 = (Spinner) findViewById(R.id.spinner_userType);
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                String text1 = spinner1.getSelectedItem().toString();
                editText1.setText(text1);
            }
        };

        Button button = (Button) findViewById(R.id.btnOk);
        button.setOnClickListener(listener1);

        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int text2= 0;
                switch(checkedId) {
                    case R.id.radioButton1: text2 = R.string.admin; break;
                    case R.id.radioButton2: text2 = R.string.user; break;
                    case R.id.radioButton3: text2 = R.string.guest; break;
                }
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                editText1.setText(text2);
            }
        };
        final RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup1.setOnCheckedChangeListener(listener2);
    }
}
