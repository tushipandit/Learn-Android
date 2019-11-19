package com.example.demo_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Data extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvData=(TextView)findViewById(R.id.tvdata);

        try
        {

           ContactDB db=new ContactDB(this);
           db.open();

           tvData.setText(db.getData());


           db.close();

        }
        catch (Exception e)
        {

            Toast.makeText(Data.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }


    }
}
