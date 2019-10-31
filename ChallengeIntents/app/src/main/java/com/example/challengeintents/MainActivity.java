package com.example.challengeintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView ivMood,ivPhone,ivWeb,ivLocation;
    Button btnCreate;


    String name="" , address="" , number="" ,location="",mood="";

    final int Createcontactcode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.ivLocation);
        btnCreate = findViewById(R.id.btnCreate);

        ivLocation.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMood.setVisibility(View.GONE);



        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Createcontact.class);
                startActivityForResult(intent, Createcontactcode);
            }
        });

    //implicit intents
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL , Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+address));
                startActivity(intent);

            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?"+location));
                startActivity(intent);

            }
        });


    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode== Createcontactcode){

                if(resultCode== RESULT_OK){

                    ivLocation.setVisibility(View.VISIBLE);
                    ivPhone.setVisibility(View.VISIBLE);
                    ivWeb.setVisibility(View.VISIBLE);
                    ivMood.setVisibility(View.VISIBLE);

                    name=data.getStringExtra("name");
                    address=data.getStringExtra("address");
                    number=data.getStringExtra("number");
                    location=data.getStringExtra("location");
                    mood=data.getStringExtra("mood");


                    if(mood.equals("happy")){

                        ivMood.setImageResource(R.drawable.happy);

                    }else if(mood.equals("ok"))
                    {
                        ivMood.setImageResource(R.drawable.ok);
                    }
                    else{
                        ivMood.setImageResource(R.drawable.sad);
                    }


                }
                else{
                    Toast.makeText(MainActivity.this,"No data is passed",Toast.LENGTH_SHORT).show();
                }
        }

    }
}
