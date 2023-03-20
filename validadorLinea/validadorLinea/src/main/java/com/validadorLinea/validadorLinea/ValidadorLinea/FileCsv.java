package com.validadorLinea.validadorLinea.ValidadorLinea;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCsv implements ValidadorLinea {


    @Override
    public boolean validar(String linea) {


        String[] partes = linea.split(",");
        String email = partes[1];
        String dateOfBirth = partes[2];
        String jobTitle = partes[3];

        if(
                isValidEmail(email)
                &&isValidDateOfBirth(dateOfBirth)
              &&isValidJobTitle(jobTitle)


        ){

            return true;
        }


        return false;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidDateOfBirth(String dob) {
//        String dateRegex = "^19[8-9]\\d{1}-[0-1]\\d{1}-[0-3]\\d{1}$"; // Validar formato AAAA-MM-DD
//        Pattern pattern = Pattern.compile(dateRegex);
//        Matcher matcher = pattern.matcher(dob);
//        if (!matcher.matches()) {
//            return false;
//        }
        if(dob.equalsIgnoreCase("Date of birth")){
            return false;
        }
        String[] dateParts = dob.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        if (year < 1980) {
            return false;
        }
        return true;
    }

    public static boolean isValidJobTitle(String jobTitle) {
        String[] validTitles = {"Haematologist", "Phytotherapist", "Building surveyor", "Insurance account manager",
                "Educational psychologist"};
        for (String validTitle : validTitles) {
            if (jobTitle.equals(validTitle)) {
                return true;
            }
        }
        return false;
    }

}
