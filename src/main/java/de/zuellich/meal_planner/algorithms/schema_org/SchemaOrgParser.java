package de.zuellich.meal_planner.algorithms.schema_org;
@Service
public class SchemaOrgParser implements RecipeParser {
  private final RecipeScanner recipeScanner;
  private final SchemaOrgIngredientScanner ingredientScanner;
  @Autowired
  public SchemaOrgParser(
      SchemaOrgRecipeScanner recipeScanner,
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
