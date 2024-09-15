package de.zuellich.meal_planner.algorithms;
import javax.annotation.Nullable;
import de.zuellich.meal_planner.datatypes.Recipe;
import java.util.Collections;

/**
 */
public class NullRecipe extends Recipe {

    public NullRecipe() {
        super("", Collections.emptyList(), "");
    }
}
