package pe.lacafetalab.pao.sharedtest.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimeMother {
    public static Date random() {
        return new Date(); //MotherCreator.random().date().between(new Date("18"),new Date());
    }

    public static String randomString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(DateTimeMother.random());
    }
}
