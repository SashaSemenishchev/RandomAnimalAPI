package me.mrfunny.api.randomanimal;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> results = RandomImage.googleSearch(args[0]);
        for(String string : results.values()){
            System.out.println(string);
        }
    }
}
