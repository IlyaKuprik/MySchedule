package com.example.myschedule;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager)findViewById(R.id.pager);
        vp.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        Log.d("TAG",String.valueOf(dayOfWeek));
        switch (dayOfWeek){
            case 2: vp.setCurrentItem(0); break; // Воскресенье - 1.Поэтому начинается с 2.
            case 3: vp.setCurrentItem(1); break;
            case 4: vp.setCurrentItem(2); break;
            case 5: vp.setCurrentItem(3); break;
            case 6: vp.setCurrentItem(4); break;
            case 7: vp.setCurrentItem(5); break;
            default: vp.setCurrentItem(0); break;
        }
        getSupportActionBar().setTitle("Мое рассписание");
    }
}
