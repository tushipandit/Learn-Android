package com.example.fragmentrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements personadapter.itemclicked{

    TextView tvname , tvtel;
    EditText etname ,ettel;
    Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname=findViewById(R.id.tvname);
        tvtel=findViewById(R.id.tvtel);
        etname=findViewById(R.id.etname);
        ettel=findViewById(R.id.ettel);
        btnadd=findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onitemclick(int index) {
            tvname.setText(Applicationclass.people.get(index).getName());
            tvtel.setText(Applicationclass.people.get(index).getTelno());

    }
}
