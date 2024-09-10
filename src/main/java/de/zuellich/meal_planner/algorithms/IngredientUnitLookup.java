package de.zuellich.meal_planner.algorithms;
@Service
public class IngredientUnitLookup {
  private static IngredientUnitLookup instance;
  private Map<String, IngredientUnit> byShorthand;
  private Map<String, IngredientUnit> byPlural;
  private Map<String, IngredientUnit> bySingular;
  private IngredientUnitLookup() {
    setupLookupTable();
  }
  public static IngredientUnitLookup getInstance() {
    if (instance == null) {
      instance = new IngredientUnitLookup();
    }
    return instance;
  }
  private void setupLookupTable() {
    byShorthand = new HashMap<>(IngredientUnit.values().length);
    byPlural = new HashMap<>(IngredientUnit.values().length);
    bySingular = new HashMap<>(IngredientUnit.values().length);
    for (IngredientUnit unit : IngredientUnit.values()) {
      byShorthand.put(unit.getShorthand(), unit);
      byPlural.put(unit.getPlural(), unit);
      bySingular.put(unit.getSingular(), unit);
    }
  }
  public IngredientUnit byShorthand(String shorthand) {
    IngredientUnit result = byShorthand.get(shorthand);
    if (result == null) {
      result = IngredientUnit.NULL;
    }
    return result;
  }
  public IngredientUnit byPlural(String plural) {
    IngredientUnit result = byPlural.get(plural);
    if (result == null) {
      result = IngredientUnit.NULL;
    }
    return result;
  }
  public IngredientUnit lookup(String search) {
    IngredientUnit result = byShorthand(search);
    if (!result.equals(IngredientUnit.NULL)) {
      return result;
    }
    result = byPlural(search);
    if (!result.equals(IngredientUnit.NULL)) {
      return result;
    } else {
      return bySingular(search);
    }
  }
  public IngredientUnit bySingular(String search) {
    IngredientUnit result = bySingular.get(search);
    if (result == null) {
      result = IngredientUnit.NULL;
    }
    return result;
  }
}
