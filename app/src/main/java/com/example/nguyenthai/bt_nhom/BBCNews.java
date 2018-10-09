package com.example.nguyenthai.bt_nhom;

/**
 * Created by NGUYENTHAI on 2/3/2018.
 */

public class BBCNews {
    String title;
    String publish;
    String url;

    public BBCNews() {
    }

    public BBCNews(String title, String publish, String url) {
        this.title = title;
        this.publish = publish;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
