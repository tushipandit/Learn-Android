package com.example.challengeintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Createcontact extends AppCompatActivity  implements View.OnClickListener {


    ImageView ccok , cchappy , ccsad;
    EditText etname , etadd, etnum,etloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcontact);

        etname=findViewById(R.id.etname);
        etadd=findViewById(R.id.etadd);
        etnum=findViewById(R.id.etnum);
        etloc=findViewById(R.id.etloc);

        ccok=findViewById(R.id.ccok);
        cchappy=findViewById(R.id.cchappy);
        ccsad=findViewById(R.id.ccsad);


        ccok.setOnClickListener(this);
        cchappy.setOnClickListener(this);
        ccsad.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        if(etname.getText().toString().isEmpty()||etnum.getText().toString().isEmpty()||
        etadd.getText().toString().isEmpty()||etloc.getText().toString().isEmpty()){
            Toast.makeText(this,"Enter all the fields",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name",etname.getText().toString().trim());
            intent.putExtra("address",etadd.getText().toString().trim());
            intent.putExtra("number",etnum.getText().toString().trim());
            intent.putExtra("location",etloc.getText().toString().trim());


            if(view.getId()==R.id.cchappy){

                intent.putExtra("mood", "happy");


            }else if(view.getId()==R.id.ccok){
                intent.putExtra("mood", "ok");
            }
            else{
                intent.putExtra("mood","sad");

            }

            setResult(RESULT_OK,intent);

            Createcontact.this.finish();

        }

    }

}
