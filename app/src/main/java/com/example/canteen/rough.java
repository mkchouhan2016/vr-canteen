package com.example.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.travijuu.numberpicker.library.NumberPicker;

public class rough extends AppCompatActivity {
    int minteger = 0;
    Context context;
    TextView tv;
    Button increment,decrement,pickerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough);
        tv=(TextView)findViewById(R.id.textView1);

        increment=(Button)findViewById(R.id.button_increment);
        decrement=(Button)findViewById(R.id.button_decrement);
        pickerBtn=(Button)findViewById(R.id.pickerBtn);

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
        });


        decrement.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                if(present_value_int>1){
                    present_value_int--;
                    tv.setText(String.valueOf(present_value_int));
                }
            }
        });


        pickerBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String present_value_string = tv.getText().toString();
                Toast.makeText(getApplication(), "present value:-"+present_value_string,                                                Toast.LENGTH_LONG).show();

            }

        });

    }
/*
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }
*/

}
