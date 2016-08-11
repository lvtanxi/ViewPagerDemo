package com.lv.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * User: 吕勇
 * Date: 2016-05-05
 * Time: 14:39
 * Description:FragmentStatePagerAdapter基类
 */
public class LBaseFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private String[] mTitles;

    public LBaseFragmentAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    public LBaseFragmentAdapter(FragmentManager fm, Fragment[] fragments, String...titles) {
        super(fm);
        mFragments = Arrays.asList(fragments);
        mTitles = titles;
    }

    public LBaseFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    public void changeItem(int index,String name){
        mTitles[index]=name;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return null==mFragments ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null==mFragments ? "" : mTitles[position];
    }
}
