package com.brioal.labelview.entity;

/**
 * LabelView Entity
 * Created by Brioal on 2016/9/7.
 */
public class LabelEntity {
    private String mTitle;
    private String mContent;

    public LabelEntity(String title, String content) {
        mTitle = title;
        mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
