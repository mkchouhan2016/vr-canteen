package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class finalpage extends AppCompatActivity {
TextView ordername11,orderprice11,orderqty11,ordername12,orderprice12,orderqty12,ordername13,orderprice13,orderqty13
        ,ordername14,orderprice14,orderqty14,ordername15,orderprice15,orderqty15,finalamt;
Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        getSupportActionBar().hide();
        finalamt=findViewById(R.id.finalamt);
        edit=findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(finalpage.this,menu.class);
                startActivity(i);
            }
        });

        ordername11=findViewById(R.id.ordername);
        orderprice11=findViewById(R.id.orderamt);
        orderqty11=findViewById(R.id.orderqty);

        ordername12=findViewById(R.id.ordername2);
        orderprice12=findViewById(R.id.orderamt2);
        orderqty12=findViewById(R.id.orderqty2);

        ordername13=findViewById(R.id.ordername3);
        orderprice13=findViewById(R.id.orderamt3);
        orderqty13=findViewById(R.id.orderqty3);

        ordername14=findViewById(R.id.ordername4);
        orderprice14=findViewById(R.id.orderamt4);
        orderqty14=findViewById(R.id.orderqty4);

        ordername15=findViewById(R.id.ordername5);
        orderprice15=findViewById(R.id.orderamt5);
        orderqty15=findViewById(R.id.orderqty5);

        Intent intent=getIntent();
        String product=intent.getStringExtra("order");
        String s11=product.substring(0,4)+"....";
        String s12=intent.getStringExtra("qty");
        String s13=intent.getStringExtra("price");

        String product2=intent.getStringExtra("order2");
        String s21=product2.substring(0,4)+"....";
        String s22=intent.getStringExtra("qty2");
        String s23=intent.getStringExtra("price2");

        String product3=intent.getStringExtra("order3");
        String s31=product3.substring(0,4)+"....";
        String s32=intent.getStringExtra("qty3");
        String s33=intent.getStringExtra("price3");

        String product4=intent.getStringExtra("order4");
        String s41=product4.substring(0,4)+"....";
        String s42=intent.getStringExtra("qty4");
        String s43=intent.getStringExtra("price4");

        String product5=intent.getStringExtra("order5");
        String s51=product5.substring(0,4)+"....";
        String s52=intent.getStringExtra("qty5");
        String s53=intent.getStringExtra("price5");


        String totalprice=intent.getStringExtra("totalamt");
        finalamt.setText(totalprice);

        ordername11.setText(s11);
        orderqty11.setText(s12);
        orderprice11.setText(s13);

        ordername12.setText(s21);
        orderqty12.setText(s22);
        orderprice12.setText(s23);

        ordername13.setText(s31);
        orderqty13.setText(s32);
        orderprice13.setText(s33);

        ordername14.setText(s41);
        orderqty14.setText(s42);
        orderprice14.setText(s43);

        ordername15.setText(s51);
        orderqty15.setText(s52);
        orderprice15.setText(s53);
    }
}
