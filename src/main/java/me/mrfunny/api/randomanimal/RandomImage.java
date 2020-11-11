package me.mrfunny.api.randomanimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomImage {

    public static final String google = "https://www.google.com/search?tbm=isch&q=";
    public static final String charset = "UTF-8";
    public static final String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";

    private static final Random random = new Random();

    public static String getRandomAnimalImage(AnimalType type) {
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

        List<String> links = getSearch(search);

        return links.get(random.nextInt(links.size() - 1));
    }

    public static String getRandomImageFromUserRequest(String request){
        List<String> links = getSearch(request);

        return links.get(random.nextInt(links.size() - 1));
    }

    public static List<String> getSearch(String search){
        List<String> resultUrls = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("http://results.dogpile.com/serp?qc=images&q=" + search).userAgent(userAgent).get();

            Elements elements = doc.select(".image a.link");

            for (Element element : elements) {
                resultUrls.add(element.attr("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultUrls;
    }
}
