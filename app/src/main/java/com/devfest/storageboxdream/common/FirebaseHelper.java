package com.devfest.storageboxdream.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.devfest.storageboxdream.entity.Icon;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class FirebaseHelper {

    //region Properties

    DatabaseReference mDatabaseReference;

    Boolean mSaved = null;

    ArrayList<Icon> mImageArray = new ArrayList<>();

    //endregion

    //region Lifecycle

    public FirebaseHelper(DatabaseReference databaseReference) {
        mDatabaseReference = databaseReference;
    }

    public ArrayList<Icon> retrieve() {
        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return mImageArray;
    }

    //endregion

    //region Private methods

    private void fetchData(DataSnapshot dataSnapshot) {
        mImageArray.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Icon icon = new Icon();
            icon.setName(ds.getValue(Icon.class).getName());
            icon.setUrl(ds.getValue(Icon.class).getUrl());
            mImageArray.add(icon);
        }

    }

    //endregion
}
