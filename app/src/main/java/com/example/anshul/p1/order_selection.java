package com.example.anshul.p1;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.anshul.p1.Cart.list;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikepenz.actionitembadge.library.ActionItemBadge;
import com.mikepenz.actionitembadge.library.ActionItemBadgeAdder;


public class order_selection extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView iv;
    private TextView t1,t2,t3,t4;
    private Button b1,b2,b3;
    public int flag;
    private FrameLayout Circle;
    private TextView TextView;
    private MenuItem alertMenuItem;
    FrameLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_selection);


        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.mygreen));
        toolbar = (Toolbar) findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.mygreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        iv = (ImageView) findViewById(R.id.iv_order);
        Bundle extras = getIntent().getExtras();
        final String url = extras.getString("img");
        Glide.with(this).load(url).into(iv);
        final String name = extras.getString("name");
        t4 = findViewById(R.id.title_text1);
        t4.setText(name);
        getSupportActionBar().setTitle(null);
        flag = checkstring(name);
        t3 = findViewById(R.id.tv3_order);
        if(flag >=0)
        {
                        DTO_cart dto = list.get(flag);
                        t3.setText(""+dto.getQty());
        }





        final int price = extras.getInt("price");
        String contents = extras.getString("cont");
        t1 = findViewById(R.id.tv1_order);
        t2 = findViewById(R.id.tv2_order);

        t1.setText("$"+price);
        t2.setText(contents);

        b1 = findViewById(R.id.b1_order);
        b2 = findViewById(R.id.b2_order);
        b3 = findViewById(R.id.b3_order);

        if(Integer.parseInt(t3.getText().toString()) == 0)
        {
            b1.setClickable(false);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(t3.getText().toString());
                a--;
                t3.setText(Integer.toString(a));
                if(Integer.parseInt(t3.getText().toString()) == 0)
                {
                    b1.setClickable(false);
                    b3.setClickable(false);
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(t3.getText().toString());
                a++;
                t3.setText(Integer.toString(a));
                if(Integer.parseInt(t3.getText().toString()) > 0)
                {
                    b1.setClickable(true);
                    b3.setClickable(true);
                }
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = checkstring(name);
                if(flag < 0) {
                    int a = Integer.parseInt(t3.getText().toString());
                    DTO_cart d = new DTO_cart(name, url, Integer.toString(price), a);
                    list.add(d);
                }
                else
                {
                    int a = Integer.parseInt(t3.getText().toString());
                    if(a>0) {
                        DTO_cart dto = list.get(flag);
                        dto.setQty(a);
                        flag = -1;
                    }
                    else if(a==0)
                    {
                        DTO_cart dto = list.remove(flag);
                    }
                }
                Toast.makeText(order_selection.this,"Item Added to Cart",Toast.LENGTH_SHORT).show();
                updateAlertIcon();
                /*Intent i = new Intent(order_selection.this,rest_details.class);
                startActivity(i);*/





            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(TextView != null && Circle != null) {
            updateAlertIcon();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onPrepareOptionsMenu(Menu menu) {
        alertMenuItem = menu.findItem(R.id.action_cart);
        rootView = (FrameLayout) alertMenuItem.getActionView();

        Circle = (FrameLayout) rootView.findViewById(R.id.view_alert_red_circle);
        TextView = (TextView) rootView.findViewById(R.id.view_alert_count_textview);
        updateAlertIcon();

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(alertMenuItem);
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }


    private void updateAlertIcon() {
        // if alert count extends into two digits, just show the red circle
        int alertCount = list.size();
        if (alertCount >0) {
            TextView.setText(String.valueOf(alertCount));
        } else {
            TextView.setText("");
        }

        Circle.setVisibility((alertCount > 0) ? VISIBLE : GONE);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            case R.id.action_cart:
            {
                Intent i = new Intent(this,Cart.class);
                startActivity(i);
            }

        }
        return true;
    }

    int checkstring(String s)
    {
        int i = list.size();
        for(int k=0;k<i;k++)
        {
            DTO_cart dto = list.get(k);
            String s1 = dto.getName();
            if(s.compareToIgnoreCase(s1)==0)
            {

                return k;
            }
        }

        //Toast.makeText(order_selection.this,""+s,Toast.LENGTH_SHORT).show();
        return -1;
    }
}

