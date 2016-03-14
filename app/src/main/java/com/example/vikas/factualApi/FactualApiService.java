package com.example.vikas.factualApi;

import android.util.Log;

import com.example.vikas.constants.FactualAPIConstants;
import com.example.vikas.model.SearchResultResponse;
import com.factual.driver.Factual;
import com.factual.driver.Query;
import com.factual.driver.ReadResponse;
import com.google.gson.Gson;

/**
 * Created by Vikas on 3/11/2016.
 */
public class FactualApiService {

    private Factual factual;
    private static final String KEY = "eVIMBE1mmJSTNdu899RqTGIfhhHgOablx5ZdbOG9";
    private static final String KEY_SECRET = "sfHxDHxr0Et2emUFcC0BDu74fJ8MfHYIryyKGGHB";

    public FactualApiService() {
        factual = new Factual(KEY, KEY_SECRET);
    }


    public SearchResultResponse getRestaurants(String locality) {

        try {


//            Factual factual = new Factual("eVIMBE1mmJSTNdu899RqTGIfhhHgOablx5ZdbOG9",
//                    "sfHxDHxr0Et2emUFcC0BDu74fJ8MfHYIryyKGGHB");
//            factual.debug(true);
//            String data = factual.fetch("restaurants-us", new Query().field("locality")
//                    .beginsWith("chicago").limit(3)
//            ).toString();
            ReadResponse response = factual.fetch(FactualAPIConstants.SEARCH_TABLE, new Query()
                    .field
                            (FactualAPIConstants.TABLE_FIELD_LOCALITY).beginsWith
                            (locality).only
                            (FactualAPIConstants.TABLE_FIELD_LOCALITY,
                                    FactualAPIConstants.TABLE_FIELD_NAME,
                                    FactualAPIConstants.TABLE_FIELD_RATING,
                                    FactualAPIConstants.TABLE_FIELD_ADDRESS,
                                    FactualAPIConstants.TABLE_FIELD_CUISINE,
                                    FactualAPIConstants.TABLE_FIELD_POST_CODE).sortDesc
                            (FactualAPIConstants.TABLE_FIELD_RATING));
            if (response != null) {
                Log.d(FactualApiService.class.getSimpleName(), response.toString());
                Gson gson = new Gson();
                SearchResultResponse searchResultResponse = gson.fromJson(response.getJson(),
                        SearchResultResponse.class);
                return searchResultResponse;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
