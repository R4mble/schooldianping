package com.schooldianping.util;

import java.util.regex.Pattern;

/**
 * @author Ramble
 */
public class CommonUtils {

    public static boolean isEmail(String nameOrEmail) {
        String emailPattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        return Pattern.compile(emailPattern).matcher(nameOrEmail).matches();
    }
}
