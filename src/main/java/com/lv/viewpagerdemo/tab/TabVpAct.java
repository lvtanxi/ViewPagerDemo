package com.lv.viewpagerdemo.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lv.viewpagerdemo.LBaseFragmentAdapter;
import com.lv.viewpagerdemo.R;
import com.lv.viewpagerdemo.feagments.OneFragment;
import com.lv.viewpagerdemo.feagments.ThreeFragment;
import com.lv.viewpagerdemo.feagments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 吕勇
 * Date: 2016-08-11
 * Time: 11:26
 * Description:
 */
public class TabVpAct extends AppCompatActivity {
    private TabLayout mTabTab;
    private ViewPager mTabViewpager;

    public static void startTabVpAct(Activity activity) {
        activity.startActivity(new Intent(activity, TabVpAct.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tabvp);
        initView();
    }

    private void initView() {
        mTabTab = (TabLayout) findViewById(R.id.tab_tab);
        mTabViewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        mTabTab.setupWithViewPager(mTabViewpager);
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        mTabViewpager.setAdapter(new LBaseFragmentAdapter(getSupportFragmentManager(),fragments,new String[]{"标题一","标题二","标题三"}));
    }
}
