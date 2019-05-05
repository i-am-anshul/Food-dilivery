package com.example.anshul.p1;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anshul.p1.fragments.frag1;
import com.example.anshul.p1.fragments.frag2;
import com.example.anshul.p1.fragments.rest_tab1;
import com.example.anshul.p1.fragments.rest_tab2;
import com.mikepenz.actionitembadge.library.ActionItemBadge;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.anshul.p1.Cart.list;

public class rest_details extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView iv,iv1;
    private rest_tab1 obj = new rest_tab1();
    private rest_tab2 obj2 = new rest_tab2();
    private FrameLayout Circle;
    private TextView TextView;
    private MenuItem alertMenuItem;
    FrameLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_details);
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.mygreen));
        toolbar = (Toolbar) findViewById(R.id.toolbar_rest);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.mygreen));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewPager = (ViewPager) findViewById(R.id.viewpager_rest);
        setupViewPager(viewPager);

        //getting intent content and setting
        iv = (ImageView) findViewById(R.id.iv_rest);
        Bundle extras = getIntent().getExtras();
        String url = extras.getString("img");
        Glide.with(this).load(url).into(iv);
        String name = extras.getString("name");
        getSupportActionBar().setTitle(name);

        tabLayout = (TabLayout) findViewById(R.id.tabs_rest);
        tabLayout.setupWithViewPager(viewPager);
        int pos = extras.getInt("pos");


        //sending data to fragment
        Bundle bundle = new Bundle();
        bundle.putInt("pos",pos);
// Your fragment

        obj.setArguments(bundle);
        obj2.setArguments(bundle);



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

        Log.i("Click",getString(item.getItemId()));
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
    private void setupViewPager(ViewPager viewPager) {
        rest_details.ViewPagerAdapter adapter = new rest_details.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(obj, "MENU");
        adapter.addFragment(obj2, "REVIEWS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
