package com.hF.hFcave.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {


    private final String URL = "https://www.zerochan.net/Watanabe+Akari";

    private final String TAG_NAME = "img";

    public List<String> getPhotoLinks() throws IOException {

        List<String> links = new ArrayList<>();

        Document doc = (Document) Jsoup.connect(URL).get();

        Elements photos = doc.getElementsByTag(TAG_NAME);

        for(int i = 8; i < photos.size(); i++){
            Element photo = photos.get(i);

            String photoLink = photo.attr("src");

            links.add(photoLink);

        }

        return links;
    }

}
