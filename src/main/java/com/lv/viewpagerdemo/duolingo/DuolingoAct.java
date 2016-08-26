package com.lv.viewpagerdemo.duolingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lv.viewpagerdemo.LBaseFragmentAdapter;
import com.lv.viewpagerdemo.R;

/**
 * User: 吕勇
 * Date: 2016-08-26
 * Time: 09:18
 * Description:
 */
public class DuolingoAct extends AppCompatActivity {
    public static void startDuolingoAct(Activity activity) {
        activity.startActivity(new Intent(activity, DuolingoAct.class));
    }
    private ViewPager mDuoViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duolingo);
        initView();
        mDuoViewPager.setAdapter(new LBaseFragmentAdapter(getSupportFragmentManager(),new Fragment[]{new CardFragment(),new CardFragment(),new CardFragment(),new CardFragment(),new CardFragment(),new CardFragment()}));
    }

    private void initView() {
        mDuoViewPager = (ViewPager) findViewById(R.id.duo_view_pager);

    }
}
