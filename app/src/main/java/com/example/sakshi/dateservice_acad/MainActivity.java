package com.example.sakshi.dateservice_acad;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity{
    TextView textView;
    Button button;
    DateService dateService;

    //service connection class
    ServiceConnection connection = new ServiceConnection() {
        @Override

        public void onServiceConnected(ComponentName name, IBinder service) {

            DateService.DemoBinder demoBinder = (DateService.DemoBinder)service;
            //getting service instance
            dateService = demoBinder.getServiceInstance();
            //getting date and time from the service
            String date_time = dateService.getInstance();
            //Setting the time and date to the TextView.
            textView.setText(date_time);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //code for disconnection
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.display);

        button = (Button) findViewById(R.id.button);
        //set on click listener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent for dateservice
                Intent boundService = new Intent(MainActivity.this,DateService.class);
                //binding service
                bindService(boundService,connection,BIND_AUTO_CREATE);
            }
        });
    }


}
