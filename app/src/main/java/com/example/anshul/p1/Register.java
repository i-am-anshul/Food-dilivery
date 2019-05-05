package com.example.anshul.p1;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.anshul.p1.fragments.CustomDialog;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jacksonandroidnetworking.JacksonParserFactory;

import org.json.JSONObject;

import okhttp3.OkHttpClient;

public class Register extends AppCompatActivity {

    EditText t1, t2, t3, t4;
    Button b1,b2;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);


        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");

        TextView android = (TextView) findViewById(R.id.textView2);

        android.setTypeface(fontAwesomeFont);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });

        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        t4 = findViewById(R.id.editText4);
        b1 = findViewById(R.id.button4);
        tv1 = findViewById(R.id.tex1);
        tv2 = findViewById(R.id.tex2);
        tv3 = findViewById(R.id.tex3);



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
                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

                //======== Hide Virtual Keyboard =====================//
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);

                if ((t1.getText().toString().trim().length() < 6) ||
                        TextUtils.isEmpty(t2.getText().toString().trim()) ||
                        !(Patterns.EMAIL_ADDRESS.matcher(t2.getText().toString().trim()).matches())
                        || (t3.getText().toString().trim().length() < 6) ||
                        (!((t3.getText().toString().trim()).equals(t4.getText().toString().trim())))) {

                    if (t1.getText().toString().trim().length() < 6) {
                       tv1.setVisibility(View.VISIBLE);
                    }
                    if (TextUtils.isEmpty(t2.getText().toString().trim()) || !(Patterns.EMAIL_ADDRESS.matcher(t2.getText().toString().trim()).matches())) {
                       tv2.setVisibility(View.VISIBLE);
                    }
                    if (t3.getText().toString().trim().length() < 6) {
                        tv3.setVisibility(View.VISIBLE);
                        tv3.setText(R.string.hint_pass1);
                        t3.setText("");
                        t4.setText("");
                   }
                    if (!((t3.getText().toString().trim()).equals(t4.getText().toString().trim()))) {
                        tv3.setVisibility(View.VISIBLE);
                        tv3.setText(R.string.hint_pass2);
                        t3.setText("");
                        t4.setText("");
                }
                } else {
                    AndroidNetworking.post("http://172.104.40.244/aylifedev/webservices")
                            .addBodyParameter("action", "register")
                            .addBodyParameter("hear_about", "101")
                            .addBodyParameter("device_id", "12321")
                            .addBodyParameter("email", t2.getText().toString())
                            .addBodyParameter("password", t3.getText().toString())
                            .setTag("SIGN UP")
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
                                        /*Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(Register.this, Sign_in.class);
                                        startActivity(i);
                                        finish();*/

                                        //Dialog Box

                                       /* Dialog dialog = new Dialog(getApplication());
                                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                        dialog.setContentView(R.layout.test);
//                                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                        dialog.show();

*/
                                        DialogFragment newFragment = new CustomDialog();
                                        newFragment.show(getFragmentManager(),"poop");
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
