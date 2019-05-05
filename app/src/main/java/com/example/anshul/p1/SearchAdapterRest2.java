package com.example.anshul.p1;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Anshul on 1/19/2018.
 */

public class SearchAdapterRest2 extends RecyclerView.Adapter<SearchAdapterRest2.MyViewHolder> {

    private List<cont_rest2> mList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, date, content;
        public RatingBar ratingBar;
        public CircleImageView image;
        List<cont_rest2> c = new ArrayList<cont_rest2>();
        Context ctx;

        public MyViewHolder(View view, Context context, List<cont_rest2> contents) {
            super(view);
            view.setOnClickListener(this);
            name = (TextView) view.findViewById(R.id.tv1_rest_tab2);
            image = view.findViewById(R.id.iv_rest_tab2);
            date = (TextView) view.findViewById(R.id.tv2_rest_tab2);
            content = (TextView) view.findViewById(R.id.tv3_rest_tab2);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingbar2_rest_tab2);
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            DrawableCompat.setTint(stars,view.getResources().getColor(R.color.myyellow));
            c = contents;
            ctx = context;
        }

        public void onClick(View v) {

            int p = getAdapterPosition();
            // cont_rest c = this.c.get(p);
            Toast.makeText(ctx, Integer.toString(p), Toast.LENGTH_SHORT);

        }
    }

    public SearchAdapterRest2(List<cont_rest2> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    public SearchAdapterRest2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup_rest_tab2, parent, false);

        return new SearchAdapterRest2.MyViewHolder(itemView,context,mList);
    }

    public void onBindViewHolder(SearchAdapterRest2.MyViewHolder holder, int position) {
        cont_rest2 con = mList.get(position);
        holder.name.setText(con.getName());
        holder.content.setText(con.getContents());
        holder.date.setText(con.getDate());
        // holder.image.setImageDrawable();
        //ImageView imageView = holder.image;
        String currentUrl = con.getImg();
        Glide.with(context).load(currentUrl).into(holder.image);
        holder.ratingBar.setRating(con.getRating());

        // Picasso.with(context).load(con.getImg()).error(R.drawable.pizza).into(holder.image);
    }

    public int getItemCount() {
        return mList.size();
    }

}
