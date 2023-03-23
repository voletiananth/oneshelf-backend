package edu.bu.oneshelf.slot.models;

public enum WeekDay {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;





    public static WeekDay fromRequest(String day){
        return switch (day) {
            case "MONDAY" -> MONDAY;
            case "TUESDAY" -> TUESDAY;
            case "WEDNESDAY" -> WEDNESDAY;
            case "THURSDAY" -> THURSDAY;
            case "FRIDAY" -> FRIDAY;
            case "SATURDAY" -> SATURDAY;
            case "SUNDAY" -> SUNDAY;
            default -> throw new IllegalArgumentException("Invalid day");
        };
    }
}

