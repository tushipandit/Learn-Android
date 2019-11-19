package com.example.customhint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etfirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfirst=(AutoCompleteTextView) findViewById(R.id.etfirst);

        String [] names = {"jhonny walker" , "black dog" , "signature", "red label","mc dowells","sterling reserve"};

        //ArrayAdapter <String> adapter=
         //       new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);

        ArrayAdapter <String> adapter=
                new ArrayAdapter<>(this,R.layout.custom_design_autocomplete,names);

        etfirst.setThreshold(1); //after one word start showing autocomplete
        etfirst.setAdapter(adapter);




    }
}
