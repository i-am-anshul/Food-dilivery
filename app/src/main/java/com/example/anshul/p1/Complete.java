package com.example.anshul.p1;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Complete extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);


        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.mygreen));
        toolbar = (Toolbar) findViewById(R.id.toolbar_complete);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.mygreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(null);


        iv1 = findViewById(R.id.iv_complete);
        String url = "https://media0.giphy.com/media/3o6Ei2uhPW2eRv4c8M/giphy.gif";
        Glide.with(this).load(url).into(iv1);
    }

   public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent i = new Intent(Complete.this,search.class);
                startActivity(i);
                finish();
                break;
            }
        }
        return true;
    }
}
