package com.devfest.storageboxdream.adapter;

import android.widget.Filter;

import com.devfest.storageboxdream.entity.Icon;

import java.util.ArrayList;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class CustomFilter extends Filter {

    //region Properties

    IconAdapter mIconAdapter;

    ArrayList<Icon> mFilterList;

    //endregion

    //region Constructions

    public CustomFilter(ArrayList<Icon> filterList, IconAdapter iconAdapter) {
        mIconAdapter = iconAdapter;
        mFilterList = filterList;
    }

    //endregion

    //region Override methods

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();

        if (charSequence != null && charSequence.length() > 0) {
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<Icon> filterIcon = new ArrayList<>();

            for (int i = 0; i < mFilterList.size(); i++) {
                if (mFilterList.get(i).getName().toUpperCase().contains(charSequence)) {
                    filterIcon.add(mFilterList.get(i));
                }
            }

            results.count = filterIcon.size();
            results.values = filterIcon;
        } else {
            results.count = mFilterList.size();
            results.values = mFilterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        mIconAdapter.mIcons = (ArrayList<Icon>) filterResults.values;
        mIconAdapter.notifyDataSetChanged();
    }

    //endregion
}
