package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 922337207L;
        float floatVar = 123.45F;
        double doubleVar = 12345.6789;
        char charVar = 'A';
        boolean booleanVar = true;

        LOG.debug("byteVar: {}, shortVar: {}, intVar: {}, longVar: {}, floatVar: {}, doubleVar: {}, charVar: {}, booleanVar: {}",
                byteVar, shortVar, intVar, longVar, floatVar, doubleVar, charVar, booleanVar);
    }
}
