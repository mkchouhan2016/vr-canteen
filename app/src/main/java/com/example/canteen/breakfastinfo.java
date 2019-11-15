package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class breakfastinfo extends AppCompatActivity {


    ImageView mImageView,mImageView2,mImageView3,mImageView4,mImageView5;
    StorageReference storageRef,storageRef1,storageRef2,storageRef3,storageRef4;
    FirebaseStorage storage;


    Context context;
    TextView tv,tv2,tv3,tv4,tv5,pname,pname2,pname3,pname4,pname5,pprice,pprice2,pprice3,pprice4,pprice5;
    Button increment,decrement,increment2,decrement2,increment3,decrement3,increment4,decrement4,increment5,decrement5,pickerBtn;

    String name1 = "";
    String price1 = "";
    String name2 = "";
    String price2 = "";

    String name3 = "";
    String price3 = "";
    String name4 = "";
    String price4 = "";
    String name5 = "";
    String price5 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfastinfo);

        getSupportActionBar().hide();

        pname=findViewById(R.id.pname);
        pname2=findViewById(R.id.pname2);
        pname3=findViewById(R.id.pname3);
        pname4=findViewById(R.id.pname4);
        pname5=findViewById(R.id.pname5);
        pprice=findViewById(R.id.pprice);
        pprice2=findViewById(R.id.pprice2);
        pprice3=findViewById(R.id.pprice3);
        pprice4=findViewById(R.id.pprice4);
        pprice5=findViewById(R.id.pprice5);




        tv=(TextView)findViewById(R.id.textView1);
        increment=(Button)findViewById(R.id.button_increment);
        decrement=(Button)findViewById(R.id.button_decrement);

        tv2=(TextView)findViewById(R.id.textView2);
        increment2=(Button)findViewById(R.id.button_increment2);
        decrement2=(Button)findViewById(R.id.button_decrement2);

        tv3=(TextView)findViewById(R.id.textView3);
        increment3=(Button)findViewById(R.id.button_increment3);
        decrement3=(Button)findViewById(R.id.button_decrement3);

        tv4=(TextView)findViewById(R.id.textView4);
        increment4=(Button)findViewById(R.id.button_increment4);
        decrement4=(Button)findViewById(R.id.button_decrement4);

        tv5=(TextView)findViewById(R.id.textView5);
        increment5=(Button)findViewById(R.id.button_increment5);
        decrement5=(Button)findViewById(R.id.button_decrement5);


        pickerBtn=(Button)findViewById(R.id.pickerBtn);
getData();
        context=this;

        increment.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;
                tv.setText(String.valueOf(present_value_int));
            }
      //      Snackbar snackbar= Snackbar

        });


        decrement.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>0){
                    present_value_int--;
                    tv.setText(String.valueOf(present_value_int));
                }

            }
        });

     ///increment2
        increment2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv2.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;
                tv2.setText(String.valueOf(present_value_int));
            }
        });


        decrement2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv2.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>0){
                    present_value_int--;
                    tv2.setText(String.valueOf(present_value_int));
                }
            }
        });
///increment3
        increment3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv3.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;
                tv3.setText(String.valueOf(present_value_int));
            }
        });


        decrement3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv3.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>0){
                    present_value_int--;
                    tv3.setText(String.valueOf(present_value_int));
                }
            }
        });
        ///increment4
        increment4.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv4.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;
                tv4.setText(String.valueOf(present_value_int));
            }
        });


        decrement4.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv4.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>0){
                    present_value_int--;
                    tv4.setText(String.valueOf(present_value_int));
                }
            }
        });
//increment5
        increment5.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv5.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;
                tv5.setText(String.valueOf(present_value_int));
            }
        });


        decrement5.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv5.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>0){
                    present_value_int--;
                    tv5.setText(String.valueOf(present_value_int));
                }
            }
        });




        pickerBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                int np1=Integer.parseInt(price1);
                int np2=Integer.parseInt(price2);
                int np3=Integer.parseInt(price3);
                int np4=Integer.parseInt(price4);
                int np5=Integer.parseInt(price5);
                //Intent i = new Intent("com.iphonik.chameleon.AppPreferenceActivity");
                Intent i=new Intent(breakfastinfo.this,finalpage.class);
                i.putExtra("order",name1);
                i.putExtra("order2",name2);
                i.putExtra("order3",name3);
                i.putExtra("order4",name4);
                i.putExtra("order5",name5);
                String present_value_string = tv.getText().toString();
                int n1=Integer.parseInt(present_value_string);
                int a=np1*n1;
                String m = Integer.toString(a);
                i.putExtra("price",m);
                i.putExtra("qty",present_value_string);
                //
                String present_value_string2 = tv2.getText().toString();
                int n2=Integer.parseInt(present_value_string2);
                int b=np2*n2;
                String m2 = Integer.toString(b);
                i.putExtra("price2",m2);
                i.putExtra("qty2",present_value_string2);
                //
                String present_value_string3 = tv3.getText().toString();
                int n3=Integer.parseInt(present_value_string3);
                int c=np3*n3;
                String m3 = Integer.toString(c);
                i.putExtra("price3",m3);
                i.putExtra("qty3",present_value_string3);
                //
                String present_value_string4 = tv4.getText().toString();
                int n4=Integer.parseInt(present_value_string4);
                int d=np4*n4;
                String m4 = Integer.toString(d);
                i.putExtra("price4",m4);
                i.putExtra("qty4",present_value_string4);
                ///
                String present_value_string5 = tv5.getText().toString();
                int n5=Integer.parseInt(present_value_string5);
                int e=np5*n5;
                String m5 = Integer.toString(e);
                int totalamt=a+b+c+d+e;
                String amount=Integer.toString(totalamt);
                i.putExtra("totalamt",amount);
                i.putExtra("price5",m5);
                i.putExtra("qty5",present_value_string5);


                startActivity(i);
               // Toast.makeText(getApplication(), "present value:-"+present_value_string,Toast.LENGTH_LONG).show();

            }

        });


        mImageView=findViewById(R.id.image21);
        mImageView2=findViewById(R.id.image22);

        mImageView3=findViewById(R.id.image23);
        mImageView4=findViewById(R.id.image24);

        mImageView5=findViewById(R.id.image25);
        storage = FirebaseStorage.getInstance();


        Intent intent=getIntent();
        String str=intent.getStringExtra("img");
