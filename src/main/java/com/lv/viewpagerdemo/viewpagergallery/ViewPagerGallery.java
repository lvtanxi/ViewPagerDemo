package com.lv.viewpagerdemo.viewpagergallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lv.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2016-10-20
 * Time: 09:13
 * Description:
 */
public class ViewPagerGallery extends AppCompatActivity{
    public static void startViewPagerGallery(Activity activity) {
        activity.startActivity(new Intent(activity, ViewPagerGallery.class));
    }

    private int pagerWidth;
    private List<ImageView> imageViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewpagergallery);
        final ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        imageViewList=new ArrayList<>();
        ImageView first=new ImageView(ViewPagerGallery.this);
//        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.first,ViewPagerGallery.this));
        first.setImageResource(R.mipmap.first);
        ImageView second=new ImageView(ViewPagerGallery.this);
//        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.second,ViewPagerGallery.this));
        second.setImageResource(R.mipmap.second);
        ImageView third=new ImageView(ViewPagerGallery.this);
//        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.third,ViewPagerGallery.this));
        third.setImageResource(R.mipmap.third);
        ImageView fourth=new ImageView(ViewPagerGallery.this);
//        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth,ViewPagerGallery.this));
        fourth.setImageResource(R.mipmap.fourth);
        ImageView fifth=new ImageView(ViewPagerGallery.this);
//        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fifth,ViewPagerGallery.this));
        fifth.setImageResource(R.mipmap.fifth);
        imageViewList.add(first);
        imageViewList.add(second);
        imageViewList.add(third);
        imageViewList.add(fourth);
        imageViewList.add(fifth);
        viewPager.setOffscreenPageLimit(3);
        pagerWidth= (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width=pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
        viewPager.setPageTransformer(true,new MyTransformation());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView=imageViewList.get(position);
                container.addView(imageView,position);
                return imageView;
            }
        });

    }
}
