package edu.bu.oneshelf.slot.models;

import java.util.Calendar;

public enum WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;



    public Calendar toDate(){
        int dayOrder = switch (this) {
            case MONDAY -> 2;
            case TUESDAY -> 3;
            case WEDNESDAY -> 4;
            case THURSDAY -> 5;
            case FRIDAY -> 6;
            case SATURDAY -> 7;
            case SUNDAY -> 1;
        };

        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        if (currentDay == dayOrder) {
            return Calendar.getInstance();
        } else if (dayOrder > currentDay) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, dayOrder - currentDay);
            return cal;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 7 - (currentDay - dayOrder));
            return cal;

        }
    }


}

