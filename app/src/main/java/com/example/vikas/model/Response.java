package com.example.vikas.model;

import java.util.Arrays;

/**
 * Created by Vikas on 3/11/2016.
 */
public class Response {
    private SearchResult []data;
    private int included_rows;

    public SearchResult[] getData() {
        return data;
    }

    public void setData(SearchResult[] data) {
        this.data = data;
    }

    public int getIncluded_rows() {
        return included_rows;
    }

    public void setIncluded_rows(int included_rows) {
        this.included_rows = included_rows;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + Arrays.toString(data) +
                ", included_rows=" + included_rows +
                '}';
    }
}
