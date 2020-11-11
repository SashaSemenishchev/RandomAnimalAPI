package me.mrfunny.api.randomanimal;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

public class RandomAnimal {

    public static final String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    public static final String charset = "UTF-8";

    private static Random random = new Random();

    public static String getRandomAnimalImage(AnimalType type) throws IOException {
        String search = "";
        switch (type){
            case CAT:
                search = "cat";
                break;
            case DOG:
                search = "dog";
                break;
            case FOX:
                search = "fox";
                break;
        }

        GoogleResults searchData = getSearch(search);

        return searchData.getResponseData().getResults().get(random.nextInt(searchData.getResponseData().getResults().size() - 1)).getUrl();
    }

    public static GoogleResults getSearch(String search) throws IOException {
        URL url = new URL(google + URLEncoder.encode(search, charset));
        Reader reader = new InputStreamReader(url.openStream(), charset);
        return new Gson().fromJson(reader, GoogleResults.class);
    }
}
