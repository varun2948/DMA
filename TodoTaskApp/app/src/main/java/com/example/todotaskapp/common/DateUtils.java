package com.example.todotaskapp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        final int startYear = calendar.get(Calendar.YEAR);
        final int starthMonth = calendar.get(Calendar.MONTH);
        final int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        String date = DateUtils.formatDate(startYear, starthMonth, startDay);
        return date;
    }

    public static String formatDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault());

        return sdf.format(date);
    }

    public static Date getDate(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault());

        return sdf.parse(dateTime);
    }

}
