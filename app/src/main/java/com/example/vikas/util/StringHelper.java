package com.example.vikas.util;

/**
 * Created by Vikas on 3/13/2016.
 */
public class StringHelper {
    public static String getComaSeparatedString(String []strings){
        if(strings != null){
            StringBuilder result = new StringBuilder();
            for(String string : strings) {
                result.append(string);
                result.append(", ");
            }
            return result.length() > 0 ? result.substring(0, result.length() - 2): "";
        }else {
                return "";
        }

    }
}
