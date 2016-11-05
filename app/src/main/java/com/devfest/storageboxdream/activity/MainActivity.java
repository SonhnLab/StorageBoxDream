package com.devfest.storageboxdream.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.View;

import com.devfest.storageboxdream.R;
import com.devfest.storageboxdream.adapter.IconAdapter;
import com.devfest.storageboxdream.common.FirebaseHelper;
import com.devfest.storageboxdream.entity.Icon;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //region Properties

    SearchView mSearchView;

    RecyclerView mRecyclerView;

    DatabaseReference mDatabaseReference;

    FirebaseHelper mFirebaseHelper;

    //endregion

    //region Override methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Firebase

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseHelper = new FirebaseHelper(mDatabaseReference);

        //endregion

        //region Adapter

        final IconAdapter adapter = new IconAdapter(this, mFirebaseHelper.retrieve());

        //endregion

        mSearchView = (SearchView) findViewById(R.id.sv_image);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4,dpToPx(10),true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    //endregion

    //region Private methods

    private ArrayList<Icon> getImages() {
        ArrayList<Icon> icons = new ArrayList<>();
//        Image image = new Image("Plane", R.drawable.ic_plane);
//        images.add(image);
//
//        image = new Image("Car", R.drawable.ic_car);
//        images.add(image);
//
//        image = new Image("Santa Claus", R.drawable.ic_santa_claus);
//        images.add(image);
//
//        image = new Image("Devil", R.drawable.ic_devil);
//        images.add(image);
//
//        image = new Image("Teacher Man", R.drawable.ic_teacher_man);
//        images.add(image);
//
//        image = new Image("Teacher Woman", R.drawable.ic_teacher_woman);
//        images.add(image);

        return icons;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int mSpanCount;
        private int mSpacing;
        private boolean mIncludeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            mSpanCount = spanCount;
            mSpacing = spacing;
            mIncludeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            // item position
            int position = parent.getChildAdapterPosition(view);
            // item column
            int column = position % mSpanCount;

            if (mIncludeEdge){
                outRect.left = mSpacing - column * mSpacing / mSpanCount;
                outRect.right = (column + 1) * mSpacing / mSpanCount;
                if (position < mSpanCount){
                    outRect.top = mSpacing;
                }
                outRect.bottom = mSpacing;
            }else {
                outRect.left = column * mSpacing / mSpanCount;
                outRect.right = mSpacing - (column + 1) * mSpacing / mSpanCount;
                if (position >= mSpanCount){
                    outRect.top = mSpacing;
                }
                outRect.bottom = mSpacing;
            }
        }
    }

    /**
     * Converting dp to pixel
     */

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    //endregion
}
