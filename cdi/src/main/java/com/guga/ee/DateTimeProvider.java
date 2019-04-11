package com.guga.ee;

import javax.inject.Named;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Named
public class DateTimeProvider {
    public String getCurrentDateTimeInISO8601() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
