package com.jzj.observablescrollview;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import static com.jzj.observablescrollview.ObservableScrollView.OnScrollListener;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ObservableScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
        mScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);
        mTextView.setText("idle");

        // 监听滚动
        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Log.d("MainActivity", "getViewTreeObserver - onScrollChanged");
            }
        });

        // SdkVersion >= 23时，可直接设置OnScrollChangeListener
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.d("MainActivity", "setOnScrollChangeListener - onScrollChange");
                }
            });
        }

        // ObservableScrollView提供的OnScrollListener，可监听滚动事件和滚动状态变化
        mScrollView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(ObservableScrollView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        mTextView.setText("idle");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        mTextView.setText("touch scroll");
                        break;
                    case SCROLL_STATE_FLING:
                        mTextView.setText("fling");
                        break;
                }
                Log.d("MainActivity", "setOnScrollListener - onScrollStateChanged, state = " + scrollState);
            }

            @Override
            public void onScroll(ObservableScrollView view, boolean isTouchScroll, int l, int t, int oldl, int oldt) {
                Log.d("MainActivity", "setOnScrollListener - onScroll");
            }
        });
    }
}
