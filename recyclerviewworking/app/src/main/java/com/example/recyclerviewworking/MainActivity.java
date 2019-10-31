package com.example.recyclerviewworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements person_adapter.itemclicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<person> people;
    Button btnadd;



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
                people.add(new person("susan","verma","plane"));
                myAdapter.notifyDataSetChanged();//notify the change
            }
        });

        //layoutManager = new LinearLayoutManager(this);
        //set layout horizontal scrolling
        //layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);


        //set layout in the grids of rows 3
        layoutManager = new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false);



        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<person>();
        people.add(new person("tushar","shamrma","bus"));
        people.add(new person("vickey","verma","bus"));
        people.add(new person("happy","sood","plane"));
        people.add(new person("tushar","shamrma","bus"));
        people.add(new person("bhola","verma","bus"));
        people.add(new person("work","sood","plane"));



        myAdapter=new person_adapter(this , people);
        recyclerView.setAdapter(myAdapter);





    }

    @Override
    public void onitemclicked(int index) {
        Toast.makeText(this,"surname:"+people.get(index).getSurname(),Toast.LENGTH_SHORT).show();
    }
}
