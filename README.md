# Label
流式布局,封装用于显示标签
##效果图:
![](https://github.com/Brioal/Label/blob/master/art/1.gif)
##使用方式:
###1.添加布局
```
    <com.brioal.labelview.LabelView
        android:id="@+id/main_label"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#213f"
        />


```
###2.代码设置:
```
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
        mLabelView.setLabelColor(Color.RED);
        mLabelView.setLabels(mList);

```
###完成
