package com.example.permissioneg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button start;
    private static final int UNIQUE_REQUEST_CODE= 29389 ;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if( requestCode==UNIQUE_REQUEST_CODE)
        {

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"thankyou ! Permission granted",Toast.LENGTH_SHORT).show();
            }
            else if(grantResults[0] ==PackageManager.PERMISSION_DENIED)
            {

                if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
                {

                    AlertDialog.Builder dialog =new AlertDialog.Builder(this);

                    dialog.setMessage("this permisson is important to save a fileto the phone!")
                            .setTitle("important permission required");

                    dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ActivityCompat.requestPermissions(MainActivity.this,new String[] { android.Manifest.permission.WRITE_EXTERNAL_STORAGE }, UNIQUE_REQUEST_CODE );
                        }

                    });


                    dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"cannot be done!",Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.show();

                }
            }
        }
        else
        {
            Toast.makeText(this, "we will newver show this to you again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=

                        PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            UNIQUE_REQUEST_CODE);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Permission granted ! Thank you", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
