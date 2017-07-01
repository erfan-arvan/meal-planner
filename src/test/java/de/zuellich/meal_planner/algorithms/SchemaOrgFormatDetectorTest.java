package de.zuellich.meal_planner.algorithms;

import de.zuellich.meal_planner.FixtureBasedTest;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.mock;

/**
 * Test that we can detect recipes that are annotated in Schema.org style.
 */
public class SchemaOrgFormatDetectorTest extends FixtureBasedTest {

    @Test
    public void testCanDetectSchemaOrg() {
        SchemaOrgParser parser = mock(SchemaOrgParser.class);
        FormatDetector detector = new SchemaOrgFormatDetector(parser);

        String source = getResource("/fixtures/ingredientScanner/recipes/schema-org-01.html");
        boolean isSchemaOrgFormatted = detector.isSupported(source);
        assertTrue("Should recognize standard schema.org format." ,isSchemaOrgFormatted);

        source = getResource("/fixtures/ingredientScanner/recipes/schema-org-03.html");
        isSchemaOrgFormatted = detector.isSupported(source);
        assertFalse("Should not recognize quirky schema.org format.", isSchemaOrgFormatted);
    }

}