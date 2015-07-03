package com.dutao.splash.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.dutao.splash.R;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private Button button_begin;
    private ViewPager view_pager_guide;
    private List<ImageView> imageViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        button_begin = (Button)findViewById(R.id.button_begin);
        view_pager_guide = (ViewPager)findViewById(R.id.view_pager_guide);

        ImageView imageView1 = new ImageView(getApplicationContext());
        imageView1.setBackgroundResource(R.drawable.guide_1);
        ImageView imageView2 = new ImageView(getApplicationContext());
        imageView1.setBackgroundResource(R.drawable.guide_2);
        ImageView imageView3 = new ImageView(getApplicationContext());
        imageView1.setBackgroundResource(R.drawable.guide_3);

        imageViewList = new ArrayList<ImageView>();
        imageViewList.add(imageView1);
        imageViewList.add(imageView2);
        imageViewList.add(imageView3);

        view_pager_guide.setAdapter(new MyViewPagerAdapter());
    }

    /**
     * MyViewPagerAdapter
     */
    private class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(imageViewList.get(position));
            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(imageViewList.get(position));
        }
    }
}
