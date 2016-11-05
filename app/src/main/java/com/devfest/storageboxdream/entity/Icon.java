package com.devfest.storageboxdream.entity;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class Icon {

    //region Properties

    private String mName;

    private String mUrl;

    //endregion

    //region Constructors

    public Icon() {
    }

    //endregion

    //region Getters and Setters

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    //endregion
}
