package com.devfest.storageboxdream.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devfest.storageboxdream.R;
import com.devfest.storageboxdream.interfaces.ItemClickListener;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //region Properties

    public ImageView mIcon;

    public TextView mName;

    ItemClickListener mItemClickListener;

    //endregion

    //region Constructions

    public MyViewHolder(View view) {
        super(view);

        mIcon = (ImageView) view.findViewById(R.id.iv_image);
        mName = (TextView) view.findViewById(R.id.tv_name_image);

        view.setOnClickListener(this);
    }

    //endregion

    //region Override methods

    @Override
    public void onClick(View view) {
        mItemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    //endregion
}
