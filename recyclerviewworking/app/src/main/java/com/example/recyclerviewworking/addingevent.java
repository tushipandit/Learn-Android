package com.example.recyclerviewworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addingevent extends AppCompatActivity {




    Button btnadd;
    EditText etdate,etdesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingevent);
        btnadd=findViewById(R.id.btnadd);
        etdate=findViewById(R.id.etdate);
        etdesc=findViewById(R.id.etdesc);



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
