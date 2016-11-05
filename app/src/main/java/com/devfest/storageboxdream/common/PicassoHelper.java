package com.devfest.storageboxdream.common;

import android.content.Context;
import android.widget.ImageView;

import com.devfest.storageboxdream.R;
import com.squareup.picasso.Picasso;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class PicassoHelper {

    public static void downloadImage(Context context, String url, ImageView imageView) {
        if (url != null && url.length() >0 ) {
            Picasso.with(context).load(url).placeholder(R.drawable.ic_picture).into(imageView);
        } else {
            Picasso.with(context).load(R.drawable.ic_picture).into(imageView);
        }
    }

}
