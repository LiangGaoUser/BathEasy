package com.example.administrator.batheasy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        给底部的组件设置监听器
         */
        Toast toast1=Toast.makeText(getApplicationContext(),"点击了1",Toast.LENGTH_LONG);
        toast1.show();
        ImageView imageViewBath = findViewById(R.id.bottom_icon_bath);
        ImageView imageViewInfo = findViewById(R.id.bottom_icon_info);
        ImageView imageViewEmail = findViewById(R.id.bottom_icon_email);
        imageViewBath.setOnClickListener(l);
        imageViewInfo.setOnClickListener(l);
        imageViewEmail.setOnClickListener(l);

    }

    View.OnClickListener l = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Toast toast1=Toast.makeText(getApplicationContext(),"点击了1",Toast.LENGTH_LONG);
            toast1.show();
            Fragment f = null;
            switch (v.getId()){
                case R.id.bottom_icon_bath: f = new Fragment_bath();break;
                case R.id.bottom_icon_info: f = new Fragment_info();break;
                case R.id.bottom_icon_email: f = new Fragment_email();break;
            }
            ft.replace(R.id.main_fragment,f);   //替换fragment
            ft.commit();
        }
    };
}
