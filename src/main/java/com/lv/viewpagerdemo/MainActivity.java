package com.lv.viewpagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lv.viewpagerdemo.flyco.SimpleHomeActivity;
import com.lv.viewpagerdemo.kongjian.KongjianAct;
import com.lv.viewpagerdemo.tab.TabVpAct;
import com.lv.viewpagerdemo.tab.TabVpButtomAct;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toTabVp(View view) {
        TabVpAct.startTabVpAct(this);
    }

    public void toTabVpButtom(View view) {
        TabVpButtomAct.startTabVpButtomAct(this);
    }

    public void toFlycoTabLayout(View view) {
        SimpleHomeActivity.startSimpleHomeActivity(this);
    }
    public void tokongjian(View view) {
        KongjianAct.startKongjianAct(this);
    }
}
