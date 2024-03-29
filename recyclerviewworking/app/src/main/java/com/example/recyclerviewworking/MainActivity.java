package com.example.recyclerviewworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements person_adapter.itemclicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<person> people;
    Button btnadd , btnsch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);


        btnadd=findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                people.add(new person("tushar ","sharma","plane"));
                myAdapter.notifyDataSetChanged();

            }
        });



        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<person>();
        myAdapter=new person_adapter(this , people);
        recyclerView.setAdapter(myAdapter);
        people.add(new person("vinay","anand","bus"));
    }
    @Override
    public void onitemclicked(int index) {
        Toast.makeText(this,"DESCRIPTION:"+people.get(index).getName(),Toast.LENGTH_SHORT).show();
    }
}
