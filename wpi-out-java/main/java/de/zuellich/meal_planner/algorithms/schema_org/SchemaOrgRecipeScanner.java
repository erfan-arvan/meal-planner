package de.zuellich.meal_planner.algorithms.schema_org;

import de.zuellich.meal_planner.algorithms.RecipeScanner;
import de.zuellich.meal_planner.datatypes.Ingredient;
import de.zuellich.meal_planner.datatypes.Recipe;
import java.util.Collections;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class SchemaOrgRecipeScanner implements RecipeScanner {

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Recipe parse(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull SchemaOrgRecipeScanner this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String source) {
        Document document = Jsoup.parse(source);
        Elements recipeRoot = document.getElementsByAttributeValue("itemtype", "http://schema.org/Recipe");
        String name = parseName(recipeRoot);
        String url = parseURL(recipeRoot);
        List<Ingredient> emptyList = Collections.emptyList();
        return new Recipe(name, emptyList, url);
    }

    /**
     * Try to extract the URL for the given recipe. If no itemprop of type URL is found inside the
     * recipe returns null.
     *
     * @param recipeRoot The element surrounding the recipes itemprops.
     * @return The URL of the recipe or an empty string if none found.
     */
    @org.checkerframework.dataflow.qual.Impure
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String parseURL(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Elements recipeRoot) {
        Elements url = recipeRoot.select("[itemprop=url]");
        if (url.isEmpty()) {
            return "";
        } else {
            return url.first().attr("href");
        }
    }

    /**
     * Try an extract the recipes name.
     *
     * @param recipeRoot The elements that wrap the recipes itemprops.
     * @return A string containing the recipe name or an empty string in case no name could be
     *     resolved.
     */
    @org.checkerframework.dataflow.qual.Impure
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String parseName(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Elements recipeRoot) {
        Elements elements = recipeRoot.select("[itemprop=name]");
        if (elements.isEmpty()) {
            return "";
        } else {
            return elements.text();
        }
    }
}
