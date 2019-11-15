package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    ImageView im;
    EditText e11, e12, e13, e21, e22;
    String s11, s12, s13, s21, s22;
    TextView tv;
    Dialog dialog;
    Button login, signup;
    Spanned span;
    private Animation mAnimationSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
                e21 = findViewById(R.id.username);
        e22 = findViewById(R.id.password);

        im = findViewById(R.id.image11);
        tv = findViewById(R.id.signup);

        login = findViewById(R.id.login21);
        mAnimationSlide = AnimationUtils.loadAnimation(login.this, R.anim.top_btn);
        login.startAnimation(mAnimationSlide);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s21 = e21.getText().toString().replace(" ", "");
                s22 = e22.getText().toString().replace(" ", "");
                login();
            }
        });
        dialog = new Dialog(this);
        span = Html.fromHtml("<a href='h'>sign up>>></a>");
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(span);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();
            }

            private void openDialog() {
                final Dialog dialog=new Dialog(login.this);

                dialog.setContentView(R.layout.activity_signup);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                Button btnDismiss = (Button) dialog.getWindow().findViewById(R.id.dsignin);
                e11 = dialog.findViewById(R.id.fullname);
                e12 = dialog.findViewById(R.id.demail);
                e13 = dialog.findViewById(R.id.dpassword);
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s11 = e11.getText().toString().replace(" ","");
                        s12 = e12.getText().toString().replace(" ","");
                        s13 = e13.getText().toString().replace(" ","");
                        reg1();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        im.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) im.getBackground()).start();
            }
        });
    }

    public void login() {

        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "https://studentmanagement924230.000webhostapp.com/canteen/login.php";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contentEquals("success")) {
                    Toast.makeText(login.this, "login in ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, menu.class);
                    startActivity(i);

                } else {
                    Toast.makeText(login.this, "incorrect username or password", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(login.this, "data not login" + error.toString() + "", Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<String, String>();

                hm.put("e", s21);
                hm.put("p", s22);
                return hm;
            }
        };
        rq.add(sr);


    }


    public void reg1() {

        RequestQueue rq = Volley.newRequestQueue(login.this);
        String url = "https://studentmanagement924230.000webhostapp.com/canteen/register.php?";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(login.this, "Register!!!login it.", Toast.LENGTH_SHORT).show();



            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(login.this, "data not send " + error.toString() + "", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<String, String>();

                hm.put("n", s11);
                hm.put("e", s12);
                hm.put("p", s13);
                return hm;
            }
        };
        rq.add(sr);

    }
}