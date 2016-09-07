package com.brioal.labelview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brioal.labelview.entity.LabelEntity;
import com.brioal.labelview.interfaces.OnLabelSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 以后增加的功能  可拖动 , 可删除, 可动态添加
 * Created by Brioal on 2016/9/7.
 */
public class LabelView extends ViewGroup {
    private List<TextView> mTvs;
    private int mWidth;
    private int mHeight;
    private int mLabelPading;
    private OnLabelSelectedListener mListener;
    private int mLabelColor = Color.RED;


    public LabelView(Context context) {
        super(context);
    }

    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setLabelColor(int labelColor) {
        mLabelColor = labelColor;
    }

    public void setListener(OnLabelSelectedListener listener) {
        mListener = listener;
    }

    public void setLabels(final List<LabelEntity> labels) {
        mTvs = new ArrayList<>();
        mLabelPading = 10;
        for (int i = 0; i < labels.size(); i++) {
            TextView tv = new TextView(getContext());
            tv.setBackgroundResource(R.drawable.label_bg);
            tv.setPadding(mLabelPading * 2, mLabelPading, mLabelPading * 2, mLabelPading);
            tv.setTextColor(Color.WHITE);
            tv.setText(labels.get(i).getTitle());
            tv.getBackground().setColorFilter(mLabelColor, PorterDuff.Mode.ADD);
            final int finalI = i;
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.selected(finalI, labels.get(finalI).getContent());
                    }
                }
            });
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            addView(tv, params);
            mTvs.add(tv);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        int count = 0;
        int w = 0;
        for (int i = 0; i < getChildCount(); i++) {
            TextView tv = (TextView) getChildAt(i);
            measureChild(tv, widthMeasureSpec, heightMeasureSpec);
            if (w + tv.getMeasuredWidth() > mWidth) {
                count++;
                w = 0;
            }
            w += tv.getMeasuredWidth();
        }
        if (w > 0) {
            count++;
        }
        System.out.println("Count" + count);
        setMeasuredDimension(mWidth, count * (mLabelPading * 2 + getChildAt(0).getMeasuredHeight()));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int startX = mLabelPading;
        int startY = mLabelPading;
        for (int i = 0; i < getChildCount(); i++) {
            TextView tv = (TextView) getChildAt(i);
            if (startX + tv.getMeasuredWidth() > mWidth) {
                startX = mLabelPading;
                startY += mLabelPading * 2 + tv.getMeasuredHeight();
            }
            tv.layout(startX, startY, startX + tv.getMeasuredWidth(), startY + tv.getMeasuredHeight());
            startX += tv.getMeasuredWidth() + mLabelPading;
        }
    }
}
