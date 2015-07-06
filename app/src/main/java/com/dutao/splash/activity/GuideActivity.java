package com.dutao.splash.activity;

import android.app.Activity;
import android.content.Intent;
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
        imageView2.setBackgroundResource(R.drawable.guide_2);
        ImageView imageView3 = new ImageView(getApplicationContext());
        imageView3.setBackgroundResource(R.drawable.guide_3);

        imageViewList = new ArrayList<ImageView>();
        imageViewList.add(imageView1);
        imageViewList.add(imageView2);
        imageViewList.add(imageView3);

        view_pager_guide.setAdapter(new MyViewPagerAdapter());
        view_pager_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //滚动完成
            }

            @Override
            public void onPageSelected(int position) {
                //页面被选中
                if(position == imageViewList.size() - 1){
                    button_begin = (Button) findViewById(R.id.button_begin);
                    button_begin.setVisibility(View.VISIBLE);
                    button_begin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }else{
                    button_begin.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //滚动状态发生改变
            }
        });
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
