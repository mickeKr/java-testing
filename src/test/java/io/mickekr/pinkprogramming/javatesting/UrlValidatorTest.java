package io.mickekr.pinkprogramming.javatesting;

import static org.junit.jupiter.api.Assertions.*;

import io.mickekr.pinkprogramming.javatesting.util.LinksFetcher;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrlValidatorTest {
    private LinksFetcher linksFetcher;
    private String url;

    @BeforeEach
    void setUp() {
        url = "https://www.pinkprogramming.se/";
        linksFetcher = new LinksFetcher();
    }

    @Test
    void allFetchedLinksShouldBeValid() throws IOException {
        List<String> links = linksFetcher.getLinksFrom(url);
        System.out.println(links);

        assertTrue(links.stream().allMatch(UrlValidator::isValid));
    }

    @Test
    void shouldFailBecauseOfUrlMissingProtocol() {
        //Missing protocol
        List<String> links = List.of("www.aftonbladet.se");

        assertFalse(links.stream().allMatch(UrlValidator::isValid));
    }

    @Test
    void shouldFailBecauseOfWhitespace() {
        //java.net.URISyntaxException: Illegal character in authority at index 7: http://www. aftonbladet.se
        List<String> links = List.of("http://www. aftonbladet.se");

        assertFalse(links.stream().allMatch(UrlValidator::isValid));
    }
}
