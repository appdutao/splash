package com.dutao.splash.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.dutao.splash.R;
import com.dutao.splash.base.BaseFragment;
import com.dutao.splash.fragment.FunctionFragment;
import com.dutao.splash.fragment.GovAffairsFragment;
import com.dutao.splash.fragment.NewsCenterFragment;
import com.dutao.splash.fragment.SettingFragment;
import com.dutao.splash.fragment.SmartServiceFragment;

public class MainActivity extends FragmentActivity {

    private FrameLayout layout_content;
    private RadioGroup main_radio;

    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_home);

        layout_content = (FrameLayout)findViewById(R.id.layout_content);
        main_radio = (RadioGroup)findViewById(R.id.main_radio);

        main_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.rb_function:
                        index = 0;
                        break;
                    case R.id.rb_news_center:
                        index = 1;
                        break;
                    case R.id.rb_smart_service:
                        index = 2;
                        break;
                    case R.id.rb_gov_affairs:
                        index = 3;
                        break;
                    case R.id.rb_setting:
                        index = 4;
                        break;
                }
                //获取到对应index的Fragment,实际就是去调用对应的getItem方法
                BaseFragment baseFragment = (BaseFragment)statePagerAdapter.instantiateItem(layout_content, index);
                //通过索引指定的fragment替换对应的贞布局
                statePagerAdapter.setPrimaryItem(layout_content,0,baseFragment);
                //类似于事务的提交
                statePagerAdapter.finishUpdate(layout_content);
            }
        });
        main_radio.check(R.id.rb_function);
    }

    FragmentStatePagerAdapter statePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            BaseFragment baseFragment = null;
            switch (position){
                case 0:
                    baseFragment = new FunctionFragment();
                    break;
                case 1:
                    baseFragment = new NewsCenterFragment();
                    break;
                case 2:
                    baseFragment = new SmartServiceFragment();
                    break;
                case 3:
                    baseFragment = new GovAffairsFragment();
                    break;
                case 4:
                    baseFragment = new SettingFragment();
                    break;
            }
            return baseFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    };
}
