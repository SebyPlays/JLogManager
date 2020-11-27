package de.github.sebyplays.logmanager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd_yyyy");
        Date date = new Date();
        String currentDate = simpleDateFormat.format(date);
        return currentDate;
    }

    public String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String currentTime = simpleDateFormat.format(date);
        return currentTime;
    }

}
