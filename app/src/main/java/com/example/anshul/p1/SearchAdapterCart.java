package com.example.anshul.p1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.example.anshul.p1.Cart.list;
import static com.example.anshul.p1.Cart.sum;

/**
 * Created by Anshul on 1/24/2018.
 */

public class SearchAdapterCart extends RecyclerView.Adapter<SearchAdapterCart.MyViewHolder> {
    private List<DTO_cart> mList;
    Context context;
    public static int flagcart =-1;
    public List<DTO_cart> c = new ArrayList<DTO_cart>();
    public Context ctx;
    FragmentManager fragmentManager;
    TextView tv;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView name, qty, price;
        public ImageView image;
        public Button b1, b2;

        public MyViewHolder(View view, Context context, List<DTO_cart> contents) {
            super(view);

            name = (TextView) view.findViewById(R.id.tv1_cart);
            image = (ImageView) view.findViewById(R.id.iv_cart);
            qty = (TextView) view.findViewById(R.id.tv3_cart);
            price = (TextView) view.findViewById(R.id.tv2_cart);

            c = contents;
            ctx = context;

            b1 = view.findViewById(R.id.b1_cart);
            b2 = view.findViewById(R.id.b2_cart);


        }


    }

    public void onBindViewHolder(final SearchAdapterCart.MyViewHolder holder, final int position) {
        final SearchAdapterCart.MyViewHolder h1 = holder;
        final DTO_cart con = mList.get(position);
        h1.name.setText(con.getName());
        h1.price.setText(con.getPrice());
        h1.qty.setText("" + con.getQty());
        // holder.image.setImageDrawable();
        //ImageView imageView = holder.image;
        String currentUrl = con.getImg();
        Glide.with(context).load(currentUrl).into(holder.image);

        //creating Total
        String s = con.getName();
        if (s.compareToIgnoreCase("burger") == 0) {
            sum += ((con.getQty()) * Integer.parseInt(con.getPrice()));
        } else if (s.compareToIgnoreCase("pizza") == 0) {
            sum += ((con.getQty()) * Integer.parseInt(con.getPrice()));
        } else if (s.compareToIgnoreCase("pasta") == 0) {
            sum += ((con.getQty()) * Integer.parseInt(con.getPrice()));
        }
        tv.setText("Total: $" + sum);


        h1.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(h1.qty.getText().toString());
                a++;
                h1.qty.setText("" + a);
                con.setQty(a);
                if (a > 0) {
                    h1.b2.setClickable(true);
                    flagcart = -1;
                }

                String s = con.getName();
                if (s.compareToIgnoreCase("burger") == 0) {
                    sum += Integer.parseInt(con.getPrice());
                } else if (s.compareToIgnoreCase("pizza") == 0) {
                    sum += Integer.parseInt(con.getPrice());
                } else if (s.compareToIgnoreCase("pasta") == 0) {
                    sum += Integer.parseInt(con.getPrice());
                }
                tv.setText("Total: $" + sum);
            }
        });


        h1.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(h1.qty.getText().toString());
                if (a == 1) {
                    flagcart = position;

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);

                    alertDialogBuilder.setTitle("Do you want to remove this item from cart");
                    alertDialogBuilder
                            .setMessage("Click yes to remove")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    list.remove(flagcart);
                                    flagcart = -1;
                                    Intent i = new Intent(context,Cart.class);
                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    context.startActivity(i);
                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, just close
                                    flagcart = -1;
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else {
                    a--;
                    h1.qty.setText("" + a);
                    con.setQty(a);
                    String s = con.getName();
                    if (s.compareToIgnoreCase("burger") == 0) {
                        sum -= Integer.parseInt(con.getPrice());
                    } else if (s.compareToIgnoreCase("pizza") == 0) {
                        sum -= Integer.parseInt(con.getPrice());
                    } else if (s.compareToIgnoreCase("pasta") == 0) {
                        sum -= Integer.parseInt(con.getPrice());
                    }
                    tv.setText("Total: $" + sum);
                }
            }
        });
        // Picasso.with(context).load(con.getImg()).error(R.drawable.pizza).into(holder.image);
    }

    public SearchAdapterCart.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup_cart, parent, false);

        return new SearchAdapterCart.MyViewHolder(itemView, context, mList);
    }

    public SearchAdapterCart(List<DTO_cart> mList, Context context, TextView textView) {
        this.mList = mList;
        this.context = context;
        tv = textView;
        sum = 0;
    }

    public int getItemCount() {
        return mList.size();
    }
}
