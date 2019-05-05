package com.example.anshul.p1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anshul.p1.R;
import com.example.anshul.p1.SearchAdapterRest;
import com.example.anshul.p1.cont_rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshul on 1/18/2018.
 */

public class rest_tab1 extends Fragment {
    public rest_tab1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View mView;
    private List<cont_rest> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchAdapterRest mAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int position = getArguments().getInt("pos");
        mView = inflater.inflate(R.layout.rest_tab1, container, false);
        if(position == 0)
        {
            prepData1();
        }
        else if(position == 1)
        {
            prepData2();
        }
        else if(position == 2)
        {
            prepData3();
        }
        else
        {
            prepData4();
        }
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view_rest1);
        mAdapter = new SearchAdapterRest(mList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return mView;
    }

    private void prepData1() {
        cont_rest c = new cont_rest("Burger","https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg","onion,cheese,chilly",12);
        mList.add(c);

        c = new cont_rest("Pizza","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","onion,cheese,chilly",10);
        mList.add(c);

        c = new cont_rest("Pasta","https://static.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg","onion,cheese,chilly",8);
        mList.add(c);
    }

    private void prepData2() {
        cont_rest c = new cont_rest("Pizza","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","onion,cheese,chilly",10);
        mList.add(c);

        c = new cont_rest("Burger","https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg","onion,cheese,chilly",12);
        mList.add(c);

        c = new cont_rest("Pasta","https://static.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg","onion,cheese,chilly",8);
        mList.add(c);
    }

    private void prepData3() {
        cont_rest c = new cont_rest("Pasta","https://static.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg","onion,cheese,chilly",8);
        mList.add(c);

        c = new cont_rest("Pizza","https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg","onion,cheese,chilly",10);
        mList.add(c);

        c = new cont_rest("Burger","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","onion,cheese,chilly",12);
        mList.add(c);
    }

    private void prepData4() {
        cont_rest c = new cont_rest("Burger","https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg","onion,cheese,chilly",12);
        mList.add(c);

        c = new cont_rest("Pizza","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg","onion,cheese,chilly",10);
        mList.add(c);

        c = new cont_rest("Pasta","https://static.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg","onion,cheese,chilly",12);
        mList.add(c);
    }

}
