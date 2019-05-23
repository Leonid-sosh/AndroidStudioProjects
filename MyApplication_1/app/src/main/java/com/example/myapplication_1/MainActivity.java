package com.example.myapplication_1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tv;
    Button button1;
    Button button2;
    Button button3;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text_view);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.cln);


        View.OnClickListener plus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt += 1;
                tv.setText("Кнопка нажата " + Integer.toString(cnt) + " раз");
                if(cnt%10 <= 4 && cnt%10 > 1  && cnt != 12 && cnt != 13 && cnt != 14) {
                    tv.append("a");
                }
            }
        };


        View.OnClickListener minus = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt -= 1;
                tv.setText("Кнопка нажата " + Integer.toString(cnt) + " раз");
                if(cnt%10 <= 4 && cnt%10 > 1  && cnt != 12 && cnt != 13 && cnt != 14) {
                    tv.append("a");
                }
            }
        };


        View.OnClickListener clean = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello From Java!");
                cnt = 0;
            }
        };
        button1.setOnClickListener(plus);
        button2.setOnClickListener(minus);
        button3.setOnClickListener(clean);
    }

}