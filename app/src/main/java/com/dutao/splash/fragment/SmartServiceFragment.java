package com.dutao.splash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * com.dutao.splash.fragment
 * Created by dutao on 2015/7/8.
 */
public class SmartServiceFragment extends com.dutao.splash.base.BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("SmartService");
        return textView;
    }
}
