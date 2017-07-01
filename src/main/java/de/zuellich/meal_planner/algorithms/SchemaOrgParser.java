package de.zuellich.meal_planner.algorithms;

import de.zuellich.meal_planner.datatypes.Ingredient;
import de.zuellich.meal_planner.datatypes.Recipe;
import de.zuellich.meal_planner.datatypes.RecipeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * A parser that accepts an HTML source that is schema.org conform.
 */
@Service
public class SchemaOrgParser implements RecipeParser {

    private final RecipeScanner recipeScanner;

    private final SchemaOrgIngredientScanner ingredientScanner;

    @Autowired
    public SchemaOrgParser(SchemaOrgRecipeScanner recipeScanner,
                           @Qualifier("schemaOrgIngredientScanner") SchemaOrgIngredientScanner ingredientScanner) {
        this.recipeScanner = recipeScanner;
        this.ingredientScanner = ingredientScanner;
    }

    public Recipe parse(String source) {
        List<Ingredient> ingredientList = ingredientScanner.parse(source);
        Recipe recipe = recipeScanner.parse(source);
        recipe.setIngredients(ingredientList);
        return recipe;
    }

    public RecipeFormat getFormat() {
        return RecipeFormat.SCHEMA_ORG;
    }
}
