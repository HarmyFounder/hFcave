package com.hF.hFcave.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QuoteService {

    private final String URL = "https://www.goodreads.com/quotes/tag/everyday";

    public String getQuote() throws IOException {

        Document doc = Jsoup.connect(URL).get();

        Elements quotes = doc.getElementsByClass("quoteText");

        Element quote = quotes.get(0);

        return quote.text();

    }

}
