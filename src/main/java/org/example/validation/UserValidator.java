package org.example.validation;

import org.example.dao.User;

import java.util.regex.Pattern;

public class UserValidator {

    private static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean isUserValid(User user) {
        return validateName(user.getFirstName()) && validateName(user.getLastName()) &&
                validateAge(user.getAge()) && validateEmail(user.getEmail()) && validatePhoneNumber(user.getPhoneNumber());
    }

    public static boolean validateName(String name) {
        return !name.isEmpty() && !(name.length() > ValidationConstants.MAX_NAME_LENGTH);
    }

    public static boolean validateAge(int age) {
        return age > 0;
    }

    public static boolean validateEmail(String email) {
        return patternMatches(email, ValidationConstants.REGEX_PATTERN_EMAIL);
    }

    public static boolean validatePhoneNumber(String phone) {
        return patternMatches(phone, ValidationConstants.REGEX_PATTERN_PHONE_NUMBER);
    }

}
