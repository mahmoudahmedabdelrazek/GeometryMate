package com.my.app.calc.geometrymate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // إنشاء Intent للانتقال إلى الصفحة الأخرى
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // إغلاق النشاط الحالي بعد الانتقال إلى الصفحة الأخرى
            }
        }, 3000); // 3000 ميلي ثانية هي 3 ثواني
    }
}
