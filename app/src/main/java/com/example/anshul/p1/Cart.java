package com.example.anshul.p1;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;
import static com.example.anshul.p1.SearchAdapterCart.flagcart;
public class Cart extends AppCompatActivity {

    public static List<DTO_cart> list = new ArrayList<>();
    public static int sum = 0;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SearchAdapterCart mAdapter;
    private TextView tv3;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.mygreen));
        toolbar = (Toolbar) findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.mygreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(null);


        tv3 = findViewById(R.id.t4_cart);
        recyclerView = findViewById(R.id.rv_cart);
        mAdapter = new SearchAdapterCart(list,this,tv3);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        b1 = findViewById(R.id.b3_cart);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cart.this,Address.class);
                startActivity(i);
            }
        });




    }
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:


                super.onBackPressed();
                break;
        }
        return true;
    }
}
