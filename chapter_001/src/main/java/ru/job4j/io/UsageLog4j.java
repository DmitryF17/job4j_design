package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        String name = "Dmitry";

        byte age = 49;
        char gender = 'm';
        short weight = 77;
        int height = 175;
        long pulse = 70;
        float yearinthecourse = 0.5F;
        double coursedone = 0.33;
        boolean understandenglish = true;

        LOG.debug("User info name : {}, age : {}, gender : {}, weight : {}, height : {},"
                       + " understand english : {}, pulse : {}, course done : {}, year in the course : {}",
                name, age, gender, weight, height, understandenglish, pulse, coursedone, yearinthecourse);

    }
}
