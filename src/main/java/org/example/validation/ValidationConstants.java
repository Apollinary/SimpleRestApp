package org.example.validation;

public class ValidationConstants {
    public static final long ZERO = 0L;
    public static final int MAX_NAME_LENGTH = 255;
    public static final String REGEX_PATTERN_PHONE_NUMBER = "^\\d{11}$";
    public static final String REGEX_PATTERN_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

}
