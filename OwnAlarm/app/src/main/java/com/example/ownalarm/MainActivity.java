package com.example.ownalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TimePicker alarmtime;

    TextClock currenttime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmtime= findViewById(R.id.timepicker);

        currenttime=findViewById(R.id.textclock);

        final  Ringtone r= RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        Timer t=new Timer();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(currenttime.getText().toString().equals(Alarmtime())){
                    r.play();
                }else {
                    r.stop();
                }

            }
        },0,1000);


    }



    public String Alarmtime()
    {

        Integer alarmhours = alarmtime.getCurrentHour();
        Integer alarmminutes=alarmtime.getCurrentMinute();
        String stringAlarmtime;

        String alarmminute;

        if (alarmminutes<10){

            alarmminute="0";
            alarmminute=alarmminute.concat(alarmminute.toString());
        }else
        {
            alarmminute=alarmminutes.toString();
        }



        if (alarmhours>12){
            alarmhours=alarmhours-12;
            stringAlarmtime=alarmhours.toString().concat(":").concat(alarmminute).concat(" PM");
        }else
        {
            stringAlarmtime = alarmhours.toString().concat(":").concat(alarmminute).concat(" AM");
        }



        return(stringAlarmtime);

    }


}
