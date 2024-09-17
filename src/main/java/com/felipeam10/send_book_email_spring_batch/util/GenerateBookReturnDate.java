package com.felipeam10.send_book_email_spring_batch.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class GenerateBookReturnDate {

    public static int numDaysToReturn = 7;
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static String getDate(Date loan_date) {
        Calendar calendar = dateToCalendar(loan_date);
        calendar.add(Calendar.DATE, numDaysToReturn);
        String result = dateFormat.format(calendarToDate(calendar));
        return result;
    }

    private static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    private static Calendar dateToCalendar(Date loan_date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loan_date);
        return calendar;
    }

}

