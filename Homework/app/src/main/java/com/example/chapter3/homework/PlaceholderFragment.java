package com.example.chapter3.homework;


import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private static final String TAG="PlaceholderFragment";
    public View viewMain=null;
    String[] friendNames = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        Log.d(TAG, "onCreateView: ");
        friendNames = new String[]{
                "我的好友a",
                "我的好友b",
                "我的好友c",
                "我的好友d",
                "我的好友e",
                "我的好友f",
                "我的好友g",
                "我的好友h",
                "我的好友i",
                "我的好友j",
                "我的好友k",
                "我的好友l",
                "我的好友m",
                "我的好友n",
        };

        viewMain = inflater.inflate(R.layout.fragment_placeholder, container, false);
        ListView listViewMain = (ListView) viewMain.findViewById(R.id.list_view_main);
        ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        listViewMain.setAdapter(new ListViewAdapter(viewPager.getContext(), friendNames));
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvName = view.findViewById(R.id.tv_name);
                Toast.makeText(view.getContext(), tvName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        listViewMain.setVisibility(View.INVISIBLE);
        return viewMain;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                Log.d(TAG, "run: ");
                LottieAnimationView lavLoading = viewMain.findViewById(R.id.loading);
                ListView lvMain = viewMain.findViewById(R.id.list_view_main);

                lvMain.setVisibility(View.VISIBLE);
                lavLoading.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                lvMain.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));

                getView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lavLoading.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
            }
        }, 5000);
    }
}
