package com.tvn;

import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static boolean laNguyenAm(Character a) {
        boolean laNguyenAm;
        switch (a) {
            case 'e':
            case 'o':
            case 'a':
            case 'u':
            case 'i':
            case 'E':
            case 'O':
            case 'A':
            case 'U':
            case 'I':
                laNguyenAm = true;
                break;
            default:
                laNguyenAm = false;
        }
        return laNguyenAm;
    }

    public static boolean laNguyenAm(String str) {
        String upperCasestr = str.toUpperCase();
        boolean laNguyenAm = false;
        switch (upperCasestr) {
            case "A":
                laNguyenAm = true;
                break;
            case "E":
                laNguyenAm = true;
                break;
            case "O":
                laNguyenAm = true;
                break;
            case "U":
                laNguyenAm = true;
                break;
            case "I":
                laNguyenAm = true;
                break;
            default:
                System.out.println(str + " la phu am");
        }
        return laNguyenAm;
    }

    public static boolean laSoNguyenTo(int N) {
        boolean laSoNguyenTo = true;
        for (int i = 2; i < N - 1; i++) {
            if (N % i == 0) {
                laSoNguyenTo = false;
                break;
            }
        }
        return laSoNguyenTo;
    }

    public static boolean laNamNhuan(int nam) {
        if ((nam % 4 == 0) && (nam % 100 != 0)) {
            return true;
        }
        return false;
    }


    public static boolean isPasswordComplex(String password){
        if(hon_10_ky_tu(password)&&
        co_chua_ky_tu_dac_biet(password)&&
        co_chua_so(password)&&
        co_chua_ky_tu_viet_hoa(password)&&
        co_chua_ky_tu_vietthuong(password)){
            return true;
        }else return false;
    }
    public static boolean hon_10_ky_tu(String password){
        if(password.length()>10){
            return true;
        }else return false;
    }
    public static boolean co_chua_ky_tu_viet_hoa(String password){
        char[] passwords = password.toCharArray();
        boolean isContainUpperCases = false;
        for (char c : passwords) {
            if(Character.isUpperCase(c)){
                isContainUpperCases = true;
                break;
            }
        }
        return isContainUpperCases;
    }

    public static boolean co_chua_ky_tu_vietthuong(String password){
        char[] passwords = password.toCharArray();
        boolean isContainLowerCases = false;
        for (char c : passwords) {
            if(Character.isLowerCase(c)){
                isContainLowerCases = true;
                break;
            }
        }
        return isContainLowerCases;
    }

    public static boolean co_chua_so(String password){
        char[] passwords = password.toCharArray();
        boolean isContainNumber = false;
        System.out.println(passwords[3]);
        for (char c : passwords) {
            if(Character.isDigit(c)){
                isContainNumber = true;
                break;
            }
        }
        return isContainNumber;
    }
    public static boolean co_chua_ky_tu_dac_biet(String password){
        char[] passwords = password.toCharArray();
        boolean isContainSpecialChars = false;
        char[] acceptSpecialChars = {'@', '!','$','%','^','&'};
        for (char c : passwords) {
            for(char s: acceptSpecialChars){
                if (c == s){
                    isContainSpecialChars =true;
                }
            }
        }
        return isContainSpecialChars;
    }

}
