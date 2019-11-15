package com.example.canteen;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class menu extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private AdView mAdView;
ImageView im;
ListView lv;
String[] name={"Break Fast","Lunch","Snacks","Fast Food"};
    String s1,n1;
Integer [] image={R.drawable.b1, R.drawable.l1, R.drawable.s1, R.drawable.f1};
ArrayAdapter<String> adp;

    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        dialog=new Dialog(this);
        lv=findViewById(R.id.list);

        custom c=new custom(menu.this,name,image);
        lv.setAdapter(c);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s1=name[i];
                switch (i){
                    case 0:
                    {
                        n1="1";
                        Intent m=new Intent(menu.this, breakfastinfo.class);
                        m.putExtra("key",n1);
                        m.putExtra("img",s1);
                        startActivity(m);
                        break;
                    }


                    case 1:
                    {n1="2";
                        Intent m=new Intent(menu.this, breakfastinfo.class);
                        m.putExtra("key",n1);
                        m.putExtra("img",s1);
                        startActivity(m);
                        break;
                    }

                    case 2:
                    {n1="3";
                        Intent m=new Intent(menu.this, breakfastinfo.class);
                        m.putExtra("key",n1);
                        m.putExtra("img",s1);
                        startActivity(m);
                        break;
                    }


                    case 3:
                    {n1="4";
                        Intent m=new Intent(menu.this, breakfastinfo.class);
                        m.putExtra("img",s1);
                        m.putExtra("key",n1);
                        startActivity(m);
                        break;
                    }
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {

        switch (pos){
        case 0: {
            dialog.setContentView(R.layout.breakfastimg);
            dialog.show();
            break;
        }
            case 1: {
                dialog.setContentView(R.layout.lunchimg);
                dialog.show();
                break;
            }
            case 2: {
                dialog.setContentView(R.layout.snackimg);
                dialog.show();
                break;
            }
            case 3: {
                dialog.setContentView(R.layout.fastimg);
                dialog.show();
                break;
            }

}
                return true;
            }
        });
        im=findViewById(R.id.image12);
        im.post(new Runnable() {
            @Override
            public void run() {
                ( (AnimationDrawable)im.getBackground()).start();
            }
        });
    }

}
