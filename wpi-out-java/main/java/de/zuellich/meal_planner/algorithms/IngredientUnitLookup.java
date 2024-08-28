package de.zuellich.meal_planner.algorithms;

import de.zuellich.meal_planner.datatypes.IngredientUnit;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class IngredientUnitLookup {

    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.MonotonicNonNull IngredientUnitLookup instance;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.MonotonicNonNull Map<String, IngredientUnit> byShorthand;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.MonotonicNonNull Map<String, IngredientUnit> byPlural;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.MonotonicNonNull Map<String, IngredientUnit> bySingular;

    /**
     * Create a new instance and setup the lookup table.
     */
    @org.checkerframework.dataflow.qual.Impure
    private IngredientUnitLookup() {
        setupLookupTable();
    }

    /**
     * Get an instance.
     *
     * @return The new instance.
     */
    @org.checkerframework.dataflow.qual.Impure
    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IngredientUnitLookup getInstance() {
        if (instance == null) {
            instance = new IngredientUnitLookup();
        }
        return instance;
    }

    /**
     * Setup the maps with their values.
     */
    @org.checkerframework.dataflow.qual.Impure
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

    /**
     * Try to find the unit type by its shorthand.
     *
     * @param shorthand The shorthand to lookup.
     * @return IngredientUnit.NULL if not found.
     */
    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IngredientUnit byShorthand(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String shorthand) {
        IngredientUnit result = byShorthand.get(shorthand);
        if (result == null) {
            result = IngredientUnit.NULL;
        }
        return result;
    }

    /**
     * Try to find the unit type by its plural form.
     *
     * @param plural The string that supposedly is plural.
     * @return IngredientUnit.NULL if not found.
     */
    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IngredientUnit byPlural(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String plural) {
        IngredientUnit result = byPlural.get(plural);
        if (result == null) {
            result = IngredientUnit.NULL;
        }
        return result;
    }

    /**
     * Try to find an unit by looking up search string in all search maps.
     *
     * @param search The string to search. Can be shorthand or plural.
     * @return IngredientUnit.NULL if not found.
     */
    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IngredientUnit lookup(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String search) {
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

    /**
     * Find an ingredient unit by its singular representation.
     *
     * @param search The search string that should be the singular representation of the unit you look
     *     for.
     * @return IngredientUnit.NULL if none found.
     */
    @org.checkerframework.dataflow.qual.Pure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull IngredientUnit bySingular(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String search) {
        IngredientUnit result = bySingular.get(search);
        if (result == null) {
            result = IngredientUnit.NULL;
        }
        return result;
    }
}
