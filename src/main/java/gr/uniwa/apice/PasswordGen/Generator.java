package gr.uniwa.apice.PasswordGen;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;

public class Generator {
    private String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private String specialCharacters = "!@#$";
    private String numbers = "1234567890";
    private int len = 12;

    public String generatePwd(){
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        return RandomStringUtils.random(len,combinedChars);
    }
}

