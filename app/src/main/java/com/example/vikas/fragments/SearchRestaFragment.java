package com.example.vikas.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vikas.adapters.RestaResultAdapter;
import com.example.vikas.factualApi.FactualApiService;
import com.example.vikas.model.SearchResult;
import com.example.vikas.model.SearchResultResponse;
import com.example.vikas.myapplication.R;

/**
 * Created by Vikas on 3/12/2016.
 */
public class SearchRestaFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar mProgressBar;
    private TextView mSearchSuggestionTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_resta, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mProgressBar = (ProgressBar)super.getActivity().findViewById(R.id.progressBar);
        mSearchSuggestionTextView = (TextView)super.getActivity().findViewById(R.id
                .search_suggestion_textView);
        mRecyclerView = (RecyclerView) super.getActivity().findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(super.getContext());
        mRecyclerView.setLayoutManager(layoutManager);



    }

    public void getSearchResult(String query){

        AsyncTask<String, Void, SearchResultResponse> searchAsynkTask = new AsyncTask<String,
                Void, SearchResultResponse>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                SearchRestaFragment.this.mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected SearchResultResponse doInBackground(String... params) {
                FactualApiService factualApiService = new FactualApiService();
                SearchResultResponse searchResultResponse = factualApiService.getRestaurants
                        (params[0]);
                System.out.println(searchResultResponse.toString());
                return searchResultResponse;

            }

            @Override
            protected void onPostExecute(SearchResultResponse searchResultResponse) {
                super.onPostExecute(searchResultResponse);
                SearchRestaFragment.this.mProgressBar.setVisibility(View.GONE);

                if (searchResultResponse != null && searchResultResponse.getStatus()
                        .equalsIgnoreCase("ok") &&
                        searchResultResponse.getResponse().getData().length != 0) {

                    //hide search suggestion textView
                    SearchRestaFragment.this.mSearchSuggestionTextView.setVisibility(View.GONE);
                    //show list
                    SearchRestaFragment.this.mRecyclerView.setVisibility(View.VISIBLE);

                    //set adapater
                    SearchRestaFragment.this.mAdapter = new RestaResultAdapter(searchResultResponse
                            .getResponse().getData());
                    SearchRestaFragment.this.mRecyclerView.setAdapter(SearchRestaFragment.this
                            .mAdapter);

                }else{
                    // show search suggestion text view
                    SearchRestaFragment.this.mSearchSuggestionTextView.setVisibility(View.VISIBLE);
                    // hide list
                    SearchRestaFragment.this.mRecyclerView.setVisibility(View.GONE);

                    Toast.makeText(SearchRestaFragment.this.getContext(), SearchRestaFragment
                            .this.getText(R.string.error_message),Toast.LENGTH_SHORT).show();
                }

            }
        };
        searchAsynkTask.execute(query);

    }
}
