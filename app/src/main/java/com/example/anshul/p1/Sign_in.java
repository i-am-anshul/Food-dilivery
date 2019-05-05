package com.example.anshul.p1;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;

public class Sign_in extends AppCompatActivity {

    Button b1;
    EditText t1, t2;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);


        t1 = findViewById(R.id.signt2);
        t2 = findViewById(R.id.signt3);
        tv1 = findViewById(R.id.text1);
        tv2 = findViewById(R.id.text2);
        b1 = findViewById(R.id.signb1);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(Html.fromHtml(getString(R.string.forget)));



        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");

        TextView android = (TextView) findViewById(R.id.signt1);

        android.setTypeface(fontAwesomeFont);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_in.this, MainActivity.class));
            }
        });


        //networking

        AndroidNetworking.initialize(getApplicationContext());
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.setParserFactory(new JacksonParserFactory());
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //================ Hide Virtual Key Board When  Clicking==================//

                InputMethodManager imm = (InputMethodManager)getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(b1.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

                //======== Hide Virtual Keyboard =====================//
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                if (TextUtils.isEmpty(t1.getText().toString().trim()) ||
                        !(Patterns.EMAIL_ADDRESS.matcher(t1.getText().toString().trim()).matches()) ||
                        (t2.getText().toString().trim().length() < 6)) {
                    if (TextUtils.isEmpty(t1.getText().toString().trim()) || !(Patterns.EMAIL_ADDRESS.matcher(t1.getText().toString().trim()).matches())) {
                        tv1.setVisibility(View.VISIBLE);
                    }
                    if (t2.getText().toString().trim().length() < 6) {
//                        Toast.makeText(getApplicationContext(), "Password should be atleast 6 char long", Toast.LENGTH_SHORT).show();
                        /*t2.setText("");
                        t2.clearFocus();
                        t2.setHint(R.string.hint_pass1);
                        t2.setHintTextColor(getResources().getColor(R.color.md_red_A700));
                        */
                        tv2.setVisibility(View.VISIBLE);
                        t2.setText("");
                    }
                } else {
                    AndroidNetworking.post("http://172.104.40.244/aylifedev/webservices")
                            .addBodyParameter("action", "login")
                            .addBodyParameter("country_id", "101")
                            .addBodyParameter("city_id", "Ajmer")
                            .addBodyParameter("device_id", "12321")
                            .addBodyParameter("email", t1.getText().toString())
                            .addBodyParameter("password", t2.getText().toString())
                            .setTag("LOGIN")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    String s = null;
                                    String t = null;
                                    try {
//                                            JSONObject root = new JSONObject(response);
                                            /*JSONObject root = response.getJSONObject("data");

                                            JSONArray array= root.getJSONArray("news");
*/
                                        s = response.getString("status");
                                        t = response.getString("message");
                                    } catch (Exception e) {
                                        Log.e("Json Object", "Json object");
                                    }
                                    if (s.equals("true")) {
                                        Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(Sign_in.this, search.class);
                                        startActivity(i);
                                        finish();
                                    } else {

                                        Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
                                    }


                                }

                                @Override
                                public void onError(ANError error) {
                                    // handle error
                                }
                            });
                }
            }
        });
    }
}
