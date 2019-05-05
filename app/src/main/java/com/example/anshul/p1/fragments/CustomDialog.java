package com.example.anshul.p1.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.example.anshul.p1.R;
import com.example.anshul.p1.Sign_in;

/**
 * Created by Anshul on 1/31/2018.
 */

public class CustomDialog extends DialogFragment {

    Button b1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.test, container, false);
                // Inflate the layout to use as dialog or embedded fragment
//        container.setBackgroundColor(getActivity().getResources().getColor(android.R.color.transparent));
        b1 = view.findViewById(R.id.poop);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Sign_in.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
      /*  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
*/
   //     builder.setView(inflater.inflate(R.layout.test, null));
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



     /*   */
        // Create the AlertDialog object and return it
      //  return builder.create();
        return dialog;

    }


   /* @Override
    public void onClick(View v) {
        if(R.id.poop == v.getId())
        {
            Intent i = new Intent(getActivity(), Sign_in.class);
            startActivity(i);
            getActivity().finish();
        }
    }*/
}
