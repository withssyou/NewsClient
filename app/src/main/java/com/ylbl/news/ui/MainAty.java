package com.ylbl.news.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ylbl.news.fmg.GuojiFmg;
import com.ylbl.news.fmg.GuoneiFmg;
import com.ylbl.news.R;
import com.ylbl.news.fmg.TopFmg;

/**
 *  控制器  数据 mvc mvp  mvvm
 *  生命周期的方法
 *
 */

public class MainAty extends AppCompatActivity implements View.OnClickListener {
    private TextView top ;  //成员变量
    private TextView guoji;
    private TextView guonei;
    private FrameLayout fl;
    private Fragment topFmg , guojiFmg , guoneiFmg;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aty);
        init();
    }

    /**
     * 页面初始化
     */
    private void init() {
        top = findViewById(R.id.top);
        guoji = findViewById(R.id.guoji);
        guonei = findViewById(R.id.guonei);
        fl = findViewById(R.id.aty_fl);

        top.setOnClickListener(this);
        guoji.setOnClickListener(this);
        guonei.setOnClickListener(this);

        supportFragmentManager = getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        topFmg = new TopFmg();
        fragmentTransaction.add(R.id.aty_fl, topFmg).commit();

    }

    @Override
    public void onClick(View v) {
        hideFrag();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.top: //头条  Fragment显示
                fragmentTransaction.show(topFmg).commit();
                setTextColor(top);
                break;
            case R.id.guoji:    // 国际
                if (guojiFmg == null) {
                    guojiFmg = new GuojiFmg();
                    fragmentTransaction.add(R.id.aty_fl, guojiFmg).commit();
                } else {
                    fragmentTransaction.show(guojiFmg).commit();
                }
                setTextColor(guoji);
                break;
            case R.id.guonei: // 国内
                if (guoneiFmg == null) {
                    guoneiFmg = new GuoneiFmg();
                    fragmentTransaction.add(R.id.aty_fl, guoneiFmg).commit();
                } else {
                    fragmentTransaction.show(guoneiFmg).commit();
                }
                setTextColor(guonei);
//                case R.id.guonei: // 国内
//                if (guoneiFmg == null) {
//                    guoneiFmg = new GuoneiFmg();
//                    fragmentTransaction.add(R.id.aty_fl, guoneiFmg).commit();
//                } else {
//                    fragmentTransaction.show(guoneiFmg).commit();
//                }
//                setTextColor(guonei);
                break;
        }
    }

    private void setTextColor(TextView temp) {
        top.setTextColor(getResources().getColor(R.color.colorGray));
        guoji.setTextColor(getResources().getColor(R.color.colorGray));
        guonei.setTextColor(getResources().getColor(R.color.colorGray));
        temp.setTextColor(getResources().getColor(R.color.colorRed));
    }

    /**
     * fragment切换时隐藏
     */
    private void hideFrag() {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (topFmg != null && topFmg.isAdded()) {
            fragmentTransaction.hide(topFmg);
        }
        if (guojiFmg != null && guojiFmg.isAdded()) {
            fragmentTransaction.hide(guojiFmg);
        }
        if (guoneiFmg != null && guoneiFmg.isAdded()) {
            fragmentTransaction.hide(guoneiFmg);
        }
        fragmentTransaction.commit();
    }
}
