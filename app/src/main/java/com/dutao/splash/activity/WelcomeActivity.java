package com.dutao.splash.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.dutao.splash.R;
import com.dutao.splash.constants.SharePreferenceConstants;
import com.dutao.splash.util.ShareUtil;


public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Boolean isFirst = ShareUtil.getBooleanData(getApplicationContext(), SharePreferenceConstants.IS_FIRST);

        if(isFirst){
            Log.i("WelcomeActivity", "第一次进入引导页");
            ShareUtil.saveBooleanData(getApplicationContext(), SharePreferenceConstants.IS_FIRST, false);
            Intent intent = new Intent(WelcomeActivity.this,GuideActivity.class);
            startActivity(intent);
        }else{
            Log.i("WelcomeActivity","第二次进入主页面");
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
        }

        finish();
    }
}
