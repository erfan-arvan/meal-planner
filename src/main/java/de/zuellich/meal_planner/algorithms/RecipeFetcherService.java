package de.zuellich.meal_planner.algorithms;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Implements methods to fetch a recipe.
 */
@Service
public class RecipeFetcherService {

    public String fetchByURL(String url) throws IOException {
        return Jsoup.connect(url).get().html();
    }

}