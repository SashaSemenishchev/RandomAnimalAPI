package me.mrfunny.api.randomanimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RandomImage {

    public static final String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
    public static final String imageSearch = "http://results.dogpile.com/serp?qc=images&q=";
    public static final String googleSearch = "https://www.google.com/search?q=";

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

        List<String> links = getSearch(imageSearch, search, ".image a.link");

        return links.get(random.nextInt(links.size() - 1));
    }

    public static String getRandomImageFromUserRequest(String request){
        List<String> links = getSearch(imageSearch, request, ".image a.link");

        return links.get(random.nextInt(links.size() - 1));
    }

    public static HashMap<String, String> googleSearch(String request){
        HashMap<String, String> results = new HashMap<>();
        try {
            Document doc = Jsoup.connect(URLDecoder.decode(URLEncoder.encode(googleSearch + request, "UTF-8"), "UTF-8")).userAgent(userAgent).get();

            Elements elements = doc.select("h3 > span");


            for(Element e: elements){
                String link = e.parent().parent().attr("href");
                String title = e.text();
                if(link.startsWith("http"))
                    results.put(link, title);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static List<String> getSearch(String searcher, String search, String selector){
        List<String> resultUrls = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(searcher + search).userAgent(userAgent).get();

            Elements elements = doc.select(selector);

            for (Element element : elements) {
                resultUrls.add(element.attr("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultUrls;
    }

}
