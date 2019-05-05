package com.example.anshul.p1;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.anshul.p1.SearchAdapterCart.flagcart;

public class Payment extends AppCompatActivity {
    private Toolbar toolbar;
    private Button b1;
    private EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.mygreen));
        toolbar = (Toolbar) findViewById(R.id.toolbar_payment);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.mygreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(null);


        b1 = findViewById(R.id.b1_payment);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Payment.this,"Required Field empty",Toast.LENGTH_SHORT).show();
                }
                else if(e2.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Payment.this,"Required Field empty",Toast.LENGTH_SHORT).show();
                }
                else if(e3.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Payment.this,"Required Field empty",Toast.LENGTH_SHORT).show();
                }
                else if(e4.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(Payment.this,"Required Field empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(Payment.this,Complete.class);
                    startActivity(i);
                }

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
