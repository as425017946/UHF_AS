package com.speedata.uhf.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

public class ListScrollView extends ScrollView {

    public ListScrollView(Context context) {
        super(context);
    }

    public ListScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}