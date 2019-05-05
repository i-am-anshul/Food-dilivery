package com.example.anshul.p1;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.anshul.p1.fragments.frag1;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static com.example.anshul.p1.Cart.list;

/**
 * Created by Anshul on 1/16/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<content> mList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name,address;
        public ImageView image;
        List<content> c = new ArrayList<content>();
        Context ctx;
        public MyViewHolder(View view, Context context, List<content> contents) {
            super(view);
            view.setOnClickListener(this);
            name = (TextView) view.findViewById(R.id.tv1);
            address = (TextView) view.findViewById(R.id.tv2);
            image = (ImageView) view.findViewById(R.id.iv);
            c = contents;
            ctx = context;
        }

        @Override
        public void onClick(View v) {

            list.clear();
            int p = getAdapterPosition();
            content c = this.c.get(p);
            Intent i = new Intent(this.ctx,rest_details.class);
            i.putExtra("img",c.getImg());
            i.putExtra("name",c.getName());
            i.putExtra("pos",p);
            this.ctx.startActivity(i);
        }
    }


    public SearchAdapter(List<content> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup, parent, false);

        return new MyViewHolder(itemView,context,mList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        content con = mList.get(position);
        holder.name.setText(con.getName());
        holder.address.setText(con.getAddress());
       // holder.image.setImageDrawable();
       //ImageView imageView = holder.image;
        String currentUrl = con.getImg();
        Glide.with(context).load(currentUrl).into(holder.image);
       // Picasso.with(context).load(con.getImg()).error(R.drawable.pizza).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
