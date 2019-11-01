package com.example.sharedprefexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvname;
    EditText etname;
    Button btnwel;

    public static final String My_Prefs_filename="com.example.sharedprefexamples.Names";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname=(TextView) findViewById(R.id.tvname);
        etname=(EditText) findViewById(R.id.etname);
        btnwel=(Button) findViewById(R.id.btnwel);

        SharedPreferences prefs= getSharedPreferences(My_Prefs_filename,MODE_PRIVATE);
        String user=prefs.getString("user","");

        tvname.setText("Welcome to my app"+user+"!");


        btnwel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=etname.getText().toString().trim();
                tvname.setText("Welcome to my app"+name+"!");

                SharedPreferences.Editor editor=getSharedPreferences(My_Prefs_filename,MODE_PRIVATE).edit();
                editor.putString("user",name);
                editor.commit();


            }
        });


    }
}
