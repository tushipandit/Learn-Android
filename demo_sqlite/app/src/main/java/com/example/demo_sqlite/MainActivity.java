package com.example.demo_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText etname,etcell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=(EditText)findViewById(R.id.etname);
        etcell=(EditText)findViewById(R.id.etcell);




    }

    public void btnSubmit(View v){

        String name=etname.getText().toString().trim();
        String cell=etcell.getText().toString().trim();

        try{

            ContactDB db = new ContactDB(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(MainActivity.this,"Sucessfully saved!",Toast.LENGTH_SHORT).show();
            etname.setText("");
            etcell.setText("");


        }
        catch(Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }


    }

    public void btnShowdata(View v){

        startActivity(new Intent(this,Data.class));


    }
    public void btnEditdata(View v){

        try
        {
            ContactDB db=new ContactDB(this);
            db.open();
            db.updateEntry("1","blenders","75824565");
            db.close();
            Toast.makeText(MainActivity.this, "Sucessfully updated", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e)
        {

            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();


        }


    }
    public void btndeletedata(View v){

        try
        {
            ContactDB db =new ContactDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(MainActivity.this,"deleted sucessfully",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {

            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }

    }




}
