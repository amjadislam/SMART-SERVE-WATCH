package com.smartserve.watchapp.Utils.GeneralUtils;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.text.ParseException;
import java.util.Date;

public class DateUtilJava {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  static String dateToFullMothName(String date){
        String timeString = "";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ssZ");

        try {
            Date myDate = dateFormat.parse(date);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("dd MMM, yyyy");
            timeString = timeFormat.format(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  timeString;
    }
}
