package com.dartrox.course.springboot.service.demo.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

    private static final ZoneId UTC = ZoneId.of("UTC");

    public static ZonedDateTime getCurrentZonedDateTime() {
        return ZonedDateTime.now(UTC);
    }

    public static ZonedDateTime convertDateToZonedDateTime(Date date) {
        return date.toInstant().atZone(UTC);
    }

    public static Date convertZonedDateTimeToDate(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    public static ZonedDateTime currentZonedDateTimePlusMinutes(int minutes) {
        ZonedDateTime currentDateTime = getCurrentZonedDateTime();
        return currentDateTime.plusMinutes(minutes);
    }

    public static String getCurrentDateTimeString() {
        ZonedDateTime mexicoCityDateTime = getCurrentZonedDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return mexicoCityDateTime.format(formatter);
    }
}