if(str.contentEquals("Break Fast"))
{
        storageRef = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("poha.jpg");
        storageRef1 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("paratha.jpg");
        storageRef2 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("dosa2.jpg");
        storageRef3 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("shambhar.jpg");
        storageRef4 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("cholekulche.jpg");
}

else if(str.contentEquals("Lunch"))
{


    storageRef = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("dalmakhani.jpg");
    storageRef1 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("paneerraita.JPG");
    storageRef2 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("mixveg2.jpg");
    storageRef3 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("palak.jpg");
    storageRef4 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("paneerbutter.jpg");
}
else if(str.contentEquals("Snacks"))
{


    storageRef = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("rava.jpg");
    storageRef1 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("crispy.jpg");
    storageRef2 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("breadroll.jpg");
    storageRef3 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("vegtava.jpg");
    storageRef4 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("cheese.jpeg");
}

else if(str.contentEquals("Fast Food"))
{


    storageRef = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("pizza.jpeg");
    storageRef1 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("sandwich.jpeg");
    storageRef2 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("patty.jpg");
    storageRef3 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("wrap2.jpg");
    storageRef4 = storage.getReferenceFromUrl("gs://canteen-eeb8b.appspot.com").child("chowmein.jpeg");
}
        try {
            final File localFile = File.createTempFile("images", "jpg");
            storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    mImageView.setImageBitmap(bitmap);
                    mImageView2.setImageBitmap(bitmap);
                    mImageView3.setImageBitmap(bitmap);
                    mImageView4.setImageBitmap(bitmap);
                    mImageView5.setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure( Exception exception) {

                }
            });
        } catch (IOException e )
        {

        }
        final long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageView.setImageBitmap(bitmap);
                //mImageView1.setImageBitmap(bitmap);
            }
        });
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        });

        storageRef1.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageView2.setImageBitmap(bitmap);
                //mImageView1.setImageBitmap(bitmap);
            }
        });
        storageRef1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        });

        storageRef2.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageView3.setImageBitmap(bitmap);
                //mImageView1.setImageBitmap(bitmap);
            }
        });
        storageRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        });

        storageRef3.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageView4.setImageBitmap(bitmap);
                //mImageView1.setImageBitmap(bitmap);
            }
        });
        storageRef3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        });

        storageRef4.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                mImageView5.setImageBitmap(bitmap);
                //mImageView1.setImageBitmap(bitmap);
            }
        });
        storageRef4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        });

 }
    public void getData()

    {
        Intent intent=getIntent();
        String s1=intent.getStringExtra("key");


        RequestQueue rq = Volley.newRequestQueue(breakfastinfo.this);
        String url = config.DATA_URL + s1;
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ShowJson(response);
                // Toast.makeText(songinfo.this, " ", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Toast.makeText(songinfo.this, " " + error, Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sr);
    }

    public void ShowJson(String response) {

        try {
            JSONObject jo = new JSONObject(response);

            JSONArray jr = jo.getJSONArray(config.KEY_RESULT);
            JSONObject jt = jr.getJSONObject(0);
            name1 = jt.getString(config.KEY_NAME1);
            price1= jt.getString(config.KEY_PRICE1);
            name2 = jt.getString(config.KEY_NAME2);
            price2 = jt.getString(config.KEY_PRICE2);
            name3 = jt.getString(config.KEY_NAME3);
            price3= jt.getString(config.KEY_PRICE3);
            name4 = jt.getString(config.KEY_NAME4);
            price4 = jt.getString(config.KEY_PRICE4);
            name5 = jt.getString(config.KEY_NAME5);
            price5 = jt.getString(config.KEY_PRICE5);
        } catch (JSONException e) {

        }
        pname.setText(name1);
        pprice.setText(price1);
        pname2.setText(name2);
        pprice2.setText(price2);
        pname3.setText(name3);
        pprice3.setText(price3);
        pname4.setText(name4);
        pprice4.setText(price4);
        pname5.setText(name5);
        pprice5.setText(price5);


        //  Toast.makeText(songinfo.this,"infor:"+artist1+movie1+released1+duration1,Toast.LENGTH_SHORT).show();

    }
}
