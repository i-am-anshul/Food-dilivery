package com.example.anshul.p1.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.anshul.p1.R;
import com.example.anshul.p1.SearchAdapterRest2;
import com.example.anshul.p1.cont_rest2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshul on 1/18/2018.
 */

public class rest_tab2 extends Fragment {
    public rest_tab2() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View mView;
    private List<cont_rest2> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchAdapterRest2 mAdapter;
    private RatingBar ratingBar;
    private TextView tv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.rest_tab2, container, false);
        tv = mView.findViewById(R.id.tv_rest_tab_2);
        //Rating Bar Contents
        ratingBar = (RatingBar) mView.findViewById(R.id.ratingbar_rest_tab2);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        DrawableCompat.setTint(stars,getResources().getColor(R.color.myyellow));
        // RaTING bAR cONTENTS


        int position = getArguments().getInt("pos");
        if(position == 0)
        {
            prepData1();
            ratingBar.setRating(4);
            tv.setText("No of Reviews: 4");
        }
        else if(position == 1)
        {
            prepData2();
            ratingBar.setRating(3);
            tv.setText("No of Reviews: 3");
        }
        else if(position == 2)
        {
            prepData3();
            ratingBar.setRating(2);
            tv.setText("No of Reviews: 2");
        }
        else
        {
            prepData4();
            ratingBar.setRating(1);
            tv.setText("No of Reviews: 1");
        }

        recyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view_rest2);
        mAdapter = new SearchAdapterRest2(mList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        return mView;
    }
    private void prepData1() {
        cont_rest2 c = new cont_rest2("Pushpa","http://3clled11q3sh22wztq2szj1z.wpengine.netdna-cdn.com/wp-content/uploads/2016/07/Facebook-censorship.jpg","waah!! kya baat hai majja aa gya... bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","4 Nov 2017",4);
        mList.add(c);

        c = new cont_rest2("Kamla","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","soogla hai  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","4 nov 2015",1);
        mList.add(c);

        c = new cont_rest2("Kaalu","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","badiya hai bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","6 nov 2018",5);
        mList.add(c);

        c = new cont_rest2("poplu","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","jordaar banaya khana bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","6 nov 2018",4);
        mList.add(c);
    }

    private void prepData2() {
        cont_rest2 c = new cont_rest2("Kaalu","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","badiya hai bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","6 nov 2018",5);
        mList.add(c);

        c = new cont_rest2("poplu","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","jordaar banaya khana  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","6 nov 2018",4);
        mList.add(c);

        c = new cont_rest2("Kamla","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","soogla hai  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","4 nov 2015",1);
        mList.add(c);

    }

    private void prepData3() {
        cont_rest2 c = new cont_rest2("poplu","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","jordaar banaya khana  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","6 nov 2018",4);
        mList.add(c);

        c = new cont_rest2("Kamla","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","soogla hai  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","4 nov 2015",1);
        mList.add(c);
    }

    private void prepData4() {
        cont_rest2 c = new cont_rest2("Pushpa","http://media.beliefnet.com/~/media/photos-with-attribution/entertainment/celebrities/Mark_Zuckerberg.jpg","waah!! kya baat hai majja aa gya  bhaut lamba review dunga main just because i am so jobless aur mere saturday ki chutti bhi hai isliye mujhe 10000 lines ka review dene me koi problem nai hai","4 Nov 2017",4);
        mList.add(c);
    }

}
