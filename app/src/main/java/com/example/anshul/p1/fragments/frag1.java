package com.example.anshul.p1.fragments;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.androidnetworking.AndroidNetworking;
        import com.example.anshul.p1.R;
        import com.example.anshul.p1.SearchAdapter;
        import com.example.anshul.p1.content;
        import com.facebook.stetho.okhttp3.StethoInterceptor;
        import com.jacksonandroidnetworking.JacksonParserFactory;

        import java.util.ArrayList;
        import java.util.List;

        import okhttp3.OkHttpClient;

/**
 * Created by Anshul on 1/12/2018.
 */

public class frag1 extends Fragment{

    public frag1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private List<content> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchAdapter mAdapter;
    public View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_one, container, false);

        prepareMovieData();
        recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        mAdapter = new SearchAdapter(mList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        //click listener



        return mView;
    }

    private void prepareMovieData() {

        content c = new content("Resturant 1","address 1","https://drop.ndtv.com/albums/COOKS/pasta-vegetarian/pastaveg_640x480.jpg");
        mList.add(c);

        c = new content("Resturant 2","address 2","https://static.pexels.com/photos/70497/pexels-photo-70497.jpeg");
        mList.add(c);

        c = new content("Resturant 3","address 3","https://static.pexels.com/photos/46239/salmon-dish-food-meal-46239.jpeg");
        mList.add(c);

        c = new content("Resturant 4","address 4","https://drop.ndtv.com/albums/COOKS/chicken-dinner/chickendinner_640x480.jpg") ;
        mList.add(c);


    }


}
