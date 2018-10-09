package com.example.nguyenthai.bt_nhom;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
    RecyclerView rc;
    //NewsAdapter2 newsAdapter;
    MoviesAdapter2 moviesAdapter2;
    //ArrayList<BBCNews> arrayList;
    ArrayList<Movies> arrayListMovies;

    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rc = view.findViewById(R.id.recycleGrid);

//        arrayList = new ArrayList<>();
//
//        newsAdapter = new NewsAdapter2(getContext(),R.layout.grid_layout,arrayList);
        arrayListMovies = new ArrayList<>();

        moviesAdapter2 = new MoviesAdapter2(getContext(),R.layout.grid_layout,arrayListMovies);

        rc.setLayoutManager(new GridLayoutManager(getContext(),2));

        rc.setAdapter(moviesAdapter2);

//        GridFragment.ParseJSON parseJSON = new GridFragment.ParseJSON();
//        parseJSON.execute("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=4a6000a26c5044e8902029f006547c1e");
        ParseJSON2 parseJSON = new ParseJSON2();
        parseJSON.execute("https://api.androidhive.info/json/glide.json");

    }


    class ParseJSON2 extends AsyncTask<String,Void,ArrayList<Movies>> {

        @Override
        protected ArrayList<Movies> doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = bufferedReader.readLine();
                StringBuilder sb = new StringBuilder();

                while(line != null){
                    sb.append(line);
                    line = bufferedReader.readLine();
                }


                ArrayList<Movies> data = new ArrayList<>();

                //JSONObject jsonObject = new JSONObject(sb.toString());
                //JSONArray jsonArray = jsonObject.getJSONArray("");
                JSONArray jsonArray = new JSONArray(sb.toString());
                for(int i=0; i< jsonArray.length();i++){
                    JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                    String title = jsonObject1.getString("name");
                    JSONObject jsonObjecturl = jsonObject1.getJSONObject("url");
                    String image = jsonObjecturl.getString("medium");
                    String releaseYear = jsonObject1.getString("timestamp");
                    //String genre = jsonObject1.getString("genre");


                    data.add(new Movies(title,image,"",releaseYear,""));
                }
                return data;


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Movies> movies) {
            super.onPostExecute(movies);
            arrayListMovies.addAll(movies);
            moviesAdapter2.notifyDataSetChanged();
        }
    }

}
