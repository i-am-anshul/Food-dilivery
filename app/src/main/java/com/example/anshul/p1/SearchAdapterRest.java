package com.example.anshul.p1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.anshul.p1.Cart.list;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshul on 1/18/2018.
 */

public class SearchAdapterRest extends RecyclerView.Adapter<SearchAdapterRest.MyViewHolder>{

    private List<cont_rest> mList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, xyz, price;
        public ImageView image;
        List<cont_rest> c = new ArrayList<cont_rest>();
        Context ctx;
        public MyViewHolder(View view, Context context, List<cont_rest> contents) {
            super(view);
            view.setOnClickListener(this);
            name = (TextView) view.findViewById(R.id.name_rest_tab1);
            image = (ImageView) view.findViewById(R.id.iv_rest_tab1);
            xyz = (TextView) view.findViewById(R.id.contents_rest_tab1);
            price = (TextView) view.findViewById(R.id.price_rest_tab1);

            c = contents;
            ctx = context;
        }

        @Override
        public void onClick(View v) {

            int p = getAdapterPosition();
           // cont_rest c = this.c.get(p);
            cont_rest c = this.c.get(p);
            Intent i = new Intent(this.ctx,order_selection.class);
            i.putExtra("img",c.getImg());
            i.putExtra("name",c.getName());
            i.putExtra("price",c.getPrice());
            i.putExtra("cont",c.getContents());

            this.ctx.startActivity(i);


        }
    }

    public SearchAdapterRest(List<cont_rest> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public SearchAdapterRest.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup_rest_tab1, parent, false);

        return new SearchAdapterRest.MyViewHolder(itemView,context,mList);
    }
    public void onBindViewHolder(SearchAdapterRest.MyViewHolder holder, int position) {
        cont_rest con = mList.get(position);
        holder.name.setText(con.getName());
        holder.xyz.setText(con.getContents());
        holder.price.setText("$"+con.getPrice());
        // holder.image.setImageDrawable();
        //ImageView imageView = holder.image;
        String currentUrl = con.getImg();
        Glide.with(context).load(currentUrl).into(holder.image);
        // Picasso.with(context).load(con.getImg()).error(R.drawable.pizza).into(holder.image);
    }

    public int getItemCount() {
        return mList.size();
    }

}
