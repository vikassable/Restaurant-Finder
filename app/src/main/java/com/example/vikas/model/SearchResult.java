package com.example.vikas.model;

import java.util.Arrays;

/**
 * Created by Vikas on 3/11/2016.
 */
public class SearchResult {

    private String locality;
    private String name;
    private float rating;
    private String address;
    private String []cuisine;
    private String postcode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getCuisine() {
        return cuisine;
    }

    public void setCuisine(String []cuisine) {
        this.cuisine = cuisine;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "locality='" + locality + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", cuisine=" + Arrays.toString(cuisine) +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
