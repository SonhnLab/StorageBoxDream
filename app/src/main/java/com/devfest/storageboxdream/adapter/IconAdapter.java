package com.devfest.storageboxdream.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.devfest.storageboxdream.R;
import com.devfest.storageboxdream.common.MyViewHolder;
import com.devfest.storageboxdream.common.PicassoHelper;
import com.devfest.storageboxdream.entity.Icon;
import com.devfest.storageboxdream.interfaces.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class IconAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {

    //region Properties

    Context mContext;

    ArrayList<Icon> mIcons, mFilterList;

    CustomFilter mCustomFilter;

    //endregion

    //region Constructions

    public IconAdapter(Context context, ArrayList<Icon> imageList) {
        this.mContext = context;
        this.mIcons = imageList;
        this.mFilterList = imageList;
    }

    //endregion

    //region Override methods

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_image, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mName.setText(mIcons.get(position).getName());
        PicassoHelper.downloadImage(mContext, mIcons.get(position).getUrl(), holder.mIcon);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Snackbar.make(view, mIcons.get(position).getName(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIcons.size();
    }

    @Override
    public Filter getFilter() {
        if (mCustomFilter == null) {
            mCustomFilter = new CustomFilter(mFilterList, this);
        }
        return mCustomFilter;
    }

    //endregion
}
