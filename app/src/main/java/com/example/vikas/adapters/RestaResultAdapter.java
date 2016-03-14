package com.example.vikas.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.vikas.model.SearchResult;
import com.example.vikas.myapplication.R;
import com.example.vikas.util.StringHelper;

import java.util.Arrays;

/**
 * Created by Vikas on 3/12/2016.
 */
public class RestaResultAdapter extends RecyclerView.Adapter<RestaResultAdapter.ViewHolder> {
    private SearchResult[] mSearchResults;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameTextView;
        public TextView mAddressTextView;
        public TextView mTypeTextView;
        public RatingBar mRatingBar;

        public ViewHolder(View v) {
            super(v);
            this.mNameTextView= (TextView)v.findViewById(R.id.name_textView);
            this.mAddressTextView = (TextView)v.findViewById(R.id.address_textView);
            this.mTypeTextView = (TextView)v.findViewById(R.id.type_textView);
            this.mRatingBar = (RatingBar)v.findViewById(R.id.rating_ratingView);
        }
    }

    public RestaResultAdapter(SearchResult[] searchResults) {
        this.mSearchResults = searchResults;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_cell,
                viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mNameTextView.setText(mSearchResults[i].getName());
        viewHolder.mAddressTextView.setText(mSearchResults[i].getAddress()+", "+mSearchResults[i]
                .getLocality()+","+mSearchResults[i].getPostcode());
        if(mSearchResults[i].getCuisine()!= null){
            viewHolder.mTypeTextView.setVisibility(View.VISIBLE);
            viewHolder.mTypeTextView.setText(StringHelper.getComaSeparatedString(mSearchResults[i].getCuisine()));
        }else{
            viewHolder.mTypeTextView.setVisibility(View.GONE);
        }

        viewHolder.mRatingBar.setRating(mSearchResults[i].getRating());
    }

    @Override
    public int getItemCount() {
        return mSearchResults.length;
    }


}
