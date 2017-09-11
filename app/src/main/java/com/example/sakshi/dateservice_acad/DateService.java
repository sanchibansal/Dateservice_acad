package com.example.sakshi.dateservice_acad;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateService extends Service {

    IBinder iBinder = new DemoBinder();
    @Override
    //onBind method to return IBinder.
    public IBinder onBind(Intent intent)
    {
        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_SHORT).show();
        return iBinder;   //returning IBinder reference.
    }

    //method for returning date and time
    public String getInstance()
    {
        //getting calender instance
        Calendar calendar = Calendar.getInstance();

        //getting minutes, hours and seconds
        String seconds = String.valueOf(calendar.get(Calendar.SECOND));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String hour = String.valueOf(calendar.get(Calendar.HOUR));

        //Getting date, month and year
        String date = String.valueOf(calendar.get(Calendar.DATE));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        //date and time string
        String date_time ="Date : "+date+"-"+month+"-"+year+"\n"+ "Time : "+hour+":"+minute+":"+seconds;
        //returning this string to the main activity
        return date_time;
    }

    class DemoBinder extends Binder
    {
        //returning instance of this service
        public DateService getServiceInstance()
        {
            return DateService.this;
        }
    }    }

