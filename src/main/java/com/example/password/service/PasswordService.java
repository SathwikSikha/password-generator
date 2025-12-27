package com.example.password.service;

import java.util.Random;

public class PasswordService {

    public static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    public static String validatePassword(String password) {
        if (password.length() < 8) return "Too short";

        boolean upper = false, lower = false, digit = false, special = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isLowerCase(c)) lower = true;
            else if (Character.isDigit(c)) digit = true;
            else special = true;
        }

        if (!upper) return "Missing uppercase";
        if (!lower) return "Missing lowercase";
        if (!digit) return "Missing digit";
        if (!special) return "Missing special character";

        return "Strong password";
    }
}
