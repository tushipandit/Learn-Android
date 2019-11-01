package com.example.fragmentrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements personadapter.itemclicked{

    TextView tvname , tvtel;
    EditText etname ,ettel;
    Button btnadd;
    Listfrag listfrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname=findViewById(R.id.tvname);
        tvtel=findViewById(R.id.tvtel);
        etname=findViewById(R.id.etname);
        ettel=findViewById(R.id.ettel);
        btnadd=findViewById(R.id.btnadd);

        fragmentManager=this.getSupportFragmentManager();
        listfrag=(Listfrag) fragmentManager.findFragmentById(R.id.Listfrag);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etname.getText().toString().isEmpty() || ettel.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    Applicationclass.people.add(new person(etname.getText().toString().trim(),ettel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"person added sucessfully",Toast.LENGTH_SHORT).show();
                    etname.setText(null);
                    ettel.setText(null);
                    listfrag.notifydatachange();
                }


            }
        });
        onitemclick(0);

    }

    @Override
    public void onitemclick(int index) {
            tvname.setText(Applicationclass.people.get(index).getName());
            tvtel.setText(Applicationclass.people.get(index).getTelno());

    }
}
