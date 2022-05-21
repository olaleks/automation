package com.stormnet.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    public static String randomEmail(){
        return (RandomStringUtils.randomAlphabetic(5) + "@yopmail.com");
    }
}
