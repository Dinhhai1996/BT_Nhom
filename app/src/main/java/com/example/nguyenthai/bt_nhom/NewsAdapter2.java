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


public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.NewsHolder> {

    Context context;
    ArrayList<BBCNews> arrayList;
    int layout;

    public NewsAdapter2(Context context,  int layout,ArrayList<BBCNews> arrayList) {
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
        BBCNews bbcNews = arrayList.get(position);

//        holder.title.setText(bbcNews.getTitle());
//        holder.publish.setText(bbcNews.getPublish());
        Picasso.with(context).load(bbcNews.getUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
