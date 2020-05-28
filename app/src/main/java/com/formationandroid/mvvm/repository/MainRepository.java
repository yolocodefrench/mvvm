package com.formationandroid.mvvm.repository;

import android.preference.PreferenceActivity;
import android.util.Log;

import com.formationandroid.mvvm.dao.ExampleDAO;
import com.formationandroid.mvvm.model.Item;
import com.formationandroid.mvvm.webServiceItems.RetourWs;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.MutableLiveData;
import cz.msebera.android.httpclient.Header;

public class MainRepository{

    @Singleton
    @Inject
    ExampleDAO exampleDAO;
    // Récupération de données :
    public void getLiveDataItem(final MutableLiveData<Item> liveDataItem)
    {


        // client HTTP :
        final AsyncHttpClient client = new AsyncHttpClient();
        // paramètres :
        RequestParams requestParams = new RequestParams();
        // appel :
        client.get("https://swapi.dev/api/planets/1/", requestParams, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // récupération :
                Item item = new Item();
                String retour = new String(responseBody);
                // conversion en un objet Java (à faire!) ayant le même format que le JSON :
                Gson gson = new Gson();
                RetourWs retourWS = gson.fromJson(retour, RetourWs.class);
                Log.i("essai", retour);
                Log.i("essai", retourWS.name);
                item.libelle = retourWS.name;
                liveDataItem.setValue(item);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] errorResponse, Throwable e)
            {
                Log.e("essai", e.toString());
            }
        });
        // mise à jour :

    }


}
