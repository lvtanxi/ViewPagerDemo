package com.lv.viewpagerdemo.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lv.viewpagerdemo.CustomViewPager;
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
 * Time: 11:39
 * Description:
 */
public class TabVpButtomAct extends AppCompatActivity {
    public static void startTabVpButtomAct(Activity activity) {
        activity.startActivity(new Intent(activity, TabVpButtomAct.class));
    }
    private TabLayout mTabBomTab;
    private CustomViewPager mTabBomViewpager;
    private LayoutInflater from;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tabvp_bottm);
        initView();
    }

    private void initView() {
        mTabBomTab = (TabLayout) findViewById(R.id.tab_bom_tab);
        mTabBomViewpager = (CustomViewPager) findViewById(R.id.tab_bom_viewpager);
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        mTabBomViewpager.setAdapter(new LBaseFragmentAdapter(getSupportFragmentManager(),fragments));
        from = LayoutInflater.from(this);
        addTbs();
        mTabBomTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabBomViewpager.setCurrentItem( tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    protected void addTbs() {
    /*    mTabBomTab.addTab(mTabBomTab.newTab().setText("首页").setIcon(R.drawable.ic_tab_home_selector));
        mTabBomTab.addTab(mTabBomTab.newTab().setText("消息").setIcon(R.drawable.ic_tab_home_selector));
        mTabBomTab.addTab(mTabBomTab.newTab().setText("任务").setIcon(R.drawable.ic_tab_home_selector));*/

        mTabBomTab.addTab(mTabBomTab.newTab().setCustomView(indicatorView(R.drawable.ic_tab_home_selector, "首页")));
        mTabBomTab.addTab(mTabBomTab.newTab().setCustomView(indicatorView(R.drawable.ic_tab_home_selector, "消息")));
        mTabBomTab.addTab(mTabBomTab.newTab().setCustomView(indicatorView(R.drawable.ic_tab_home_selector, "任务")));

    }
    private View indicatorView(int tabIconRes, String tabTitle) {
        View inflate = from.inflate(R.layout.view_layout_tab_top_item, null);
        TextView textView = (TextView) inflate.findViewById(R.id.textView);
        AppCompatImageView imageView = (AppCompatImageView) inflate.findViewById(R.id.imageView);
        imageView.setImageResource(tabIconRes);
        textView.setText(tabTitle);
        return inflate;
    }
}
