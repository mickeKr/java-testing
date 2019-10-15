package io.mickekr.pinkprogramming.javatesting.util;

import io.mickekr.pinkprogramming.javatesting.util.LinksExtractor;
import io.mickekr.pinkprogramming.javatesting.util.UrlFetcher;
import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;

public class LinksFetcher {
    public List<String> getLinksFrom(String url) throws IOException {
        var document = UrlFetcher.fetchPage(url);
        var links = LinksExtractor.extractLinks(document);

        return links;
    }
}
