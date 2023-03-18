package com.example.country;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText editTextSearch;
    private static final String url = "http://api.geonames.org/countryInfoJSON?username=quangtruong";
    public static List<Country> ListCountry;
//    private ListView listView;
//    private AdapterCustom adapter;
    private ItemAdapter adapter;
    private RecyclerView listView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int OK = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        try {
            onLoadList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        onSearchCountry();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    onLoadList();
                    int number = ListCountry.size();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void onLoadList()
    {
        new ConnectionInternet().execute();
    }

    private class ConnectionInternet extends AsyncTask<Void, Void, List<Country>> {

        @Override
        protected void onPreExecute() {
            swipeRefreshLayout.setRefreshing(true);
        }

        @Override
        protected List<Country> doInBackground(Void... voids) {
            List<Country> countries = new ArrayList<>();
            StringBuilder data = new StringBuilder();
            try {
                URL urlConnection = new URL(url);
                InputStreamReader in = new InputStreamReader(urlConnection.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(in);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    data.append(line);
                }
                countries = parseJsonString(data.toString());


            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            return countries;
        }

        @Override
        protected void onPostExecute(List<Country> countries) {
            swipeRefreshLayout.setRefreshing(false);
            ListCountry = countries;
            // adapter =  new AdapterCustom(MainActivity.this, R.layout.listview, countries);
            adapter =  new ItemAdapter(MainActivity.this, countries);
            listView.setAdapter(adapter);
            OK = 1;
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Country c = ListCountry.get(i);
//                    Intent intent = new Intent(MainActivity.this,DetailCountry.class);
//                    intent.putExtra("Detail",c);
//                    startActivity(intent);
//                }
//            });

        }
    }
    

    private List<Country> parseJsonString(String data) {
        List<Country> result = new ArrayList();

        try {
            JSONObject responseObject = new JSONObject(data);
            JSONArray earthquakes = responseObject.getJSONArray("geonames");
            int length = earthquakes.length();
            for (int idx = 0; idx < length; idx++) {

                JSONObject c = (JSONObject) earthquakes.get(idx);

                result.add(new Country(c.getString("continent"),
                        c.getString("capital"),
                        c.getString("population"),
                        c.getString("countryCode"),
                        c.getString("areaInSqKm"),
                        c.getString("countryName"),
                        c.getString("continentName"),
                        c.getString("currencyCode")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void onSearchCountry() {
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                List<Country> ListSearch = new ArrayList<>();
                if(charSequence.length() != 0 && OK == 1) {
                    for (Country country: ListCountry) {
                        if (country.getCountryName().toLowerCase().indexOf(charSequence.toString().toLowerCase()) != -1 || country.getCountryCode().toLowerCase().indexOf(charSequence.toString().toLowerCase()) != -1) {
                            ListSearch.add(country);
                        }
                    }
                    adapter.setData(ListSearch);
                } else {
                    adapter.setData(ListCountry);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
    private void init() {
        editTextSearch = (EditText) findViewById(R.id.edit_search);
        listView = (RecyclerView) findViewById(R.id.idListView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        listView.setLayoutManager(new LinearLayoutManager(this));
    }
}