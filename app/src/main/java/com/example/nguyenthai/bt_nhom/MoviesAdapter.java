package com.example.nguyenthai.bt_nhom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HV on 2/4/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.NewsHolder> {

    Context context;
    ArrayList<Movies> arrayList;
    int layout;

    public MoviesAdapter(Context context,  int layout,ArrayList<Movies> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout,null);


        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        Movies movies = arrayList.get(position);

        holder.title.setText(movies.getTitle());
//        holder.rate(movies.getRating());
       holder.releaseYear.setText(movies.getReleaseYear());
//        holder.genre(movies.getGenre());
        Picasso.with(context).load(movies.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView rate;
        TextView releaseYear;
        TextView genre;


        public NewsHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.txtTitle);
            rate = itemView.findViewById(R.id.txtPublish);
            releaseYear = itemView.findViewById(R.id.txtPublish);
//            genre = itemView.findViewById(R.id.txtGenre);
        }
    }
}


