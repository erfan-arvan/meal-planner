package de.zuellich.meal_planner.algorithms.schema_org;

import de.zuellich.meal_planner.FixtureBasedTest;
import de.zuellich.meal_planner.algorithms.AmountParser;
import de.zuellich.meal_planner.algorithms.IngredientUnitLookup;
import de.zuellich.meal_planner.algorithms.IngredientScanner;
import de.zuellich.meal_planner.datatypes.Ingredient;
import de.zuellich.meal_planner.expectations.SchemaOrgExpectations;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test an ingredient scanner that can handle quirky recipes with schema.org microdata.
 */
public class SchemaOrgQuirksModeIngredientScannerTest extends FixtureBasedTest {

    @Test
    public void canParseWronglyMarkedIngredients() {
        String recipeSource = getResource("/fixtures/ingredientScanner/recipes/schema-org-03.html");
        AmountParser amountParser = new AmountParser();
        IngredientUnitLookup ingredientUnitLookup = IngredientUnitLookup.getInstance();

        IngredientScanner scanner = new SchemaOrgQuirksModeIngredientScanner(amountParser, ingredientUnitLookup);
        List<Ingredient> ingredientList = scanner.parse(recipeSource);

        List<Ingredient> expectedIngredients = SchemaOrgExpectations.getIngredients03();
        assertEquals("Can parse quirky ingredients.", expectedIngredients, ingredientList);
    }

}