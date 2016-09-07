package com.brioal.label;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.brioal.labelview.LabelView;
import com.brioal.labelview.entity.LabelEntity;
import com.brioal.labelview.interfaces.OnLabelSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LabelView mLabelView;
    List<LabelEntity> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLabelView = (LabelView) findViewById(R.id.main_label);
        mLabelView.setListener(new OnLabelSelectedListener() {
            @Override
            public void selected(int position, String content) {
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        });
        mList = new ArrayList<>();
        mList.add(new LabelEntity("对方的", "的钱我的我"));
        mList.add(new LabelEntity("打扫打扫", "的钱我的我"));
        mList.add(new LabelEntity("打扫打扫", "的钱我的我"));
        mList.add(new LabelEntity("打扫打扫打扫打扫", "的钱我的我"));
        mList.add(new LabelEntity("连骗带哄", "的钱我的我"));
        mList.add(new LabelEntity("连骗带哄", "的钱我的我"));
        mList.add(new LabelEntity("额文件", "的钱我的我"));
        mList.add(new LabelEntity("额文件", "的钱我的我"));
        mList.add(new LabelEntity("额文件", "的钱我的我"));
        mList.add(new LabelEntity("发生的纷纷", "的钱我的我"));
        mList.add(new LabelEntity("发生的纷纷", "的钱我的我"));
        mList.add(new LabelEntity("夫人突然", "的钱我的我"));
        mList.add(new LabelEntity("还特意让他", "的钱我的我"));
        mList.add(new LabelEntity("惹人", "的钱我的我"));
        mList.add(new LabelEntity("惹人", "的钱我的我"));
        mList.add(new LabelEntity("惹人", "的钱我的我"));
        mList.add(new LabelEntity("惹人", "的钱我的我"));
        mList.add(new LabelEntity("惹人", "的钱我的我"));
        mLabelView.setLabels(mList);
    }
}
