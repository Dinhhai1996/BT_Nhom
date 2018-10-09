package com.example.nguyenthai.bt_nhom;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class ListFragment extends Fragment {

    RecyclerView rc;
    //NewsAdapter newsAdapter;

    MoviesAdapter moviesAdapter;
    //ArrayList<BBCNews> arrayList;
    ArrayList<Movies> arrayListMovies;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rc = view.findViewById(R.id.recycleList);

        //arrayList = new ArrayList<>();
        arrayListMovies = new ArrayList<>();

//        newsAdapter = new NewsAdapter(getContext(),R.layout.list_layout,arrayList);
//
//        rc.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL,
//                false));
//
//        rc.setAdapter(newsAdapter);
        moviesAdapter = new MoviesAdapter(getContext(),R.layout.list_layout,arrayListMovies);

        rc.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false));

        rc.setAdapter(moviesAdapter);

//        ParseJSON parseJSON = new ParseJSON();
//        parseJSON.execute("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=4a6000a26c5044e8902029f006547c1e");


        ParseJSON2 parseJSON = new ParseJSON2();
        parseJSON.execute("https://api.androidhive.info/json/glide.json");

    }

//    class ParseJSON extends AsyncTask<String,Void,ArrayList<BBCNews>> {
//
//        @Override
//        protected ArrayList<BBCNews> doInBackground(String... strings) {
//
//            try {
//                URL url = new URL(strings[0]);
//                URLConnection urlConnection = url.openConnection();
//                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
//
//                InputStream inputStream = httpURLConnection.getInputStream();
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//                String line = bufferedReader.readLine();
//                StringBuilder sb = new StringBuilder();
//
//                while(line != null){
//                    sb.append(line);
//                    line = bufferedReader.readLine();
//                }
//
//                ArrayList<BBCNews> data = new ArrayList<>();
//
//                JSONObject jsonObject = new JSONObject(sb.toString());
//                JSONArray jsonArray = jsonObject.getJSONArray("articles");
//                for(int i=0; i< jsonArray.length();i++){
//                    JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
//                    String title = jsonObject1.getString("title");
//                    String url1 = jsonObject1.getString("urlToImage");
//                    String publish = jsonObject1.getString("publishedAt");
//
//                    data.add(new BBCNews(title,publish,url1));
//                }
//                return data;
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<BBCNews> bbcNews) {
//            super.onPostExecute(bbcNews);
//            arrayList.addAll(bbcNews);
//            newsAdapter.notifyDataSetChanged();
//        }
//    }
class ParseJSON extends AsyncTask<String,Void,ArrayList<Movies>> {

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
                String image = jsonObject1.getString("image");
                String rate = jsonObject1.getString("rating");
                String releaseYear = jsonObject1.getString("timestamp");
                String genre = jsonObject1.getString("genre");

                data.add(new Movies(title,image,rate,releaseYear,genre));
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
        moviesAdapter.notifyDataSetChanged();
    }
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
            moviesAdapter.notifyDataSetChanged();
        }
    }

}
