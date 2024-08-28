package de.zuellich.meal_planner.algorithms;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Entry point to parsing a source.
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class RecipeParserFactory {

    private final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Set<FormatDetector> formatDetectors;

    @org.checkerframework.dataflow.qual.SideEffectFree
    public RecipeParserFactory(Set<FormatDetector> formatDetectors) {
        this.formatDetectors = formatDetectors;
    }

    /**
     * Get a parser instance for the provided source.
     *
     * @param source The source that is supplied to the format detector.
     * @return A parser instance that can parse the sauce.
     */
    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull RecipeParser getParser(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String source) {
        for (FormatDetector formatDetector : formatDetectors) {
            if (formatDetector.isSupported(source)) {
                return formatDetector.getParserInstance();
            }
        }
        return new NullParser();
    }
}
