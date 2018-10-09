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

public class MoviesAdapter2 extends RecyclerView.Adapter<MoviesAdapter2.NewsHolder> {

    Context context;
    //ArrayList<BBCNews> arrayList;
    ArrayList<Movies> arrayListMovies;
    int layout;

    public MoviesAdapter2(Context context,  int layout,ArrayList<Movies> arrayList) {
        this.context = context;
        this.arrayListMovies = arrayList;
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
        Movies movies = arrayListMovies.get(position);

//        holder.title.setText(bbcNews.getTitle());
//        holder.publish.setText(bbcNews.getPublish());
        Picasso.with(context).load(movies.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arrayListMovies.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;
        TextView publish;

        public NewsHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
//            title = itemView.findViewById(R.id.txtTitle);
//            publish = itemView.findViewById(R.id.txtPublish);


        }
    }


}
