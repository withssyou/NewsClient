package com.ylbl.news;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

/**
 * 网络加载框
 */
public class CommonLoadingDialog extends Dialog {
    private static final int CHANGE_TITLE_WHAT = 1;
    private static final int CHNAGE_TITLE_DELAYMILLIS = 300;
    private static final int MAX_SUFFIX_NUMBER = 3;
    private static final char SUFFIX = '.';

    private TextView detail_tv;
    private TextView tv_point;
    private RotateAnimation mAnim;

    private Handler handler = new Handler() {
        private int num = 0;

        public void handleMessage(android.os.Message msg) {
            if (msg.what == CHANGE_TITLE_WHAT) {

                if (isShowing()) {
                    handler.sendEmptyMessageDelayed(CHANGE_TITLE_WHAT,
                            CHNAGE_TITLE_DELAYMILLIS);
                } else {
//					num = 0;
                }
            }
        };
    };

    public CommonLoadingDialog(Context context) {
        super(context, R.style.common_load_dialog);
        init();
    }

    private void init() {
        setContentView(R.layout.common_dialog_loading_layout);
//		detail_tv = (TextView) findViewById(R.id.detail_tv);
//		tv_point = (TextView) findViewById(R.id.tv_point);
//		initAnim();
//		getWindow().setWindowAnimations(R.anim.);
    }

    private void initAnim() {
        // mAnim = new RotateAnimation(360, 0, Animation.RESTART, 0.5f,
        // Animation.RESTART, 0.5f);
        mAnim = new RotateAnimation(0, 360, Animation.RESTART, 0.5f,
                Animation.RESTART, 0.5f);
        mAnim.setDuration(2000);
        mAnim.setRepeatCount(Animation.INFINITE);
        mAnim.setRepeatMode(Animation.RESTART);
        mAnim.setStartTime(Animation.START_ON_FIRST_FRAME);
    }

    @Override
    public void show() {
//		handler.sendEmptyMessage(CHANGE_TITLE_WHAT);
//        super.show();
    }

    @Override
    public void dismiss() {
//		mAnim.cancel();
        super.dismiss();
    }

}
