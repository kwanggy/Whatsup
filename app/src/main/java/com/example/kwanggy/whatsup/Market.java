package com.example.kwanggy.whatsup;

import android.graphics.drawable.Drawable;

/**
 * Created by kwanggy on 2014-12-26.
 */
public class Market {
    private String name,url;
    private Drawable icon;
    public Market(Drawable icon, String name, String url) {
        this.name = name;
        this.icon = icon;
        this.url = url;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setUrl(String url) {
        this.url=url;
    }
    public void setIcon(Drawable icon) {
        this.icon=icon;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public Drawable getIcon() {
        return icon;
    }
}
